
@login @Queuemodule 
Feature: Queue Module


  Background:
    Given User is on "Home" page


Scenario: Verify Queue page header
  Given User is on "Home" page
  When User clicks on the Get Started button present in Queue card
  Then Queue page header should be "Queue"

