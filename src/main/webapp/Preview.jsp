<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="utf-8">
<link rel="shortcut icon" type="image/ico" href="<%=request.getContextPath()%>/images/favicon.png" />
<link rel="bookmark" type="image/ico" href="<%=request.getContextPath()%>/images/favicon.png">
<link href="<%=request.getContextPath()%>/css/modern.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/modern-responsive.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/site.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/js/google-code-prettify/prettify.css" rel="stylesheet"
	type="text/css">

<script type="text/javascript" src="<%=request.getContextPath()%>/js/assets/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/assets/jquery.mousewheel.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/assets/moment.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/assets/moment_langs.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/modern/dropdown.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/modern/accordion.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/modern/buttonset.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/modern/carousel.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/modern/input-control.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/modern/pagecontrol.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/modern/rating.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/modern/slider.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/modern/tile-slider.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/modern/tile-drag.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/modern/calendar.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/modern/dialog.js"></script>

<title>数据连接监控</title>
</head>
<body class="metrouicss">
	 <%@ include file="navbar.jsp" %>
	<div class="page" id="page-index" >
		<div class="page-region">
			<div class="page-region-content">
				起始时间：<input id="startTime" type="text" value="" />
				&nbsp;&nbsp;&nbsp;终止时间：<input id="endTime" type="text" value=""/>
				<button id="query" class="bg-color-blue" style="color :#ffffff">查看</button>
				<button id="clear" class="bg-color-blue" style="color :#ffffff">清空</button>
				<button id="draggableDialog" style="display:none"></button>
			</div>
			<div>
				<table class="hovered striped bordered" align="center">
					<caption>
						可用连接预览
					</caption>
					<thead>
						<tr>
							<th class="right" style="width:15%">连接名称</th>
							<th class="width:35%">健康度</th>
							<th class="right" style="width:25%">请求次数</th>
							<th class="right" style="width:25%">失败次数</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
					<tfoot></tfoot>
				</table>
			</div>
		</div>
	</div>
	 <%@ include file="foot.jsp" %>
	<script type="text/javascript">
		$(function() {
			$("#query").bind("click",query);
			$("#clear").bind("click",function(){
				$("#startTime,#endTime").val("");
			});
			 $('#draggableDialog').click(function(e) {
                            $.Dialog({
                                'title'      : '日期格式错误',
                                'content'    : '请输入正确的日期格式!<br />格式:<b>yyyyMMddhhmmss</b><br />例如:<b>20130101000000</b>',
                                'draggable'  : true,
                                'buttonsAlign': 'right',
                                'buttons'    : {
                                    '确定'    : {
                                        'action': function(){
                                        	errorEl.focus();
                                        }
                                    }
                                }
                            });
                        });
              doQuery("20130101000000","20140101000000");
		})
		function valTest(e){
			var regex=/^\d{14}$/;
			return regex.test(e.value);
		}
		function query(){
			var startTime=document.getElementById("startTime");
			var endTime=document.getElementById("endTime");
			if (!valTest(startTime)){
				$("#draggableDialog").trigger("click");
				errorEl=startTime;
				return false;
			}
			if (!valTest(endTime)){
				$("#draggableDialog").trigger("click");
				errorEl=endTime;
				return false;
			}	
			
				doQuery(startTime.value,endTime.value);
		}
		function doQuery(start,end){
			$.ajax({
				    type: 'post',
				    url: 'dbStatusqueryStatusByAjax.html',
				    data: {startTime:start,endTime:end},
				    async: true,
				    complete: function(res) {
				        var sJson = eval("(" + res.responseText + ")");
				     var html="";
				     for(var i=0;i<sJson.length;i++){
					     html+="<tr>";
					     html+="<td class='right'>"+sJson[i].aliasName+"</td>";
					     html+="<td class='right'>"
					     html+="<div class='rating static-rating' data-role='rating' data-param-vote='off' data-param-rating='"+((sJson[i].sum-sJson[i].fail)/sJson[i].sum)*10+"' data-param-stars='10' style='width: 270px;'><div class='rating-value' style='width: "+((sJson[i].sum-sJson[i].fail)/sJson[i].sum)*100+"%;'></div></div>"
					     var precent=+((sJson[i].sum-sJson[i].fail)/sJson[i].sum)*100;
					     html+=precent.toFixed(2)+"%"+"</td>";
					     html+="<td class='right'>"+sJson[i].sum+"</td>";
					     html+="<td class='right'>"+sJson[i].fail+"</td>";
					     html+="</tr>";
				     }
				     $("tbody").html(html);
				    }
				});
		}
		var errorEl;
	</script>
</body>
</html>