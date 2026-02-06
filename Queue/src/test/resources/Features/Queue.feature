Feature: Queue Module

Background:  Given user successfully signed in to DSAlgo portal 
  
# -------------------- Queue --------------------

Scenario: Verify Queue page header
  Given User is on the Home page
  When User clicks on the Get Started button present in Queue card
  Then Queue page header should be "Queue"

Scenario Outline: Verify topics present in Queue page
  Given User is in Queue Page
  When User clicks on "<topicLinks>"
  Then User should navigate to "<ExpectedTitle>"

Examples:
  | topicLinks                             | ExpectedTitle                          |
  | Implementation of Queue in Python      | Implementation of Queue in Python      |
  | Implementation using collections.deque | Implementation using collections.deque |
  | Implementation using array             | Implementation using array             |
  | Queue Operations                       | Queue Operations                       |

# -------------------- Common Topic Behavior --------------------

Scenario Outline: Verify Topic page basic elements
  Given User is in Queue Page
  When User clicks on "<topic>"
  Then User should navigate to "<topic>"
  Then practice questions should be present
  Then Try here should be present

Examples:
  | topic                                  |
  | Implementation of Queue in Python      |
  | Implementation using collections.deque |
  | Implementation using array             |
  | Queue Operations                       |

Scenario Outline: Verify Practice page displays questions
  Given User is in "<topic>" page
  When User clicks on practice questions
  Then User should navigate to practice page

Examples:
  | topic                                  |
  | Implementation of Queue in Python      |
  | Implementation using collections.deque |
  | Implementation using array             |
  | Queue Operations                       |

Scenario Outline: Verify the functionality of Try Here button on Queue topic pages
  Given User is in "<topic>" page
  When User clicks on Try here button
  Then User should navigate to Try Editor page
  Then Run Button Appears on the Page

Examples:
  | topic                                  |
  | Implementation of Queue using Python   |
  | Implementation using collections.deque |
  | Implementation using array             |
  | Queue Operations                       |

# -------------------- Code Execution --------------------

Scenario: Valid code execution
  Given User is in Try editor page
  When User clicks run button after entering valid code
  Then Expected output should be displayed

Scenario: Invalid code execution
  Given User is in Try editor page
  When User clicks run button after entering invalid code
  Then Alert should appear with error message 
