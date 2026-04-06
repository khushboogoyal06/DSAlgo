@login @Graphmodule
Feature: Graph Module

Background:
  Given User is logged into DS Algo portal successfully


@GraphPageHeader
Scenario: Verify Graph page header
  Given User is on the Home page
  When User clicks on the Get Started button present in graph card
  Then Graph page header should be "Graph"


@GraphTopicsNavigation
Scenario Outline: Verify topics present in Graph module
  Given User is in Graph Page
  When User clicks on Graph topic "<topic>"
  Then User should navigate to Graph title "<ExpectedTitle>"

Examples:
  | topic                 | ExpectedTitle         |
  | Graph                 | Graph                 |
  | Graph Representations | Graph Representations |


@GraphPracticeNavigation
Scenario Outline: Verify Practice page navigation from Graph topics
  Given User is in Graph "<topic>" page
  When User clicks on Graph practice questions
  Then User should navigate to Graph practice page

Examples:
  | topic                 |
  | Graph                 |
  | Graph Representations |


@GraphTryHereNavigation
Scenario Outline: Verify Try Here navigation from Graph topics
  Given User is in Graph "<topic>" page
  When User clicks on Graph Try here button
  Then User should navigate to Graph Try Editor page
  And Graph Run Button should be visible

Examples:
  | topic                 |
  | Graph                 |
  | Graph Representations |


@GraphValidCodeExecution
Scenario Outline: Verify valid code execution in Graph Try Editor
  Given User is in Graph Try editor page of corresponding "<topic>"
  When User runs valid Graph code
  Then Graph output should be displayed

Examples:
  | topic                 |
  | Graph                 |
  | Graph Representations |


@GraphInvalidCodeExecution
Scenario Outline: Verify invalid code execution in Graph Try Editor
  Given User is in Graph Try editor page of corresponding "<topic>"
  When User runs invalid Graph code
  Then Graph error alert should be displayed

Examples:
  | topic                 |
  | Graph                 |
  | Graph Representations |