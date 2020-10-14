package models;

public class StoryTemplate {
	private int templateId;
	private String story;
	
	public StoryTemplate() {
		super();
	}

	public StoryTemplate(int templateId, String story) {
		super();
		this.templateId = templateId;
		this.story = story;
	}

	public int getTemplateId() {
		return templateId;
	}

	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	@Override
	public String toString() {
		return "StoryTemplate [templateId=" + templateId + ", story=" + story + "]";
	}
	

}
