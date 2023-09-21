<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.ssafy.sample.dto.Member"%>
<%-- jstl 사용하기 위한 코드 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 프로젝트의 context 경로를 편하게 사용하기 위한 코드 --%>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<meta charset="UTF-8">
<title>상품 관리 사이트</title>
<%-- 부트스트랩 사용을 위한 코드 --%>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<%-- request 객체에 msg가 들어있을 때 해당 내용 알림창 띄우기 --%>

<body>
<h1 style = "text-align : center;"> 상품 관리 페이지
</h1>
<div>
	<%Member mem = (Member) session.getAttribute("loginUser"); 
	if(mem == null){
	%>
	<form method = "POST" action=" <c:out value="${root}" />/user" >
	<input type = "hidden" name = "action" value = "login">
	<input type = "text" name = "userid" >
	<input type = "password" name = "userpass" >
	
	<input type = "checkbox" name = "idsave" <%if(mem!= null){ %> checked <%}else{} %>>
	<label>아이디 저장</label>
	
	<input type = "submit" value = "로그인" >
	<input type = "submit" value = "회원가입" >
	</form>
	<%
	}else{
	%>
	<%= mem.getName()%>>님 안녕하세요!
	<%} %>
</div>

</body>
<script>
<!--	<c:if test="${!empty msg}">
	alert("${msg}");
	</c:if> -->
</script>