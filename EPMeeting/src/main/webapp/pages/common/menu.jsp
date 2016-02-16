<%@ page language="java" pageEncoding="UTF-8"%>
<div class="ad-menu" id="ad-menu">
    <div class="ad-logo"><img src="/images/admin/m-logo.png" height="103" width="130"></div>
    <div class="ad-list">
        <ul>
            <li id="_li_user">
                <div class="li-item"><em class="scm li-ico ic1"></em>用户管理<span class="scm arrow"></span></div>
                <dl>
                    <dd id="_user_list">
                        <a href="/user/u_list.action" class="dd-item">查找用户<span class="scm dd-ar"></span></a>
                    </dd>
                    <dd id="_user_addui">
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
            <li id="_li_material">
                <div class="li-item"><em class="scm li-ico ic4"></em>资料管理<span class="scm arrow"></span></div>
                <dl>
                    <dd id="_material_list">
                        <a href="/material/m_list.action" class="dd-item">查找资料<span class="scm dd-ar"></span></a>
                    </dd>
                    <dd id="_material_uploadui">
                        <a href="/material/m_uploadui.action" class="dd-item">上传资料<span class="scm dd-ar"></span></a>
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
<script type="text/javascript" src="/js/jquery/jquery.min.js"></script>
<script>
    var pathname = window.location.pathname;
    if(pathname == '/user/u_addui.action') {    //新增用户
        $("#_li_user").addClass("over");
        $("#_user_addui").addClass("on");
    } else if(pathname == '/user/u_list.action') {
        $("#_li_user").addClass("over");
        $("#_user_list").addClass("on");
    } else if(pathname == '/material/m_uploadui.action') {
        $("#_li_material").addClass("over");
        $("#_material_uploadui").addClass("on");
    } else if(pathname == '/material/m_list.action') {
        $("#_li_material").addClass("over");
        $("#_material_list").addClass("on");
    }
</script>