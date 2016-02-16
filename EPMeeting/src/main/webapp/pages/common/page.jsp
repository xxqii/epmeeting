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