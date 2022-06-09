Feature: a microwave microwaving
  We want to test some posibilities of a microwave while cooking

  Scenario: We want to use a microwave
    Given a microwave microwaving
    Then the door is closed
    And it is heating
    And the lamp of the microwave is off
    And the turntable is moving
    And it cooks
    And it is not empty
    
    Scenario: We want to use a microwave
    Given a microwave microwaving
    Then it is cooking

		Scenario: We want to use a microwave
    Given a microwave microwaving
    When I open the microwave
    Then it is opened with an item in it
    
    Scenario: We want to use a microwave
    Given a microwave microwaving
    When I introduce an item
    Then it warns me with 'You need to open the door first'
        
    Scenario: We want to use a microwave
    Given a microwave microwaving
    When I press the time increment button
    Then it sets timer to 60 seconds
         
    Scenario: We want to use a microwave
    Given a microwave microwaving
    When I press the power increment button
    Then it sets power to 200  
    
    Scenario Outline: We want to use a microwave
    Given a microwave microwaving
    When I press power_inc button <a> times
    Then the display should show "<b>"
    
     Examples: 
      | a   | b          | 
      | 1 | Power: 200 | 
      | 2 | Power: 300 |  
      | 5 | Power: 600 |
      | 10 | Power: 1000 |
    
    Scenario Outline: We want to use a microwave
    Given a microwave microwaving
    When I press time_inc button <a> times
    Then the display should show "<b>"
    
     Examples: 
      | a   | b          | 
      | 1 | Time: 60 | 
      | 2 | Time: 90 |  
      | 3 | Time: 120 |
      | 4 | Time: 150 |
    
    Scenario: We want to use a microwave
    Given a microwave microwaving
    When I press the time increment button
    And I press the power increment button
    And I press the cook button
    Then it cooks
    
    Scenario: We want to use a microwave
    Given a microwave microwaving
    When I press the power increment button
    And I press the time increment button
    And I press the power reset button
    And I press the timer reset button
    Then it sets power to 0
    And it sets timer to 0 seconds
    And it is not cooking
    
    Scenario: We want to use a microwave
    Given a microwave microwaving
    When I press the time increment button
    And I press the time decrement button
    And I press the time increment button
    Then it sets timer to 60 seconds
         
    Scenario: We want to use a microwave
    Given a microwave microwaving
    When I press the power increment button
    And I press the power decrement button
    Then it sets power to 100
    
    Scenario: We want to use a microwave
    Given a microwave microwaving
    When I press the power decrement button
    Then it sets power to 0
    And it is not cooking
    
    Scenario: We want to use a microwave
    Given a microwave microwaving
    When I press the time decrement button
    Then it sets timer to 0 seconds
    And it is not cooking
    