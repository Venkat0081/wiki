To run the project please follow the steps

1. Go to suites\testng.xml
2. Right click the testng.xml and Run As "TestNG Test"
3. Verify the results in \test-output\index.html

---------------------------------------------------------------------------------------------------------------------------------------
Please find the details for the assigned Tasks.


**Task 1 :**  Attached the "Exploratry Testing.xlsx" for the Exploratry Testing in the given link.

**Task 2 :**
 Note: Search functionality is an Regression scenario hence the below scenarios are selected for automation.

Test Case 1 : getPageTitle
 
   Description : The given page is invoked and title is evaluated.
   Reason for selection : page load is most important to test further functionalities and to meet the user expectations.
   Implementation : It's implemented using selenium Assert.assertTrue condition.
   
Test Case 2 : getScreenshot
    Description : Search text with default filters
    Reason for selection : The website should retrieve the relevant details for the given text in the search text fields. Status should be updated in defect tracker with screenshot.
    Implementation :It's implemented using selenium Assert.assertTrue condition. The website loaded successfully and  it's validated using visibilityOfElementLocated method for  submit button. And, the screenshot was taken using getScreenshotAs method from selenium.

Test Case 3 :  getSearchResult
 
   Description : Search text with default filters like "Relevant Search"
   Reason for selection : Retrived results should be validated.
   Implementation : It's implemented using selenium Assert.assertTrue condition. The website was loaded successfully and  it's validated using visibilityOfElementLocated method for submit button. Once it is successfully loaded  the search text is entered from the properties file to search further. The relevant searches are iterated and evaluated with entered text from the properties file.

--------------------------------------------------------------------------------------------------------------------------------------------------
**Task 3 :**

 I have completed  5 api tests from the given URL. I have implemented the Rest Assured api to retrieve the value and validated the same.
 
 The Implemented services are  below:
 
 1.getPetDetails  :  Retrieved the pet details for the given petID in properties file which is present and test case is PASSED.

 2.getAvailablePetsByStatus :  Retrieved the pets based on the status as "available" and verified with the name as "doggie"  which is present in the retrieved results. Therefore the test case is PASSED.

 3.findOrderById :  Checking the order no 8 is present and found that no more order therefore the tested case is FAILED.

 4.userLogin :  Checking existing user named "test" is present. If yes, retrieving the password to relogin the  same.   

	Defect to be raised for userLogin case :
	Bug Description : Response is inconsistent which is a bug in the system. 
	Expected Results : User "test" exists in the system hence  response should be always consistent  
	Actual Results : Response is coming as null some times.

5.getInventory -  Retrieving inventory details and validating  with  pendingInventory id no 20 which is not present hence the test case is FAILED.
 
 


		
