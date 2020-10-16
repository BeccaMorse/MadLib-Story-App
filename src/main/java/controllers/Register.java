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

public class Register {

	public static void register(HttpServletRequest req, HttpServletResponse res) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			MadlibDao mDao = new MadlibDaoImpl(conn);
			ObjectMapper om = new ObjectMapper();
			JsonNode jsonNode = om.readTree(req.getReader());
			int insertId = mDao.insertUser(new User(0, jsonNode.get("username").asText(), jsonNode.get("password").asText()));
			if (insertId > 0) {
				HttpSession session = req.getSession();
				User user = mDao.getUserById(insertId);
				session.setAttribute("user", user);
				res.setStatus(201);
				res.getWriter().write(om.writeValueAsString(user));
			} else {
				res.setStatus(400);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
