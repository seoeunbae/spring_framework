<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="root" value="${ pageContext.request.contextPath }/servlet"/>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	
	  <h2>글 등록</h2>
	  <form id="registForm" method="post" action="${ root }/board/regist">
	    <div class="form-group">
	      <label for="title">제목</label>
	      <input type="text" class="form-control" id="title" name="title" placeholder="제목 입력">
	    </div>
	    <div class="form-group">
	      <label for="content">내용</label>
	      <input type="text" class="form-control" id="content" name="content" placeholder="내용 입력">
	    </div> 
	    <div class="form-group">
	      <label for="price">가격</label>
	      <input type="number" class="form-control" id="price" name="price" placeholder="내용 입력">
	    </div>
	    
	    <button type="submit" class="btn btn-primary">등록</button>
	    <a class="btn btn-secondary" href="#" >취소</a>
	  </form>
	
	
	</div>
	<%-- --%>