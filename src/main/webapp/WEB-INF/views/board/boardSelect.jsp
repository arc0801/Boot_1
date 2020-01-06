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
	  <h2>Board Select</h2>
	  
	  	<div class="form-group">
	      <label for="title">Title:</label>
	      <input value="${select.title}" class="form-control" id="title">
	    </div>
	    
	    <div class="form-group">
	      <label for="writer">Writer:</label>
	      <input value="${select.writer}" class="form-control" id="writer">
	    </div>
	    
	    <div class="form-group">
	      <label for="contents">Contents:</label>
	      <textarea class="form-control" id="contents">${select.contents}</textarea>
	    </div>
	    
	    <%-- <div>
	    	<c:forEach items="${select.files}" var="file">
	    		<a href="./fileDown?fnum=${file.fnum}">${file.oname}</a>
	    	</c:forEach>
	    </div> --%>
	</div>

</body>
</html>