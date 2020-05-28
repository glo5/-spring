<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp" />

<form action="/empInsert" method="post">
	<input type="text" name="empno" value="${no}" readonly> <input
		type="text" name="empname" id="empname"> <input type="date"
		name="joindate" id="joindate"> <select name="rank" id="rank">
		<option value="A">사원</option>

		<option value="B">대리</option>

		<option value="C">과장</option>
	</select> <select name="dept" id="dept">
		<option value="A">디자인</option>

		<option value="B">백엔드</option>

		<option value="C">프론트</option>
	</select>
	<input type="submit" value="등록"> 
</form>



<jsp:include page="master/footer.jsp" />