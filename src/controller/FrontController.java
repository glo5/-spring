package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.naming.ConfigurationException;
import javax.security.auth.login.ConfigurationSpi;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.file.ConfigFileLoader;

import com.sun.org.apache.xerces.internal.utils.ConfigurationError;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import service.EmpService;

public class FrontController extends HttpServlet {

	String charset = null;
	HashMap<String, Controller> list = new HashMap<>();

	private String prefiex = "/WEB-INF/view/";
	private String postfix = ".jsp";

	public void init(ServletConfig config) throws ServletException {
		list = new HashMap<>();
		list.put("/", new MainController());
		list.put("/empList", new EmpListController());
			list.put("/empsalary", new EmpSalaryController());
			list.put("/empInsert", new EmpInsertController());
			list.put("/empUpdate", new EmpUpdateController());

		charset = config.getInitParameter("charset");

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding(charset);

		String url = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = url.substring(contextPath.length());

		Controller c = list.get(path);

		String result = "notfound";

		if (c != null) {
			result = c.execute(req, resp);
		}
		if(result.startsWith("redirect::")) {
			url = result.substring("redirect::".length());
			resp.sendRedirect(url);
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher(prefiex + result +postfix);
			dispatcher.forward(req, resp);
		}

	}
}
