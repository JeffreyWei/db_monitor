<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="page">
		<div class="nav-bar">
			<div class="nav-bar-inner padding10">
				<span class="element"> 2013, Founder &copy;Design by <a
					class="fg-color-white" href="mailto:wei.jie@founder.com.cn">Jeffrey
						Wei</a> </span>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function (){
			resize();
	        window.onresize = resize;
		})
		function resize(){
			$("#page-index").css("height", window.screen.availHeight-162);  
		}
	</script>
</body>
</html>