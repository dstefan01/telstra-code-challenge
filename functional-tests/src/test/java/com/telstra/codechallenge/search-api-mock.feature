Feature: stateful mock server

Background:
* configure cors = true

Scenario: pathMatches('/user/unpopular')
	* def response = 
	"""
	{
	   "items":[
	      {
	         "id":"44",
	         "login":"errfree",
	         "html_url":"https://github.com/errfree"
	      },
	      {
	         "id":"81",
	         "login":"engineyard",
	         "html_url":"https://github.com/engineyard"
	      }
	   ]
	}
	"""

Scenario: pathMatches('/repository/popular')
	* def response =
	"""
	{
	   "items":[
	      {
	         "html_url":"https://github.com/LukeSmithxyz/based.cooking",
	         "watchers_count":224,
	         "language":"Shell",
	         "description":"A simple culinary website.",
	         "name":"based.cooking"
	      }
	      {
	         "html_url":"https://github.com/mhgolkar/Arrow",
	         "watchers_count":113,
	         "language":"GDScript",
	         "description":"Game Narrative Design Tool",
	         "name":"Arrow"
	      }
	   ]
	}
	"""
	
Scenario:
    # catch-all
    * def responseStatus = 404
    * def responseHeaders = { 'Content-Type': 'text/html; charset=utf-8' }
    * def response = <html><body>Not Found</body></html>