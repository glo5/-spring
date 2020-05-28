<%@page import="commons.DBUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp"/>

<section>
	<h2><%=DBUtils.getConn() %></h2>
	<div class="container">
		<p class="title">사원 관리 프로그램</p>
		<p>
		(주)Gondr 상사의 사원을 관리하는 페이지이다.<br><br>
		1. 사원정보 테이블을 생성한다.<br>
		2. 급여정보 테이블을 생성한다.<br>
		3. 사원정보 급여정보 테이블에서 제시된 문제지의 참조데이터를 추가 생성한다<br>
		4. 사원정보 조회 프로그램을 작성한다.<br>
		5. 사원급여정보 조회 프로그램을 작성한다.<br>
		</p>
	</div>
</section>

<jsp:include page="master/footer.jsp"/>