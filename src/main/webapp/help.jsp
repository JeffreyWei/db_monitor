<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<title>简要介绍</title>
</head>
<body class="metrouicss">
	 <%@ include file="navbar.jsp" %>
	<div class="page" id="page-index" >
		<div class="page-region">
		<h2>简要介绍</h2>
			<div class="grid">
                    <div class="row">
                    <div class="span4">
                            <div class="notices">
                                <div class="bg-color-magenta">
                                    <div class="notice-image"><img src="images/reddit-48.png"></div>
                                    <div class="notice-header fg-color-yellow">多数据源连接</div>
                                    <div class="notice-text">支持<b>Oracle、Redis、Xmldb</b>等多种数据源。</div>
                                </div>
                            </div>
                        </div>
                        <div class="span4">
                            <div class="notices">
                                <div class="bg-color-purple">
                                    <div class="notice-image"><img src="images/aim-48.png"></div>
                                    <div class="notice-header fg-color-yellow">数据库连接查看</div>
                                    <div class="notice-text"><b>更方便、更快捷</b>的预览数据库连接历史日志。</div>
                                </div>
                            </div>
                        </div>
                        <div class="span4">
                            <div class="notices">
                                <div class="bg-color-pink">
                                    <div class="notice-image"><img src="images/angellist-48.png"></div>
                                    <div class="notice-header fg-color-yellow">使用方便快捷</div>
                                    <div class="notice-text"><b>简单配置</b>后即可开始监控。</div>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                     <div class="row">
                     <div class="span6">
                            <div class="notices">
                                <div class="bg-color-green">
                                    <div class="notice-image"><img src="images/github-48.png"></div>
                                    <div class="notice-header fg-color-yellow">开源绿色</div>
                                    <div class="notice-text">所有实现使用开源组件。</br><b>Sqlite、Fastjson、Bootstrap</b>等，部署简单。</div>
                                </div>
                            </div>
                        </div>
                        <div class="span6">
                            <div class="notices">
                                <div class="bg-color-teal">
                                    <div class="notice-image"><img src="images/html5-48.png"></div>
                                    <div class="notice-header fg-color-yellow">多浏览器支持</div>
                                    <div class="notice-text">支持主流浏览器。</br><b>Chrom、Firefox、Safari、IE</b>等。</div>
                                </div>
                            </div>
                        </div>
                     </div> 
                </div>
		</div>
	</div>
	 <%@ include file="foot.jsp" %>
</body>
</html>