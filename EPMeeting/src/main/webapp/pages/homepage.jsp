<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>主页</title>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <link href="css/homePage.css"  rel="stylesheet">
    </head>
    <body>
        <div id="page">
            <div id="tophead ">
                <div id="topleft"><img src="images/headTitle.png" style="z-index:999;"></div>
                <div id="topright">
                    <div class="topright_r">
                        <strong>欢迎您，系统管理员</strong>&nbsp;&nbsp; <strong>
                        日期：2016-01-28&nbsp;&nbsp;</strong>&nbsp;&nbsp;
                        <a href="#" onclick="LogOff()" class="logOut">退出</a>
                    </div>
                </div>
            </div>

            <!-- 中部 -->
            <div id="center">
                <!-- 左边菜单 -->
                <div id="menu">
                    <table  onclick="change(t1,ts1)" id="ts1">
                        <tr>
                            <td><ul ><li> <a  href="#" onclick="Show('window')" onFocus="this.blur()"><img src="../images/m_users.png">用户管理</a> </li></ul></td>
                        </tr>
                    </table>
                    <table id="t1" style="display:none">
                        <tr>
                            <td><ul id="window"><li><a href="searchUsers.jsp" target="_mainFrame" onFocus="this.blur()"><img src="../images/s_users.png">查找用户</a></li></ul></td>
                        </tr>
                        <tr>
                            <td><ul id="window"><li><a href="newUsers.jsp" target="_mainFrame" onFocus="this.blur()"><img src="../images/n_users.png">新增用户</a></li></ul></td>
                        </tr>
                    </table>


                    <table  onclick="change(t2,ts2)" id="ts2">
                        <tr>
                            <td> <ul ><li><a  href="#" onclick="Show('phone')" onFocus="this.blur()"><img src="../images/m_expert.png">专家管理</a> </li></ul></td>
                        </tr>
                    </table>
                    <table id="t2" style="display:none">
                        <tr>
                            <td><ul id="phone"><li><a href="findExpert.jsp" target="_mainFrame" onFocus="this.blur()"><img src="../images/s_expert.png">查找专家</a></li></ul></td>
                        </tr>
                        <tr>
                            <td><ul id="phone"><li><a href="newExpert.jsp" target="_mainFrame" onFocus="this.blur()"><img src="../images/n_expert.png">新增专家</a></li></ul></td>
                        </tr>
                    </table>

                    <table  onclick="change(t3,ts3)" id="ts3">
                        <tr>
                            <td> <ul><li><a  href="#" onclick="Show('rule')" onFocus="this.blur()"><img src="../images/m_meeting.png">会议管理</a> </li></ul></td>
                        </tr>
                    </table>
                    <table id="t3" style="display:none">
                        <tr>
                            <td><ul id="rule"><li><a  href="viewMeeting.jsp" target="_mainFrame" onFocus="this.blur()"><img src="../images/v_meeting.png">查看会议</a></li></ul></td>
                        </tr>
                    </table>

                    <table  onclick="change(t4,ts4)" id="ts4" >
                        <tr>
                            <td> <ul ><li><a  href="#" onclick="Show('info')" onFocus="this.blur()"><img src="../images/m_data.png">资料管理</a> </li></ul></td>
                        </tr>
                    </table>
                    <table id="t4" style="display:none">
                        <tr>
                            <td><ul id="info"><li><a href="searchData.jsp" target="_mainFrame" onFocus="this.blur()"><img src="..	/images/s_data.png">查找资料</a></li></ul></td>
                        </tr>
                        <tr>
                            <td><ul id="info"><li><a href="uploadData.jsp" target="_mainFrame" onFocus="this.blur()"><img src="../images/u_load.png">上传资料</a></li></ul></td>
                        </tr>
                    </table>

                    <table  onclick="change(t5,ts5)" id="ts5">
                        <tr>
                            <td> <ul ><li><a  href="#" onclick="Show('user')" onFocus="this.blur()"><img src="../images/p_setting.png">个人设置</a> </li></ul></td>
                        </tr>
                    </table>
                    <table id="t5" style="display:none">
                        <tr>
                            <td><ul id="user"><li><a href="changePassword.jsp" target="_mainFrame" onFocus="this.blur()"><img src="../images/c_password.png">修改密码</a></li></ul></td>
                        </tr>
                        <tr>
                            <td><ul id="user"><li><a href="modifyInformation.jsp" target="_mainFrame" onFocus="this.blur()"><img src="../images/c_information.png">修改信息</a></li></ul></td>
                        </tr>
                    </table>
                </div>


                <script language="javascript">
                    function change(x,y)
                    {
                        if(x.style.display=="none")  //展开树形的子节点
                        {
                            x.style.display="";
                            y.style.diaplay="block";

                        }
                        else if(x.style.display=="") //收缩树形的子节点
                        {
                            x.style.display="none";
                            y.style.diaplay="none";
                        }

                    }
                </script>

                <script type="text/javascript">
                    /*点击按钮是触发的事件*/
                    var arrays = new Array("rule", "info", "window",
                            "phone", "user");
                    function Show(tagId) {
                        for (var i = 0; i < arrays.length; i++) {
                            if (arrays[i] == tagId) {
                                //设置全新的背景颜色
                                document.getElementById(arrays[i]).parentNode.style.backgroundColor = "RGB(237,237,237)";
                                //document.getElementById(arrays[i]).style.display = "block";
                            } else {
                                //将背景颜色还原
                                document.getElementById(arrays[i]).parentNode.style.backgroundColor = "RGB(216,216,216)";
                                //document.getElementById(arrays[i]).style.display = "none";
                            }
                        }
                    }
                </script>
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
    </body>
</html>
