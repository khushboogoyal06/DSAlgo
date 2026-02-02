Feature: Queue Module

Background: user is logged in to DS Algo portal
  Given User opens DS Algo Home page
  When User clicks on the "Sign in" link
  When User enters valid username and password
  When User clicks on the "Login" button
  Then User should be redirected to the Home page
# -------------------- Queue --------------------

Scenario: Verify Queue page title
  Given User is on the Home page
  When User clicks on the Get Started button present in Queue card
  Then Queue page header should be "Queue"

Scenario Outline: Verify topics present in Queue page
  Given User is in Queue Page
  When User views the Queue topics
  Then Topic covered should have "<topic>"

Examples:
  | topic |
  | Implementation of Queue using Python |
  | Implementation using collections.deque |
  | Implementation using array |
  | Queue Operations |

# -------------------- Common Topic Behavior --------------------

Scenario Outline: Verify Topic page basic elements
  Given User is in Queue Page
  When User clicks "<topic>"
  Then Title should be "<topic>"
  Then Practice question should be present
  Then Try here should be present

Examples:
  | topic |
  | Implementation of Queue using Python |
  | Implementation using collections.deque |
  | Implementation using array |
  | Queue Operations |

Scenario Outline: Verify Practice page displays questions
  Given User is in "<topic>" page
  When User clicks practice question
  Then user should navigate to practice page

Examples:
  | topic |
  | Implementation of Queue using Python |
  | Implementation using collections.deque |
  | Implementation using array |
  | Queue Operations |

Scenario Outline: Verify Try here navigation
  Given User is in "<topic>" page
  When User clicks Try here
  Then User should be redirected to Assessment page
  Then Run Button Appears on the Page

Examples:
  | topic |
  | Implementation of Queue using Python |
  | Implementation using collections.deque |
  | Implementation using array |
  | Queue Operations |

# -------------------- Code Execution --------------------

Scenario: Valid code execution
  Given User is in assessment page
  When User clicks run button after entering valid code
  Then Expected output should be displayed

Scenario: Invalid code execution
  Given User is in assessment page
  When User clicks run button after entering invalid code
  Then Alert should appear with error message
