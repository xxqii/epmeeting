<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="/css/admin/public.css" type="text/css" rel="stylesheet">
    <link href="/css/admin/houtai.css" type="text/css" rel="stylesheet">
    <link href="/css/admin/smartMenu.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="/css/bootstrap/bootstrap.css" />
    <link rel="stylesheet" href="/css/user/add.css" />
    <title>系统管理员【查找资料】</title>
</head>
<body>
<div id="admin">
    <jsp:include page="../common/header.jsp"/>
    <div class="ad-comment-box" id="ad-comment">
        <div class="ad-main-comment J_mainContent" id="ad-iframe" style=" min-height: 600px;">
            <!--资料列表-->
            <div class="right_cont">
                <table class="table table-bordered table-striped table-hover">
                    <tbody>
                    <tr align="center">
                        <td nowrap="nowrap"><strong>文件名</strong></td>
                        <td nowrap="nowrap"><strong>类型</strong></td>
                        <td nowrap="nowrap"><strong>大小</strong></td>
                        <td><strong>创建时间</strong></td>
                        <td><strong>添加者</strong></td>
                        <td width="80" nowrap="nowrap"><strong> 操作 </strong></td>
                    </tr>
                    <c:forEach items="${materialList}" var="item" varStatus="i">
                        <tr align="center">
                            <td nowrap="nowrap"><a href="#" title="预览">${item.filename}</a></td>
                            <td nowrap="nowrap">
                                <c:choose>
                                    <c:when test="${item.type== 0}">其它类型</c:when>
                                    <c:when test="${item.type== 1}">word文档</c:when>
                                    <c:when test="${item.type== 2}">PPT</c:when>
                                    <c:when test="${item.type== 3}">视频</c:when>
                                    <c:when test="${item.type== 4}">音频</c:when>
                                    <c:when test="${item.type== 5}">图片</c:when>
                                </c:choose>
                            </td>
                            <td nowrap="nowrap">0</td>
                            <td nowrap="nowrap">${item.createTime}</td>
                            <td nowrap="nowrap">${item.creator}</td>
                            <td nowrap="nowrap"><a href="#">删除</a> <a href="#">预览</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <jsp:include page="/pages/common/page.jsp"/>
            </div>
            <!--资料列表-->
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