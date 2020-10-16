package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout {

	public static void logout(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		if (session == null) {
			res.setStatus(400);
		} else {
			session.invalidate();
			res.setStatus(200);
		}
	}
}
