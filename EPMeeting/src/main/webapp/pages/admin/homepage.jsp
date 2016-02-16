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
    <jsp:include page="../common/menu.jsp"/>

    <div class="ad-comment-box" id="ad-comment">
        <div class="ad-top-comment">
            <div class="ad-message">
                <div class="ad-top-right">
                    <div class="ad-welcom">
                        <div class="ad-wel-img"><img src="/images/admin/min_logo.png" height="36" width="36"></div>
                        <div class="ad-wel-text">
                            <div class="font-wel">欢迎您！<strong>${__current_username__}</strong>【${__date__}】<a href="javascript:;"><strong>【退出】</strong></a></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="ad-sub-nav-box content-tabs">
                <div class="ad-sub-wraper page-tabs J_menuTabs">
                    <ul class="ad-sub-list page-tabs-content">
                        <li class="active J_menuTab" data-id="/pages/admin/index.html">首页</li>
                    </ul>
                </div>
            </div>
        </div>
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