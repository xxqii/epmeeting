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
    <title>系统管理员【查找专家】</title>
</head>
<body>
<div id="admin">
    <jsp:include page="../common/menu.jsp"/>
    <div class="ad-comment-box" id="ad-comment">
        <jsp:include page="../common/header.jsp"/>
        <div class="ad-main-comment J_mainContent" id="ad-iframe" style=" min-height: 600px;">
            <div style="width:100%;text-align: center; padding-top: 15px">
                <form action="/expert/e_list.action" method="get" style="margin: 0;">
                    <input type="text" name="keyword" value="${keyword}" style="width:300px" placeholder="请输入关键字">
                    <input type="submit" value="查找" class="btn btn-info " style="width:80px;">
                </form>
            </div>
            <!--用户列表-->
            <div class="right_cont">
                <table class="table table-bordered table-striped table-hover">
                    <tbody>
                    <tr align="center">
                        <td nowrap="nowrap"><strong>姓名</strong></td>
                        <td nowrap="nowrap"><strong>邮箱</strong></td>
                        <td nowrap="nowrap"><strong>电话</strong></td>
                        <td nowrap="nowrap"><strong>QQ号码</strong></td>
                        <td nowrap="nowrap"><strong>生日</strong></td>
                        <td><strong>单位地址</strong></td>
                        <td><strong>创建时间</strong></td>
                        <td><strong>添加者</strong></td>
                        <td width="80" nowrap="nowrap"><strong> 操作 </strong></td>
                    </tr>
                    <c:forEach items="${experts}" var="item" varStatus="i">
                        <tr align="center">
                            <td nowrap="nowrap"><a href="/expert/e_editui.action?expert.id=${item.id}">${item.name}</a></td>
                            <td nowrap="nowrap">${item.email}</td>
                            <td nowrap="nowrap">${item.mobile}</td>
                            <td nowrap="nowrap">${item.qq}</td>
                            <td nowrap="nowrap">${item.birthday}</td>
                            <td nowrap="nowrap">${item.workunit}</td>
                            <td nowrap="nowrap">${item.createTime}</td>
                            <td nowrap="nowrap">${item.creator}</td>
                            <td nowrap="nowrap"><a href="/expert/e_delete.action?expert.id=${item.id}" onclick="javascript:return confirm('是否要删除该记录？')">删除</a> <a href="/expert/e_editui.action?expert.id=${item.id}">编辑</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <jsp:include page="/pages/common/page.jsp"/>
            </div>
            <!--用户列表-->
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