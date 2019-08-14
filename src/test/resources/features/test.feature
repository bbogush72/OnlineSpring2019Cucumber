Feature: 

	#User story 2:”As an authorized user I should be able to
	#access Vehicle Contract page.”
	#• Acceptance Criteria:
	#1.Verify that Only authorized user should be able to access Vehicle Contract.
	#(Note: authorized users: store manager, sales manager,admin)
	#2.Verify that Non authorized user should not be able to access Vehicle Contract
	#(Note: Truck driver)
	@VYT19-84
	Scenario: authorized users can view vehicle contract page
		
		VYT19-84
		Feature :
		     authorized users can view vehicle contract page
		
		    @ac1
		    Scenario Outline: only authorized user can access vehicle contract
		    
		    Given driver logs in vytrack with "username" "password"
		    When hover over Fleet tab
		    Then clicks on Vehicle contract
		    And user can see All Vehicle Contract
				Examples:
					| username | password      |
					| user39   |  UserUser123  |
					| storemanager39   |  UserUser123    |
					| salesmanager39   |  UserUser123    |
		
		
		    @ac2
		    Scenario Outline: driver cannot access vehicle contract
			Given "user" opens vytrack homepage with "password"
		    When hover over Fleet tab
		    Then clicks on Vehicle contract
		    Then "user" cannot view contract 
		    And user see this message "You do not have permission to perform this action."


				Examples:
					| username | password      |
					| user39   |  UserUser123  |
					| storemanager39   |  UserUser123    |
					| salesmanager39   |  UserUser123    |
		
		
		
		
		
		