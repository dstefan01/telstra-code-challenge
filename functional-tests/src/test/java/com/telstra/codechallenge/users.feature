Feature: user search api

  Background:
    * def port = karate.start('search-api-mock.feature').port
    * url 'http://localhost:' + port
    
 
  Scenario: Is the user api available and returning data
    When path '/user/unpopular'
    When method GET
    Then status 200
    And match each response.items ==
      """
      {
        id: '#string',
        login: '#string',
        html_url: '#string'
      }
      """