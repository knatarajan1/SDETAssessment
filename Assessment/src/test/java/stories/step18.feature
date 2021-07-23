Feature: Assessment Step 18

@regression
Scenario Outline: Login Test

When User enters the username as "<userName>"
And User enters the password as "<password>"
And User clicks the login button
Then Validate login

Examples: 
|userName|password|
|admin|admin123|
|admins|admin1234|

# For Step 18, consider 4 scenarios as Step 16 Feature file (1 scenario), 
#Step 17 Feature file (1 scenario) and Step 18 Feature file (1 sceanrio with two data sets)