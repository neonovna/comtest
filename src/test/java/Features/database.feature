Feature: DB System

  Scenario: Add non existed System
    Given: I am on System page
    When Search for System
      | SystemTestName |
    And Search result is empty
    And Click on add System button
    And Enter System name
      | SystemTestName |
    And Enter System description
      | SystemTest Description |
    And Save System
    Then System is added
    And I am on System Details page

  Scenario Outline:  Add DB2, Teradata, Netezza DB
    Given I am on System Details page
      | SystemTestName |
    When I select <DBtype>
    And Enter values
      | Fields   | Values   |
      | host     | test.com |
      | port     | 8080     |
      | dbname   | nametest |
      | username | usertest |
      | password | passtest |
    Examples:
      | DBtype   |
      | DB2      |
      | Teradata |
      | Netezza  |
    And save DB
    Then DB is added

  Scenario Outline: Add Oracle DB
    Given I am on System Details page
      | SystemTestName |
    When I select Oracle DB type
    And Enter values
      | Fields   | Values   |
      | host     | test.com |
      | port     | 8080     |
      | username | usertest |
      | password | passtest |
    And select <name> with <value>
    Examples:
      | name    | value   |
      | SID     | SID     |
      | SERVICE | SERVICE |
    And save DB
    Then DB is added

  Scenario: Delete DB
    Given: I am on System page
    When Search for System
      | SystemTestName |
    And Search result is not empty
    And Click on edit System button
    And Delete DB by host
      | somehostnamehere |
    Then DB is deleted

  Scenario: Edit DB
    Given: I am on System page
    When Search for System
      | SystemTestName |
    And Search result is not empty
    And Click on edit System button
    And Enter values
      | Fields   | Values      |
      | host     | newtest.com |
      | port     | 8080        |
      | username | usertestq   |
      | password | passtestq   |
    Then DB is updated