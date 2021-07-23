Feature: Assessment Step 16
@smoke
Scenario: Navigate to Admin Page
Given When I am in OrangeHRP Application
Then Login to application with credentials "Admin" and "admin123"
Then Dashboard Page is available
And click on Admin Menu
