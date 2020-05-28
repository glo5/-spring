package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmpService;
import vo.EmpVO;

public class EmpUpdateController implements Controller {
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
			n = em.empUpdate(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (n > 0) {
			return "redirect::/empList";
		} else {

			return "empUpdate";
		}

	}

	public String getProcess(HttpServletRequest req, HttpServletResponse res) {
		int empno = Integer.parseInt(req.getParameter("empno"));
		EmpService em = new EmpService();
		EmpVO vo = em.getEmp(empno);
		req.setAttribute("vo", vo);
		return "empUpdate";
	}
}
