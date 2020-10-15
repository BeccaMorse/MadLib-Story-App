package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = {
				""
		}
	)

public class MasterServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		ServletOutputStream out = res.getOutputStream();
//		String result = "servlet working";
//		out.write(result.getBytes());
//		out.flush();
//		out.close();
		RequestDispatcher redir = req.getRequestDispatcher("/index.html");
		redir.forward(req, res);
	}

}
