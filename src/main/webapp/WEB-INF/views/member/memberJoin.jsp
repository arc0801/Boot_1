<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp" />
</head>
<body>
	<c:import url="../template/nav.jsp" />
	
	<div class="container">
	  <h2>Member Join</h2>
	  
	  <form:form action="memberJoin" modelAttribute="memberVO" method="post" enctype="multipart/form-data">
	  	<div class="form-group">
	      <label for="id">ID:</label>
	      <form:input path="id" placeholder="Enter ID" class="form-control" id="id" />
	      <form:errors path="id" />
	    </div>
	    
	    <div class="form-group">
	      <label for="pw">Password:</label>
	      <form:password path="pw" class="form-control" id="pw" placeholder="Enter password" />
	      <form:errors path="pw" cssStyle="color:red;" />
	    </div>
	    
	    <div class="form-group">
	      <label for="pw">Password:</label>
	      <form:password path="pw2" class="form-control" id="pw" placeholder="Enter password" />
	      <form:errors path="pw2" />
	    </div>
	    
	    <div class="form-group">
	      <label for="name">Name:</label>
	      <form:input path="name" class="form-control" id="name" placeholder="Enter Name" />
	    </div>
	    
	    <div class="form-group">
	      <label for="email">E-mail:</label>
	      <form:input path="email" class="form-control" id="email" placeholder="Enter E-mail" />
	    </div>
	    
	    <div class="form-group">
	      <label for="grade">Grade:</label>
	      <form:input path="grade" class="form-control" id="grade" placeholder="Enter Grade" />
	    </div>
	    
	    <div class="form-group">
	      <label for="files">File:</label>
	      <input type="file" class="form-control" id="files" name="files">
	    </div>
	    
	    <button type="submit" class="btn btn-default">Submit</button>
	  </form:form>
	  
	</div>
</body>
</html>