@Stack
Feature: Testing the Stack Module in dsAlgo Portal

Scenario Outline: Verify the user is able to navigate the Stack page.
			Given User is in the Home Page after Logged in for Stack page <Rownumber>
			When User clicks the Get Strated button in the Stack panel
			Then User should be directed to the Stack page
			Examples:
					|Rownumber|
					|1|

Scenario Outline:
Verify that the user is able to navigate to Stack page from dropdown at the top and navigate further 
	Given User is in the Home Page after logged in for Stack <Rownumber> 
	When User clicks on Stack from the DS drop down 
	Then User should be directed to the Stack page 
	Examples: 
		|Rownumber|
		|1| 
		
Scenario Outline:
Verify that the user is able to navigate to the Operations in Stack page 
	Given User is in the Stack page <Rownumber> 
	When User clicks on the hyperlink Operations in Stack 
	Then User lands on the Operations in Stack page 
	Examples: 
		|Rownumber|
		|1|
		
Scenario Outline: 
	Verify User is able to navigate to TryEditor Page of Operations in Stack
	Given User is in Introduction Page of Stack <Rownumber> 
	When User clicks on Try here>>> button for Stack 
	Then User should be redirected to TryEditor page for Stack 
	Examples: 
		|Rownumber|
		|1|
		
Scenario Outline: 
	Verify if user is able to successfully run the python code in Try Editor for Operations in Stack
	Given User is in TryEditor page of Operations in Stack and provided valid python code <Rownumber> 
	When User clicks on Run button for Stack 
	Then Python code should be successfully executed without any error for Stack 
	Examples: 
		|Rownumber|
		|1|
		
		
Scenario Outline: 
	Verify if alert message is popping up when user provided invalid input in Try Editor panel of Operations in Stack and clicked Run button
	Given User is in TryEditor page of Operations in Stack and provided invalid python code <Rownumber> 
	When User clicks on Run button for Stack 
	Then Alert message should be popped up for Stack 
	Examples: 
		|Rownumber|
		|2|
		
Scenario Outline:
Verify that the user is able to navigate to the Implementation Page of Stack 
	Given User is in the Stack page <Rownumber> 
	When User clicks on the hyperlink Implementation link in Stack 
	Then User lands on the Implementation Page in Stack 
	Examples: 
		|Rownumber|
		|1|
		
Scenario Outline: 
	Verify User is able to navigate to TryEditor Page of Implementation in Stack
	Given User is in Implementation Page of Stack <Rownumber> 
	When User clicks on Try here>>> button for Stack 
	Then User should be redirected to TryEditor page for Stack 
	Examples: 
		|Rownumber|
		|1|
		
Scenario Outline: 
	Verify if user is able to successfully run the python code in Try Editor for Implementation in Stack
	Given User is in TryEditor page of Implementation in Stack and provided valid python code <Rownumber> 
	When User clicks on Run button for Stack 
	Then Python code should be successfully executed without any error for Stack 
	Examples: 
		|Rownumber|
		|1|
		
		
Scenario Outline: 
	Verify if alert message is popping up when user provided invalid input in Try Editor panel of Implementation in Stack and clicked Run button
	Given User is in TryEditor page of Implementation in Stack and provided invalid python code <Rownumber> 
	When User clicks on Run button for Stack 
	Then Alert message should be popped up for Stack 
	Examples: 
		|Rownumber|
		|2|
		
Scenario Outline:
Verify that the user is able to navigate to the Application Page of Stack 
	Given User is in the Stack page <Rownumber> 
	When User clicks on the hyperlink Application link in Stack
	Then User lands on the Application Page in Stack 
	Examples: 
		|Rownumber|
		|1|
		
Scenario Outline: 
	Verify User is able to navigate to TryEditor Page of Application in Stack
	Given User is in Application Page of Stack <Rownumber> 
	When User clicks on Try here>>> button for Stack 
	Then User should be redirected to TryEditor page for Stack 
	Examples: 
		|Rownumber|
		|1|
		
Scenario Outline: 
	Verify if user is able to successfully run the python code in Try Editor for Application in Stack
	Given User is in TryEditor page of Application in Stack and provided valid python code <Rownumber> 
	When User clicks on Run button for Stack 
	Then Python code should be successfully executed without any error for Stack 
	Examples: 
		|Rownumber|
		|1|
		
		
Scenario Outline: 
	Verify if alert message is popping up when user provided invalid input in Try Editor panel of Application in Stack and clicked Run button
	Given User is in TryEditor page of Application in Stack and provided invalid python code <Rownumber> 
	When User clicks on Run button for Stack 
	Then Alert message should be popped up for Stack 
	Examples: 
		|Rownumber|
		|2|
		
Scenario Outline: 
	Verify if User is able to navigate to Practice Questions Page and view the content for Stack 
	Given User is in Stack Page <Rownumber> 
	When User clicks Practice Questions link for Stack 
	Then User should be able to navigate to Practice Questions page and page content should be displayed for Stack 
	Examples: 
		|Rownumber|
		|1| 					