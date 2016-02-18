<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<script type="text/javascript">
    //下一页
    function next() {
        var curPage = parseInt(document.getElementById("spanPageNum").textContent)
        curPage++;
        var search = window.location.search;
        if(search == "") {
            search = "?page.page=" + curPage;
        } else {
            if(search.indexOf("page.page=") > -1) { //包含了page
                search = search.replace(/page.page=\d+/g, "page.page=" + curPage);
            } else {
                search += "&page.page=" + curPage;
            }
        }
        window.location.href = window.location.pathname + search
    }

    //上一页
    function pre() {
        var curPage = parseInt(document.getElementById("spanPageNum").textContent)
        curPage--;
        var search = window.location.search;
        if(curPage == 1) {
            search = search.replace(/[&]page.page=\d+/g, "");
        } else {
            if(search == "") {
                search = "?page.page=" + curPage;
            } else {
                if(search.indexOf("page.page=") > -1) { //包含了page
                    search = search.replace(/page.page=\d+/g, "page.page=" + curPage);
                } else {
                    search += "&page.page=" + curPage;
                }
            }
        }
        window.location.href = window.location.pathname + search
    }

    //第一页
    function first() {
        var search = window.location.search;
        if(search != ""){
            if(search.indexOf("page.page=") > -1) { //包含了page
                search = search.replace(/[&]page.page=\d+/g, "");
            }
        }
        window.location.href = window.location.pathname + search
    }

    //最后一页
    function last() {
        var search = window.location.search;
        if(search == "") {
            search = "?page.page=" + document.getElementById("spanTotalPage").textContent;
        } else {
            if(search.indexOf("page.page=") > -1) { //包含了page
                search = search.replace(/page.page=\d+/g, "page.page=" + document.getElementById("spanTotalPage").textContent);
            } else {
                search += "&page.page=" + document.getElementById("spanTotalPage").textContent;
            }
        }
        window.location.href = window.location.pathname + search
    }
</script>