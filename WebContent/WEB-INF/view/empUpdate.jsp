<%@page import="vo.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	EmpVO vo = (EmpVO) request.getAttribute("vo");
%>

<jsp:include page="master/header.jsp" />

<form action="/empUpdate" method="post">
	<input type="text" name="empno" value=" ${vo.empno }" readonly>
	<input type="text" name="empname" value="${vo.empname}" id="empname">
	<input type="date" name="joindate" value="${vo.joindate}" id="joindate">
	<select name="rank" id="rank">
		<option value="A" <%="A".equals(vo.getRank()) ? "selected" : ""%>>사원</option>

		<option value="B" <%="B".equals(vo.getRank()) ? "selected" : ""%>>대리</option>

		<option value="C" <%="C".equals(vo.getRank()) ? "selected" : ""%>>과장</option>
	</select> <select name="dept" id="dept">
		<option value="A" <%="A".equals(vo.getDept()) ? "selected" : ""%>>디자인</option>

		<option value="B" <%="B".equals(vo.getDept()) ? "selected" : ""%>>백엔드</option>

		<option value="C" <%="C".equals(vo.getDept()) ? "selected" : ""%>>프론트</option>
	</select> <input type="submit" value="등록">
</form>



<jsp:include page="master/footer.jsp" />