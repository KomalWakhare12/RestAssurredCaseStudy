Feature: Get Method from Swagger petstore
Scenario: Verify Get method from swagger petstore 
    Given The get method of swagger petstore "https://petstore.swagger.io/v2/user/Meena123"
    When The petstore info get in Json format
    Then User gets response as 200