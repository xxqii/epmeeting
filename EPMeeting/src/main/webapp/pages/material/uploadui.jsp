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
        <link rel="stylesheet" href="/css/upload/uploadify.css" />
        <title>系统管理员【添加资料】</title>
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
                                <li class="active J_menuTab">上传资料</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="ad-main-comment J_mainContent" id="ad-iframe" style=" min-height: 600px;">
                    <!--添加用户开始-->
                    <div style="width:900px; margin:auto;padding-top: 30px;">
                        <form action="/material/m_add.action" method="post">
                            <input type="hidden" name="material.filename" value="" id="uploaded_file_names"/>
                            <table class="table table-bordered" >
                                <tr>
                                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">资料类型：</td>
                                    <td colspan="3">
                                        <input type="radio" name="material.type" value="1">word文档&nbsp;&nbsp;
                                        <input type="radio" name="material.type" value="2">PPT&nbsp;&nbsp;
                                        <input type="radio" name="material.type" value="3">视频&nbsp;&nbsp;
                                        <input type="radio" name="material.type" value="4">音频&nbsp;&nbsp;
                                        <input type="radio" name="material.type" value="5">图片&nbsp;&nbsp;
                                        <input type="radio" name="material.type" value="0">其它类型&nbsp;&nbsp;
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">关键字：</td>
                                    <td colspan="3"><input type="text" name="material.keyword" style="width: 80%;"  placeholder="多个关键字之间用','分隔" required/></td>
                                </tr>
                                <tr>
                                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">备注：</td>
                                    <td colspan="3"><textarea name="material.note" id="input11" class="span10" placeholder="文档的简单说明，可为空"></textarea></td>
                                </tr>
                                <tr>
                                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">文件列表：</td>
                                    <td colspan="3">
                                        <div>
                                            <input type="file" name="uploadFile" id="uploadify" />
                                            <div id="fileQueue">
                                            </div>
                                            <p>
                                                <a href="javascript:$('#uploadify').uploadify('upload')">上传</a>
                                                <!--<a href="javascript:$('#uploadify').uploadify('cancel')">取消上传</a>-->
                                            </p>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                            <table  class="margin-bottom-20 table  no-border" >
                                <tr>
                                    <td class="text-center"><input type="submit" value="提交" class="btn btn-info " style="width:80px;" /></td>
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
        <script type="text/javascript" src="/js/jquery/jquery.uploadify.js"></script>
        <script type="text/javascript">
            $(function () {
                $("#uploadify").uploadify({
                    //指定swf文件
                    'swf': '/js/jquery/uploadify.swf',
                    //后台处理的页面
                    'uploader': '/material/m_upload.action',
                    //按钮显示的文字
                    'buttonText': '选择文件',
                    //显示的高度和宽度，默认 height 30；width 120
                    //'height': 15,
                    //'width': 80,
                    //上传文件的类型  默认为所有文件    'All Files'  ;  '*.*'
                    //在浏览窗口底部的文件类型下拉菜单中显示的文本
                    'fileTypeDesc': 'All Files',
                    //允许上传的文件后缀
                    'fileTypeExts': '*.*',
                    //发送给后台的其他参数通过formData指定
                    //'formData': { 'someKey': 'someValue', 'someOtherKey': 1 },
                    //上传文件页面中，你想要用来作为文件队列的元素的id, 默认为false  自动生成,  不带#
                    'queueID': 'fileQueue',
                    //选择文件后自动上传
                    'auto': false,
                    //设置为true将允许多文件上传
                    'multi': true,
                    'removeCompleted' : false,
                    'fileObjName': 'uploadFile',
                    'onUploadComplete': function(file){
                        var fileName = $("#uploaded_file_names").val();
                        if(fileName == "") {
                            fileName = file.name;
                        } else {
                            fileName = fileName + "," + file.name;
                        }
                        $("#uploaded_file_names").val(fileName)
                    }
                });
            });
        </script>
    </body>
</html>