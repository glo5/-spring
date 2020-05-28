package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.sql.DATE;
import service.EmpService;
import vo.EmpVO;

public class EmpInsertController implements Controller {
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			return postProcess(req, res);
		} else if (req.getMethod().equalsIgnoreCase("get")) {
			return getProcess(req, res);
		}
		return "notfound";
	}

	public String postProcess(HttpServletRequest req, HttpServletResponse res) {
		int empno = Integer.parseInt(req.getParameter("empno"));
		String empname = req.getParameter("empname");
		Date joindate = Date.valueOf(req.getParameter("joindate"));
		String rank = req.getParameter("rank");
		String dept = req.getParameter("dept");

		EmpVO vo = new EmpVO();

		vo.setEmpno(empno);
		vo.setEmpname(empname);
		vo.setJoindate(joindate);
		vo.setRank(rank);
		vo.setDept(dept);

		EmpService em = new EmpService();

		int n = 0;
		try {
			n = em.empInsert(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (n > 0) {
			return "redirect::/empList";
		} else {
			int no = em.getMaxEmpNo();
			req.setAttribute("no", no);
			return "empInsert";
		}

	}

	public String getProcess(HttpServletRequest req, HttpServletResponse res) {
		EmpService em = new EmpService();
		int no = em.getMaxEmpNo();
		System.out.println("sadjhj");
		req.setAttribute("no", no);
		return "empInsert";
	}
}
