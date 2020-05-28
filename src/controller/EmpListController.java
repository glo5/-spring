package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmpService;
import vo.EmpVO;

public class EmpListController implements Controller {
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EmpService service = new EmpService();
		List<EmpVO> list = service.empList();
		req.setAttribute("list", list);
		return "empList";
	}
}
