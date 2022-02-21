


Task 1 :

Explority Testing is done. Corresponding test cases and suggested improvements are identified.
Test cases are written in xls format and uploaded the same in the path -->
--------------------------------------------------------------------------------------------------------------------------------------------------
Task 2 : 

  Case 1 : getPageTitle 
  
   Description : 
          The given page is invoked and title is evaluated.
   Reason for selection : 
           page load is most important to test furhter funstionalities and to meet the user expectations
   Implementation : 
          Its implemented usig seleinum Assert.assertTrue condition.


  Case 2 : getScreenshot 
		Description :
			Search text with default filters
		Reason for selection :
			The website should retrive the relavnt details for the given test in the search  test fileds. Status should be updated in defect tracker with screenshot.
			
	 Implementation :
	       Its implemented usig seleinum Assert.assertTrue condition. The wesite should load successfully and  its confiremd using visibilityOfElementLocated method for submit button. 
	 screenshot will be taken using getScreenshotAs method from selenium.
	
 Case 3 :  getSearchResult
  
   Description :
        Search text wit default filters like "Relavent Search"
   Reason for selection :
        The website should retrive the relavnt details for the given test in the search  test fileds.
   Implementation :
        Its implemented usig seleinum Assert.assertTrue condition. The wesite should load successfully and  its confiremd using visibilityOfElementLocated method for submit button. Once its succesfully loaded  the search text is enterd from the properties file to search further. The relavent search are iterated and valuated with entered text from the properties file.
		
