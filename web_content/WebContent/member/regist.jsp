<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>

</head>
<body>


	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	
	  <h2>사용자 정보 등록</h2>
	  <form id="registForm" method = "POST" action = " <c:out value="${root}" />/user">
	  	<input type="hidden" name="action" value="regist">
	  	<div class="form-group">
	      <label for="name">이름</label>
	      <input type="text" class="form-control" id="username" placeholder="이름 입력" name = "username">
	    </div>
	    <div class="form-group">
	      <label for="ID">ID</label>
	      <input type="text" class="form-control" id="userid" placeholder="아이디 입력" name = "userid">
	    </div>
	    <div class="form-group">
	      <label for="password">비밀번호 입력</label>
	      <input type="password" class="form-control" id="userpass" placeholder="비밀번호 입력" name = "userpass">
	    </div>
	    <div class="form-group">
	      <label for="age">나이</label>
	      <input type="number" class="form-control" id="userage" placeholder="나이 입력" name = "userage">
	    </div>

	    <button type="submit" class="btn btn-primary" id="regist">등록</button>
	    <a class="btn btn-secondary" href="#" >취소</a>
	  </form>
	
	
	</div>
	<%-- --%>
<%@ include file="/include/footer.jsp" %>