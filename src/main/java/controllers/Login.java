package controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.MadlibDao;
import dao.MadlibDaoImpl;
import models.User;
import util.ConnectionFactory;

public class Login {

	public static void login(HttpServletRequest req, HttpServletResponse res) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			MadlibDao mDao = new MadlibDaoImpl(conn);
			ObjectMapper om = new ObjectMapper();
			JsonNode jsonNode = om.readTree(req.getReader());
			String inputUsername = jsonNode.get("username").asText();
			String inputPassword = jsonNode.get("password").asText();
			User user = mDao.getUserByUsername(inputUsername);
			if (inputPassword.equals(user.getPassword())) {
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				res.setStatus(200);
				res.getWriter().write(om.writeValueAsString(user));
			} else {
				res.setStatus(400);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
