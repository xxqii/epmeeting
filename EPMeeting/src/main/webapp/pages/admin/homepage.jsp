<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>系统管理员</title>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" /><!-- added by CSB 20151206-02 -->
        <link href="/css/admin/homePage.css"  rel="stylesheet"  id="page">
        <script type="text/javascript" src="/js/admin/allhomepage.js"></script>
    </head>

<body onload="loadFun()">
<s:form id="" action="//a.action">
    <!-- 主页-->
    <div id="page">
        <!-- 上部 -->
        <div id="tophead ">
            <div id="topleft">
                <img src="/images/admin/headTitle.png"
                     style="z-index:999;">
            </div>
            <div id="topright">
                <div class="topright_r">
                    <strong>欢迎您，系统管理员</strong>&nbsp;&nbsp; <strong>
                    日期：<span id="time">2016-01-30</span>
						<span id="week">
                    &nbsp;&nbsp;</strong>&nbsp;&nbsp;
                    <a href="#"onclick="LogOff()" class="logOut">退出</a>
                    <script type="text/javascript" language="javascript">
                        function LogOff() {
                            window.location.replace("/Account/LogOff");
                            return false;
                        }
                    </script>
                </div>
            </div>
        </div>
        <!-- 中部 -->
        <div id="center">
            <!-- 左边菜单 -->
            <div id="menu">
                <table  onclick="change(t1,ts1)" id="ts1">
                    <tr><td><ul ><li> <a  href="#" onclick="Show('window')" onFocus="this.blur()"><img src="/images/admin/m_users.png">用户管理</a> </li></ul></td>
                    </tr>
                </table>
                <table id="t1" style="display:none">
                    <tr>
                        <td><ul id="window"><li ><a class="asideInputNone" onclick="changcss(this)" href="searchUsers.jsp" target="_mainFrame" onFocus="this.blur()"><img src="/images/admin/s_users.png">查找用户</a></li></ul></td>
                    </tr>
                    <tr>
                        <td><ul id="window"><li ><a class="asideInputNone" onclick="changcss(this)" href="newUsers.jsp" target="_mainFrame" onFocus="this.blur()"><img src="/images/admin/n_users.png">新增用户</a></li></ul></td>
                    </tr>
                </table>
            </div>
            <!-- 右边 -->
            <div>
                <iframe id="_mainFrame" name="_mainFrame" frameborder="0"
                        src="welcome.jsp" scrolling="no"> </iframe>
            </div>
        </div>
        <!-- 下部 -->
        <div id="bottom">
        </div>
    </div>
</s:form>
</body>
</html>
