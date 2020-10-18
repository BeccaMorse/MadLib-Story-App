# MadLib-Story-App
Users can play MadLibs-style games online!

## Back end routes
GET

"" - serves front end
"/api/templates" - gets all story templates  
"/api/stories" - gets all stories for currently logged in user

POST

"/api/register" - registers a new user.  Request body should contain {username, password, confirmPassword}  
"/api/login" - login existing user.  Request body should contain {username, password}  
"/api/logout" - logout.  No request body needed  
"/api/templates" - add a story template.  Request body should contain {name, body}  
"/api/stories" - add a story.  Request body should contain {templateId, body}  