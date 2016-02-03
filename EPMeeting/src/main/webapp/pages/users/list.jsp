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
    <title>系统管理员【添加用户】</title>
</head>
<body>
<div id="admin">
    <div class="ad-menu" id="ad-menu">
        <div class="ad-logo"><img src="/images/admin/m-logo.png" height="103" width="130"></div>
        <div class="ad-list">
            <ul>
                <li class="over">
                    <div class="li-item"><em class="scm li-ico ic1"></em>用户管理<span class="scm arrow"></span></div>
                    <dl>
                        <dd class="on">
                            <a href="/user/u_list.action" class="dd-item">查找用户<span class="scm dd-ar"></span></a>
                        </dd>
                        <dd>
                            <a href="/user/u_addui.action" class="dd-item">新增用户<span class="scm dd-ar"></span></a>
                        </dd>
                    </dl>
                </li>
                <li>
                    <div class="li-item"><em class="scm li-ico ic2"></em>专家管理<span class="scm arrow"></span></div>
                    <dl>
                        <dd>
                            <a href="#" class="dd-item">查找专家<span class="scm dd-ar"></span></a>
                        </dd>
                        <dd>
                            <a href="#" class="dd-item">新增专家<span class="scm dd-ar"></span></a>
                        </dd>
                    </dl>
                </li>
                <li>
                    <div class="li-item"><em class="scm li-ico ic3"></em>会议管理<span class="scm arrow"></span></div>
                    <dl>
                        <dd>
                            <a href="#" class="dd-item">查看会议<span class="scm dd-ar"></span></a>
                        </dd>
                    </dl>
                </li>
                <li>
                    <div class="li-item"><em class="scm li-ico ic4"></em>资料管理<span class="scm arrow"></span></div>
                    <dl>
                        <dd>
                            <a href="#" class="dd-item">查找资料<span class="scm dd-ar"></span></a>
                        </dd>
                        <dd>
                            <a href="#" class="dd-item">上传资料<span class="scm dd-ar"></span></a>
                        </dd>
                    </dl>
                </li>
                <li>
                    <div class="li-item"><em class="scm li-ico ic5"></em>个人设置<span class="scm arrow"></span></div>
                    <dl>
                        <dd>
                            <a href="#" class="dd-item">修改密码<span class="scm dd-ar"></span></a>
                        </dd>
                        <dd>
                            <a href="#" class="dd-item">个人信息<span class="scm dd-ar"></span></a>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
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
                        <li class="active J_menuTab">查找用户</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="ad-main-comment J_mainContent" id="ad-iframe" style=" min-height: 600px;">
            <!--用户列表-->
            <div class="right_cont">
                <table class="table table-bordered table-striped table-hover">
                    <tbody>
                    <tr align="center">
                        <td nowrap="nowrap"><strong>姓名</strong></td>
                        <td nowrap="nowrap"><strong>邮箱</strong></td>
                        <td nowrap="nowrap"><strong>电话</strong></td>
                        <td nowrap="nowrap"><strong>QQ号码</strong></td>
                        <td><strong>用户类型</strong></td>
                        <td><strong>单位地址</strong></td>
                        <td><strong>创建时间</strong></td>
                        <td><strong>添加者</strong></td>
                        <td width="80" nowrap="nowrap"><strong> 操作 </strong></td>
                    </tr>
                    <c:forEach items="${users}" var="item" varStatus="i">
                        <tr align="center">
                            <td nowrap="nowrap">${item.realName}</td>
                            <td nowrap="nowrap">${item.email}</td>
                            <td nowrap="nowrap">${item.mobile}</td>
                            <td nowrap="nowrap">${item.qq}</td>
                            <td nowrap="nowrap">
                                <c:choose>
                                    <c:when test="${item.userType == 0}">系统管理员</c:when>
                                    <c:when test="${item.userType == 1}">会议控制员</c:when>
                                    <c:when test="${item.userType == 2}">会议记录员</c:when>
                                    <c:when test="${item.userType == 3}">高级用户</c:when>
                                    <c:when test="${item.userType == 4}">音视频记录人员</c:when>
                                    <c:when test="${item.userType == 5}">会议管理员</c:when>
                                </c:choose>
                            </td>
                            <td nowrap="nowrap">${item.workunit}</td>
                            <td nowrap="nowrap">${item.createTime}</td>
                            <td nowrap="nowrap">${item.creator}</td>
                            <td nowrap="nowrap"><a href="#">删除</a> <a href="#">编辑</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <table  class="margin-bottom-20 table  no-border" >
                    <tr>
                        <td class="text-right">
                            <div style="height:30px;margin:5px 0 0 0;">
                                第<strong><span id="spanPageNum">${page.page}</span></strong>页/共<span id="spanTotalPage">${page.totalPageCount}</span>页;&nbsp;&nbsp;
                                <c:if test="${page.page > 1}">
                                    <span id="spanFirst"><a href='javascript:first();' onclick="first()">第一页</a></span>&nbsp;
                                    <span id="spanPre"><a href='javascript:pre();' onclick="pre()">上一页</a></span>&nbsp;
                                </c:if>
                                <c:if test="${page.page < page.totalPageCount}">
                                    <span id="spanNext"><a href='javascript:next();' onclick="next()">下一页</a></span>&nbsp;
                                    <span id="spanLast"><a href='javascript:last();' onclick="last()">最后一页</a></span>&nbsp;
                                </c:if>
                            </div>
                        </td>
                    </tr>
                </table>
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

    //下一页
    function next() {
        var curPage = parseInt(document.getElementById("spanPageNum").textContent)
        curPage++;
        window.location.href = window.location.pathname + "?page.page=" + curPage;
    }

    //上一页
    function pre() {
        var curPage = parseInt(document.getElementById("spanPageNum").textContent)
        curPage--;
        window.location.href = window.location.pathname + "?page.page=" + curPage;
    }

    //第一页
    function first() {
        window.location.href = window.location.pathname + "?page.page=1";
    }

    //最后一页
    function last() {
        window.location.href = window.location.pathname + "?page.page=" + document.getElementById("spanTotalPage").textContent;
    }
</script>
</body>
</html>