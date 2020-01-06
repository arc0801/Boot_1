<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/nav.jsp"></c:import>
	<div class="container">
		<table class="table table-hover">
			<tr>
				<td>NUM</td>
				<td>TITLE</td>
				<td>WRITER</td>
				<td>DATE</td>
				<td>HIT</td>			
			</tr>
			
			<c:forEach items="${list}" var="vo">
				<tr>
					<td>${vo.num}</td>
					<td><a href="./noticeSelect?num=${vo.num}">${vo.title}</a></td>
					<td>${vo.writer}</td>
					<td>${vo.regDate}</td>
					<td>${vo.hit}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="container">
		<ul class="pagination">
			<c:if test="${pager.curBlock gt 1}">
				<li class="previous"><a href="./noticeList?curPage=${pager.startNum-1}">Previous</a></li>
			</c:if>
			
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li><a href="./noticeList?curPage=${i}">${i}</a></li>
			</c:forEach>
			
			<c:if test="${pager.curBlock lt pager.totalBlock}">
				<li class="next"><a href="./noticeList?curPage=${pager.lastNum+1}">Next</a></li>
			</c:if>
		</ul>
	</div>

</body>
</html>