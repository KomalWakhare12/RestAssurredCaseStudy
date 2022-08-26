Feature: Delete from swagger petstore

 Scenario: Test the delete method service from petsore
    Given The petstore API URI for delete Method "https://petstore.swagger.io/v2/user/Rina123"
    When The petstore info Get deleted
    Then User gets response code as 200