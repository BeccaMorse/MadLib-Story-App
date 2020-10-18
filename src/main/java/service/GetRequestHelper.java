package service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.Stories;
import controllers.StoryTemplates;

public class GetRequestHelper {

	public static void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.matches("/api/templates")) {
			StoryTemplates.getAllTemplates(req, res);
		} else if (uri.matches("/api/stories")) {
			Stories.getStoriesByUser(req, res);
		} else if (uri.matches("/")) {
			RequestDispatcher redir = req.getRequestDispatcher("/index.html");
			redir.forward(req, res);
		}
	}
}
