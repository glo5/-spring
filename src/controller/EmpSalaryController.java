package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmpService;
import vo.SalaryVO;

public class EmpSalaryController implements Controller {
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EmpService emp = new EmpService();
		List<SalaryVO> list = emp.empSalary();
		req.setAttribute("list", list);
		return "empSalary";
	} 
}
