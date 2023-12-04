Feature: Search functionality

  Background:
    Given user has opened application url

  @search
  Scenario: Search for valid product
    When user enters valid product "hp" into search field
    And clicks on search icon
    Then user should be navigated to search  results page and valid product options should be displayed

@search
  Scenario: search without providing any product
    When user does not provide any product in search field
    And clicks on search icon
    Then proper message should be displayed indicating no product matching search

@search
  Scenario: search for non-existent product
    When user enters non-existent product into search field "period"
    And clicks on search icon
    Then proper message should be displayed indicating no product matching search

