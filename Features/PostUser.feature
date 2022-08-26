
Feature: Post Method from Swagger petstore

Scenario: Verify the Post method from swagger petstore
      Given The petstore API for Post method "https://petstore.swagger.io/v2/user/createWithList"
      When The petstore information post in json format
      Then The Response is returned as 200