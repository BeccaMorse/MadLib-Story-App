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
import models.Story;
import models.User;
import util.ConnectionFactory;

public class Stories {

	public static void addStory(HttpServletRequest req, HttpServletResponse res) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			MadlibDao mDao = new MadlibDaoImpl(conn);
			ObjectMapper om = new ObjectMapper();
			JsonNode jsonNode = om.readTree(req.getReader());
			HttpSession session = req.getSession(false);
			if (session == null) {
				res.setStatus(401);
			} else {
				int userId = ((User) session.getAttribute("user")).getUserId();
				int insertId = mDao.insertStory(new Story(0, userId, jsonNode.get("templateId").asInt(), jsonNode.get("name").asText(), jsonNode.get("body").asText()));
				res.setStatus(201);
				res.getWriter().write(om.writeValueAsString(mDao.getStoryById(insertId)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
