package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.MadlibDaoImpl;
import models.Story;
import models.StoryTemplate;
import models.User;
import util.ConnectionFactory;

public class DaoTest {
	private static Connection conn;
	private static MadlibDaoImpl mDao;
	private static int userId;
	private static int templateId;
	private static int storyId;
	
	@BeforeClass
	public static void setup() {
		conn = ConnectionFactory.getConnection();
		mDao = new MadlibDaoImpl(conn);
		User testUser = new User(0, "testusername", "testpassword");
		userId = mDao.insertUser(testUser);
		StoryTemplate testTemplate = new StoryTemplate(0, "testname", "testbody");
		templateId = mDao.insertStoryTemplate(testTemplate);
		Story testStory = new Story(0, userId, templateId, "testname", "teststorybody");
		storyId = mDao.insertStory(testStory);
	}
	
	@Test
	public void testGetUserById() {
		User userResult = mDao.getUserById(userId);
		assertEquals("testusername", userResult.getUsername());
		assertEquals("testpassword", userResult.getPassword());
	}
	
	@Test
	public void testGetUserByUsername() {
		User userResult = mDao.getUserByUsername("testusername");
		assertEquals("testusername", userResult.getUsername());
		assertEquals("testpassword", userResult.getPassword());
	}
	
	@Test
	public void testGetTemplateById() {
		StoryTemplate templateResult = mDao.getTemplateById(templateId);
		assertEquals("testname", templateResult.getName());
		assertEquals("testbody", templateResult.getBody());
	}
	
	@Test
	public void testGetStoryById() {
		Story storyResult = mDao.getStoryById(storyId);
		assertEquals("testname", storyResult.getName());
		assertEquals("teststorybody", storyResult.getBody());
	}
	
	@Test
	public void testGetAllTemplates() {
		List<StoryTemplate> result = mDao.getAllTemplates();
		assertNotEquals(0, result.size());
	}
	
	@Test
	public void testGetStoriesByUser() {
		List<Story> result = mDao.getStoriesByUser(userId);
		assertEquals(1, result.size());
	}
	
	@AfterClass
	public static void cleanup() {
		mDao.deleteStoryById(storyId);
		mDao.deleteStoryTemplateById(templateId);
		mDao.deleteUserById(userId);
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
