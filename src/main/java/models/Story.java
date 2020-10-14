package models;

public class Story {
	private int storyId;
	private int userId;
	private String story;
	
	public Story() {
		super();
	}

	public Story(int storyId, int userId, String story) {
		super();
		this.storyId = storyId;
		this.userId = userId;
		this.story = story;
	}

	public int getStoryId() {
		return storyId;
	}

	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	@Override
	public String toString() {
		return "Story [storyId=" + storyId + ", userId=" + userId + ", story=" + story + "]";
	}

}
