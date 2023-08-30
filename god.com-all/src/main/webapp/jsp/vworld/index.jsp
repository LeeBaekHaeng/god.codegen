<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <ul>
        <li>https://www.vworld.kr/dev/v4dv_geocoderguide2_s002.do</li>
        <li>Geocoder API 2.0 레퍼런스</li>
        <li><button onclick="fn_getAddress()">좌표를 주소로 변환</button></li>
        <li><input type="text" id="getAddress"></li>
    </ul>

    <script src="<c:url value="/js/egovframework/com/cmm/jquery-1.12.4.min.js" />"></script>

    <script type="text/javascript">
                    function fn_getAddress() {
                        $.getJSON("https://api.vworld.kr/req/address?service=address&request=getAddress&version=2.0&crs=epsg:4326&point=126.978275264,37.566642192&format=xml&type=both&zipcode=true&simple=false&key=B39D552C-5843-33E4-B394-906CC9F51C75&callback=fn_callback", function(data) {
                            $('#getAddress').val(data.result.item.text);
                        });
                    }

                    function fn_callback() {
                        alert(1);
                    }
                </script>

</body>
</html>