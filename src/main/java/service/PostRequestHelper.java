package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.Login;
import controllers.Logout;
import controllers.Register;
import controllers.Stories;
import controllers.StoryTemplates;

public class PostRequestHelper {

	public static void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.matches("/api/register")) {
			Register.register(req, res);
		} else if (uri.matches("/api/login")) {
			Login.login(req, res);
		} else if (uri.matches("/api/logout")) {
			Logout.logout(req, res);
		} else if (uri.matches("/api/templates")) {
			StoryTemplates.addStoryTemplate(req, res);
		} else if (uri.matches("/api/stories")) {
			Stories.addStory(req, res);
		}
	}
}
