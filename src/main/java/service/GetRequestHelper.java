package service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetRequestHelper {

	public static void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher redir = req.getRequestDispatcher("/index.html");
		redir.forward(req, res);
	}
}
