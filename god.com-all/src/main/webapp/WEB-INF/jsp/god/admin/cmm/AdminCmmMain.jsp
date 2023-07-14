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

<h1>test $.ajax</h1>
<div id="test"></div>

<h1>test axios</h1>
<div id="test2"></div>

<div id="app">
    <h1>{{ message }}</h1>

    <h1>COM001</h1>
    <ul>
        <li v-for="item in items">{{ item }}, {{ item.code }}, {{ item.codeNm }}</li>
    </ul>
    <select>
        <option v-for="item in items" :value="item.code">{{ item.codeNm }}</option>
    </select>

    <h1>COM002</h1>
    <ul>
        <li v-for="item in COM002">{{ item }}, {{ item.code }}, {{ item.codeNm }}</li>
    </ul>
    <select>
        <option v-for="item in COM002" :value="item.code">{{ item.codeNm }}</option>
    </select>

    <h1>COM003</h1>
    <ul>
        <li v-for="item in COM003">{{ item }}, {{ item.code }}, {{ item.codeNm }}</li>
    </ul>
    <select>
        <option v-for="item in COM003" :value="item.code">{{ item.codeNm }}</option>
    </select>

    <h1>COM005</h1>
    <ul>
        <li v-for="item in COM005">{{ item }}, {{ item.code }}, {{ item.codeNm }}</li>
    </ul>
    <select>
        <option v-for="item in COM005" :value="item.code">{{ item.codeNm }}</option>
    </select>

    <h1>COM005</h1>
    <table border="1">
        <tr>
            <td>codeId</td>
            <td>code</td>
            <td>codeNm</td>
            <td>codeDc</td>
        </tr>
        <tr v-for="item in COM005">
            <td>{{ item.codeId }}</td>
            <td>{{ item.code }}</td>
            <td>{{ item.codeNm }}</td>
            <td>{{ item.codeDc }}</td>
        </tr>
    </table>

</div>

<script src="${pageContext.request.contextPath}/resources/admin/cmm/AdminCmmMain.js"></script>
