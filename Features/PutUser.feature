
Feature: PUT Method from Swagger petstore

Scenario: Verify the Put method from swagger petstore
      Given The petstore API for Put method "https://petstore.swagger.io/v2/user/Meena123"
      When The petstore information Put in json format
      Then The Response returned as 200