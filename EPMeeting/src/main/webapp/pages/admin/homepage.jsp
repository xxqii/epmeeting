<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="/css/admin/public.css" type="text/css" rel="stylesheet">
    <link href="/css/admin/houtai.css" type="text/css" rel="stylesheet">
    <link href="/css/admin/smartMenu.css" type="text/css" rel="stylesheet">
    <title>EPMeeting-administator</title>
</head>
<body>
<div id="admin">
    <jsp:include page="../common/header.jsp"/>
    <div class="ad-comment-box" id="ad-comment">
        <div class="ad-main-comment J_mainContent" id="ad-iframe">
            首页
            <!--
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="/pages/admin/index.html" frameborder="0" data-id="/pages/admin/index.html" seamless></iframe>
            -->
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/js/admin/contabs.js"></script>
<script type="text/javascript" src="/js/admin/maintabs.js"></script>
<script type="text/javascript" src="/js/jquery/jquery-smartMenu-min.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.nicescroll.min.js"></script>
<script type="text/javascript">
    $(function(){
        $(".ad-menu").niceScroll({cursorborder:"0 none",cursorcolor:"#1a1a19",cursoropacitymin:"0",boxzoom:false});
    })
</script>
</body>
</html>