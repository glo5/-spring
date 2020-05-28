<%@page import="vo.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp" />

<section>
	<div class="container">
		<p class="title">회원목록 수정</p>
		<%
			List<EmpVO> list = (List<EmpVO>)request.getAttribute("list");
		%>
		<table>
			<tr>
				<td>사원번호</td>
				<td>사원이름</td>
				<td>입사일자</td>
				<td>직급</td>
				<td>부서</td>
				<td>기능</td>
			</tr>
			<%
				for(EmpVO emp : list){
					request.setAttribute("emp", emp);
			%>
			
			<tr>
				<td>${emp.empno }</td>
				<td>${emp.empname }</td>
				<td>${emp.joindate }</td>
				<td>${emp.rank }</td>
				<td>${emp.dept }</td>
				<td><a href="/empUpdate?empno=${emp.empno}">수정</a></td>
			</tr>
			<% 
			}
			%>
		</table>

	</div>
</section>

<jsp:include page="master/footer.jsp" />