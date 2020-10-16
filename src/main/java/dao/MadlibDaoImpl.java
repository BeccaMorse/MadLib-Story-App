package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	public int insertStoryTemplate(StoryTemplate storyTemplate) {
		int insertId = 0;
		String sql = "INSERT INTO story_templates (name, body) VALUES (?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, storyTemplate.getName());
			ps.setString(2, storyTemplate.getBody());
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
	public int insertStory(Story story) {
		int insertId = 0;
		String sql = "INSERT INTO stories (user_id, template_id, body) VALUES (?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, story.getUserId());
			ps.setInt(2, story.getTemplateId());
			ps.setString(3, story.getBody());
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
	public User getUserByUsername(String username) {
		User user = new User();
		String sql = "SELECT * FROM users WHERE username = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
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
		StoryTemplate storyTemplate = new StoryTemplate();
		String sql = "SELECT * FROM story_templates WHERE template_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, templateId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				storyTemplate.setTemplateId(rs.getInt(1));
				storyTemplate.setName(rs.getString(2));
				storyTemplate.setBody(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return storyTemplate;
	}

	@Override
	public List<StoryTemplate> getAllTemplates() {
		List<StoryTemplate> templates = new ArrayList<>();
		String sql = "SELECT * FROM story_templates";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				templates.add(new StoryTemplate(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3)
				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return templates;
	}

	@Override
	public Story getStoryById(int storyId) {
		Story story = new Story();
		String sql = "SELECT stories.story_id, stories.user_id, story_templates.template_id, story_templates.name, stories.body FROM stories INNER JOIN story_templates ON stories.template_id = story_templates.template_id WHERE stories.story_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storyId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				story.setStoryId(rs.getInt(1));
				story.setUserId(rs.getInt(2));
				story.setTemplateId(rs.getInt(3));
				story.setName(rs.getString(4));
				story.setBody(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return story;
	}

	@Override
	public List<Story> getStoriesByUser(int userId) {
		List<Story> stories = new ArrayList<>();
		String sql = "SELECT stories.story_id, stories.user_id, story_templates.template_id, story_templates.name, stories.body FROM stories INNER JOIN story_templates ON stories.template_id = story_templates.template_id WHERE stories.user_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				stories.add(new Story(
					rs.getInt(1),
					rs.getInt(2),
					rs.getInt(3),
					rs.getString(4),
					rs.getString(5)
				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stories;
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
	public void deleteStoryTemplateById(int templateId) {
		String sql = "DELETE from story_templates WHERE template_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, templateId);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStoryById(int storyId) {
		String sql = "DELETE from stories WHERE story_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storyId);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
