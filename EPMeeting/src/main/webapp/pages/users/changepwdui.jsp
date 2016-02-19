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
        <title>系统管理员【修改密码】</title>
    </head>
    <body>
    	<div id="admin">
            <jsp:include page="../common/header.jsp"/>
    		<div class="ad-comment-box" id="ad-comment">
                <div class="ad-main-comment J_mainContent" id="ad-iframe" style=" min-height: 600px;">
                    <!--添加用户开始-->
                    <div style="width:900px; margin:auto;padding-top: 30px;">
                        <form action="/user/u_changepwd.action" method="post">
                            <input type="hidden" name="user.id" value="${user.id}"/>
                            <table class="table table-bordered" >
                                <tr>
                                    <td width="12%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">旧密码：</td>
                                    <td width="38%"><input type="password" name="user.passwdMd5" id="input" class="span1-1"  /></td>
                                </tr>
                                <tr>
                                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">新密码：</td>
                                    <td><input type="password" name="password" id="input3" class="span1-1"  /></td>
                                </tr>
                                <tr>
                                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">确认密码：</td>
                                    <td><input type="password" name="confirmPassword" id="input2" class="span1-1"  /></td>
                                </tr>
                            </table>
                            <table  class="margin-bottom-20 table  no-border" >
                                <tr>
                                    <td class="text-center"><input type="submit" value="修改密码" class="btn btn-info " style="width:80px;" /></td>
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