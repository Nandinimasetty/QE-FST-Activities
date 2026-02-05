@activity4
Feature: Login Test

Scenario: Testing Login without Examples
Given user is on the login pagee
When the user enters "admin" and "password"
And clicks the submit buttonn
Then get thee confirmation text and verify message as "Welcome Back, Admin!"