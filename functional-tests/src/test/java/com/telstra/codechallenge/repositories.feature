Feature: repositories search api

  Background:
    * def port = karate.start('search-api-mock.feature').port
    * url 'http://localhost:' + port
    
 
  Scenario: Is the repository search api available and returning data
    When path '/repository/popular'
    When method GET
    Then status 200
    And match each response.items ==
      """
      {
        name: '#string',
        description: '#string',
        language: '##string',
        watchers_count: '#number',
        html_url: '#string'
      }
      """