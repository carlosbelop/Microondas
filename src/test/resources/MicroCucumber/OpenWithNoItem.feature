Feature: An opened microwave without anything in it
  We want to test some posibilities of an empty opened microwave

  Scenario: We want to use a microwave
    Given an opened microwave with no item
    Then the door is opened
    And it is not heating
    And the lamp of the microwave is on
    And the turntable is still
    And it is not cooking right now
    And it is empty
    
    Scenario: We want to use a microwave
    Given an opened microwave with no item
    Then it is opened without anything in it

		Scenario: We want to use a microwave
    Given an opened microwave with no item
    When I close the microwave
    Then it is closed without anything in it
    
    Scenario: We want to use a microwave
    Given an opened microwave with no item
    When I introduce an item
    Then it is opened with an item in it
        
    Scenario: We want to use a microwave
    Given an opened microwave with no item
    When I press the time increment button
    Then it sets timer to 30 seconds
         
    Scenario: We want to use a microwave
    Given an opened microwave with no item
    When I press the power increment button
    Then it sets power to 100  
    
    Scenario Outline: We want to use a microwave
    Given an opened microwave with no item
    When I press power_inc button <a> times
    Then the display should show "<b>"
    
     Examples: 
      | a   | b          | 
      | 1 | Power: 100 | 
      | 2 | Power: 200 |  
      | 5 | Power: 500 |
      | 10 | Power: 1000 |
    
    Scenario Outline: We want to use a microwave
    Given an opened microwave with no item
    When I press time_inc button <a> times
    Then the display should show "<b>"
    
     Examples: 
      | a   | b          | 
      | 1 | Time: 30 | 
      | 2 | Time: 60 |  
      | 3 | Time: 90 |
      | 4 | Time: 120 |
    
    Scenario: We want to use a microwave
    Given an opened microwave with no item
    When I press the time increment button
    And I press the power increment button
    And I press the cook button
    Then it warns me with 'Introduce Item'
    
    Scenario: We want to use a microwave
    Given an opened microwave with no item
    When I press the power increment button
    And I press the time increment button
    And I press the power reset button
    And I press the timer reset button
    Then it sets power to 0
    And it sets timer to 0 seconds
    
    Scenario: We want to use a microwave
    Given an opened microwave with no item
    When I press the time increment button
    And I press the time decrement button
    And I press the time increment button
    Then it sets timer to 30 seconds
         
    Scenario: We want to use a microwave
    Given an opened microwave with no item
    When I press the power increment button
    And I press the power decrement button
    Then it sets power to 0  
    
    Scenario: We want to use a microwave
    Given an opened microwave with no item
    When I press the power decrement button
    Then it sets power to 0 
    
    Scenario: We want to use a microwave
    Given an opened microwave with no item
    When I press the time decrement button
    Then it sets timer to 0 seconds
    