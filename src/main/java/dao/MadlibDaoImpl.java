package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import models.Story;
import models.StoryTemplate;
import models.User;

public class MadlibDaoImpl implements MadlibDao {
	private Connection conn;
	
	public MadlibDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int insertUser(User user) {
		int insertId = 0;
		String sql = "INSERT INTO users (username, password) VALUES (?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				insertId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertId;
	}

	@Override
	public void insertStory(Story story) {
	}

	@Override
	public User getUserById(int userId) {
		User user = new User();
		String sql = "SELECT * FROM users WHERE user_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public StoryTemplate getTemplateById(int templateId) {
		return null;
	}

	@Override
	public List<StoryTemplate> getAllTemplates() {
		return null;
	}

	@Override
	public Story getStoryById(int storyId) {
		return null;
	}

	@Override
	public List<Story> getStoriesByUser(int userId) {
		return null;
	}

	@Override
	public void deleteUserById(int userId) {
		String sql = "DELETE from users WHERE user_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStoryById(int storyId) {
	}

}
