@login @Graphmodule
Feature: Graph Module

Background:
  Given User is logged into DS Algo portal successfully
  
@GraphPageHeader
Scenario: Verify Graph page header
  When User clicks on the Get Started button present in graph card
  Then Graph page header should be "Graph"

@GraphTopicsNavigation
Scenario Outline: Verify topics present in Graph module
  Given User is in Graph Page
  When User clicks on Graph topic "<topicLinks>"
  Then User should navigate to "<ExpectedTitle>"
  
Examples:
  | topicLinks            | ExpectedTitle        |
  | Graph                 | Graph                |
  | Graph Representations | Graph Representations|

@GraphPracticeNavigation
Scenario Outline: Verify Practice page navigation from Graph topics
  Given User is in "<topic>" page
  When User clicks on practice questions
  Then User should navigate to practice page
  
Examples:
  | topic                 |
  | Graph                 |
  | Graph Representations |
  
@GraphTryHereNavigation
Scenario Outline: Verify Try Here navigation from Graph topics
  Given User is in "<topic>" page
  When User clicks on Try here button
  Then User should navigate to Try Editor page
  Then Run Button Appears on the Page 
  
Examples:
  | topic                 |
  | Graph                 |
  | Graph Representations |

@GraphValidCodeExecution
Scenario Outline: Verify the functionality of valid code execution
  Given User is in Try editor page of corresponding "<topic>"
  When User clicks run button after entering valid code
  Then Expected output should be displayed 
  
Examples:
  | topic                 |
  | Graph                 |
  | Graph Representations |

@GraphInvalidCodeExecution
Scenario Outline: Verify the functionality of Invalid code execution
  Given User is in Try editor page of corresponding "<topic>"
  When User clicks run button after entering invalid code
  Then Alert should appear with error message
  
Examples:
  | topic                 |
  | Graph                 |
  | Graph Representations |