package models;

public class Story {
	private int storyId;
	private int userId;
	private int templateId;
	private String name;
	private String body;
	
	public Story() {
		super();
	}

	public Story(int storyId, int userId, int templateId, String name, String body) {
		super();
		this.storyId = storyId;
		this.userId = userId;
		this.body = body;
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
	
	public int getTemplateId() {
		return templateId;
	}
	
	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Story [storyId=" + storyId + ", userId=" + userId + ", templateId=" + templateId + ", body=" + body + "]";
	}

}
