package dao;

import java.util.List;

import models.Story;
import models.StoryTemplate;
import models.User;

public interface MadlibDao {

	public int insertUser(User user);
	
	public void insertStory(Story story);
	
	public User getUserById(int userId);
	
	public StoryTemplate getTemplateById(int templateId);
	
	public List<StoryTemplate> getAllTemplates();
	
	public Story getStoryById(int storyId);
	
	public List<Story> getStoriesByUser(int userId);
	
	public void deleteUserById(int userId);
	
	public void deleteStoryById(int storyId);
}
