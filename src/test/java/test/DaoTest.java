package test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.MadlibDaoImpl;
import models.User;
import util.ConnectionFactory;

public class DaoTest {
	private static Connection conn;
	private static MadlibDaoImpl mDao;
	private static int userId;
	
	@BeforeClass
	public static void setup() {
		conn = ConnectionFactory.getConnection();
		mDao = new MadlibDaoImpl(conn);
	}
	
	@Test
	public void testInsertUser() {
		User testUser = new User(0, "testusername", "testpassword");
		userId = mDao.insertUser(testUser);
		User result = mDao.getUserById(userId);
		assertEquals("testusername", result.getUsername());
	}
	
	@AfterClass
	public static void cleanup() {
		mDao.deleteUserById(userId);
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
