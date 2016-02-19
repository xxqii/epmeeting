<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link href="/css/admin/public.css" type="text/css" rel="stylesheet">
        <link href="/css/admin/houtai.css" type="text/css" rel="stylesheet">
        <link href="/css/admin/smartMenu.css" type="text/css" rel="stylesheet">
        <link rel="stylesheet" href="/css/bootstrap/bootstrap.css" />
        <link rel="stylesheet" href="/css/user/add.css" />
        <title>系统管理员【编辑专家】</title>
    </head>
    <body>
    	<div id="admin">
            <jsp:include page="../common/header.jsp"/>
    		<div class="ad-comment-box" id="ad-comment">
                <div class="ad-main-comment J_mainContent" id="ad-iframe" style=" min-height: 600px;">
                    <!--添加专家开始-->
                    <div style="width:900px; margin:auto;padding-top: 30px;">
                        <form action="/expert/e_edit.action" method="post">
                            <input type="hidden" name="expert.id" value="${expert.id}" />
                            <table class="table table-bordered" >
                                <tr>
                                    <td width="12%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">专家编号 ：</td>
                                    <td width="38%"><input type="text" name="expert.number" class="span1-1"  value="${expert.number}"/></td>
                                    <td width="12%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">姓名：</td>
                                    <td width="38%"><input type="text" name="expert.name" class="span1-1"  value="${expert.name}"/></td>
                                </tr>
                                <tr>
                                    <td width="12%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">性别：</td>
                                    <td width="38%">
                                        <input type="radio" name="expert.sex" value="0" <c:if test="${expert.sex == 0}">checked</c:if>/>男 &nbsp;&nbsp;
                                        <input type="radio" name="expert.sex" value="1" <c:if test="${expert.sex == 1}">checked</c:if>/>女 &nbsp;&nbsp;
                                    </td>
                                    <td width="12%" align="right" bgcolor="#f1f1f1">生日：</td>
                                    <td><input type="text"  class="laydate-icon span1-1" name="expert.birthday" id="Calendar" value="${expert.birthday}"  /></td>
                                </tr>
                                <tr>
                                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">职务：</td>
                                    <td><input type="text" name="expert.position" id="input3" class="span1-1"  value="${expert.position}"/></td>
                                    <td align="right" bgcolor="#f1f1f1">职称：</td>
                                    <td><input type="text" name="expert.title" id="input4" class="span1-1"  value="${expert.title}"/></td>
                                </tr>
                                <tr>
                                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">学历：</td>
                                    <td><input type="text" name="expert.education" id="input2" class="span1-1"  value="${expert.education}"/></td>
                                    <td align="right" bgcolor="#f1f1f1">学位：</td>
                                    <td><input type="text" name="expert.degree" id="input5" class="span1-1"  value="${expert.degree}"/></td>
                                </tr>
                                <tr>
                                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">单位地址：</td>
                                    <td colspan="3"><textarea name="expert.workunit" class="span10">${expert.workunit}</textarea></td>
                                </tr>
                                <tr>
                                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">个人成就：</td>
                                    <td colspan="3"><textarea name="expert.achievement" class="span10">${expert.achievement}</textarea></td>
                                </tr>
                                <tr>
                                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">个人简介：</td>
                                    <td colspan="3"><textarea name="expert.introduction" class="span10">${expert.introduction}</textarea></td>
                                </tr>
                                <tr>
                                    <td width="12%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">手机 ：</td>
                                    <td width="38%"><input type="text" name="expert.mobile" class="span1-1"  value="${expert.mobile}"/></td>
                                    <td width="12%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">电话：</td>
                                    <td width="38%"><input type="text" name="expert.telphone" class="span1-1"  value="${expert.telphone}"/></td>
                                </tr>
                                <tr>
                                    <td width="12%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">qq ：</td>
                                    <td width="38%"><input type="text" name="expert.qq" class="span1-1"  value="${expert.qq}"/></td>
                                    <td width="12%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">邮箱：</td>
                                    <td width="38%"><input type="text" name="expert.email" class="span1-1"  value="${expert.email}"/></td>
                                </tr>
                                <tr>
                                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">头像地址：</td>
                                    <td colspan="3"><textarea name="expert.avatar" id="input11" class="span10">${expert.avatar}</textarea></td>
                                </tr>
                            </table>
                            <table  class="margin-bottom-20 table  no-border" >
                                <tr>
                                    <td class="text-center"><input type="submit" value="确定" class="btn btn-info " style="width:80px;" /></td>
                                </tr>
                            </table>
                        </form>
                    </div>
                    <!--添加专家结束-->
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