<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
관리자 메인

<br>${Globals.OS_TYPE}
<c:out value="${Globals.OS_TYPE}" />

<br>${Globals.DB_TYPE}
<c:out value="${Globals.DB_TYPE}" />

<br>${Globals.MAIN_PAGE}
<c:out value="${Globals.MAIN_PAGE}" />

<br>${loginVO.uniqId}
<c:out value="${loginVO.uniqId}" />

<div id="test"></div>

<script type="text/javascript">
    $(function() {
        var data = {
            codeId : 'COM001',
        };
        var settings = {};
        settings.data = data;
        settings.success = fn_success;
        settings.error = fn_error;
        fn_comCmm_ajaxGet('/rest/com/cmm/v1/cmmcodedetail', settings);
        function fn_success(data, textStatus, jqXHR) {
            $('#test').html(JSON.stringify(data));
        }
        function fn_error(jqXHR, textStatus, errorThrown) {
            $('#test').html(textStatus);
        }
    });
</script>
