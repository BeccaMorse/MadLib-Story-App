package models;

public class StoryTemplate {
	private int templateId;
	private String name;
	private String body;
	
	public StoryTemplate() {
		super();
	}

	public StoryTemplate(int templateId, String name, String body) {
		super();
		this.templateId = templateId;
		this.name = name;
		this.body = body;
	}

	public int getTemplateId() {
		return templateId;
	}

	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "StoryTemplate [templateId=" + templateId + ", name=" + name + ", body=" + body + "]";
	}

}
