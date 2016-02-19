<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
            <jsp:include page="../common/header.jsp"/>
    		<div class="ad-comment-box" id="ad-comment">
                <div class="ad-main-comment J_mainContent" id="ad-iframe" style=" min-height: 600px;">
                    <!--添加用户开始-->
                    <div style="width:900px; margin:auto;padding-top: 30px;">
                        <form action="/user/u_add.action" method="post">
                            <table class="table table-bordered" >
                                <tr>
                                    <td width="12%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">姓名：</td>
                                    <td width="38%"><input type="text" name="user.realName" id="input" class="span1-1"  /></td>
                                    <td width="12%" align="right" bgcolor="#f1f1f1">生日：</td>
                                    <td><input type="text"  class="laydate-icon span1-1" name="user.birthday" id="Calendar" value=""  /></td>
                                </tr>
                                <tr>
                                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">邮箱：</td>
                                    <td><input type="text" name="user.email" id="input3" class="span1-1"  /></td>
                                    <td align="right" bgcolor="#f1f1f1">手机号码：</td>
                                    <td><input type="text" name="user.mobile" id="input4" class="span1-1"  /></td>
                                </tr>
                                <tr>
                                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">固定电话号码：</td>
                                    <td><input type="text" name="user.telphone" id="input2" class="span1-1"  /></td>
                                    <td align="right" bgcolor="#f1f1f1">QQ号码：</td>
                                    <td><input type="text" name="user.qq" id="input5" class="span1-1"  /></td>
                                </tr>
                                <tr>
                                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">用户类型：</td>
                                    <td colspan="3">
                                        <input type="radio" name="user.userType" value="0">系统管理员&nbsp;&nbsp;
                                        <input type="radio" name="user.userType" value="1">会议控制员&nbsp;&nbsp;
                                        <input type="radio" name="user.userType" value="2">会议记录员&nbsp;&nbsp;
                                        <input type="radio" name="user.userType" value="3">高级用户&nbsp;&nbsp;
                                        <input type="radio" name="user.userType" value="4">音视频记录人员&nbsp;&nbsp;
                                        <input type="radio" name="user.userType" value="5">会议管理员&nbsp;&nbsp;
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">单位地址：</td>
                                    <td colspan="3"><textarea name="user.workunit" id="input9" class="span10"></textarea></td>
                                </tr>
                                <tr>
                                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">头像地址：</td>
                                    <td colspan="3"><textarea name="user.avatar" id="input11" class="span10"></textarea></td>
                                </tr>
                            </table>
                            <table  class="margin-bottom-20 table  no-border" >
                                <tr>
                                    <td class="text-center"><input type="submit" value="确定" class="btn btn-info " style="width:80px;" /></td>
                                </tr>
                            </table>
                        </form>
                    </div>
                    <!--添加用户结束-->
                </div>
    		</div>
    	</div>
        <script type="text/javascript" src="/js/jquery/jquery.min.js"></script>
        <script type="text/javascript" src="/js/admin/contabs.js"></script>
        <script type="text/javascript" src="/js/admin/maintabs.js"></script>
        <script type="text/javascript" src="/js/jquery/jquery-smartMenu-min.js"></script>
        <script type="text/javascript" src="/js/jquery/jquery.nicescroll.min.js"></script>
        <script type="text/javascript" src="/js/laydate/laydate.js"></script>
        <script type="text/javascript">
            $(function(){
                $(".ad-menu").niceScroll({cursorborder:"0 none",cursorcolor:"#1a1a19",cursoropacitymin:"0",boxzoom:false});
            })

            !function(){
                laydate.skin('molv');
                laydate({elem: '#Calendar'});
                laydate.skin('molv');
                laydate({elem: '#Calendar2'});
            }();
        </script>
    </body>
</html>