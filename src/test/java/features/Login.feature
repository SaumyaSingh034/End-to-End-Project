Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And Navigate to the "http://www.qaclickacademy.com/" link
And Click on Login Link in the home page to land on Secure sign in Page
When User enters <username> and <password> and logs in
Then Verify that user is successfully logged in
And Close the browser

Examples:
|username				|password	|
|test99@gmail.com		|123456		|
|Saumya210@gmail.com	|123456666	|