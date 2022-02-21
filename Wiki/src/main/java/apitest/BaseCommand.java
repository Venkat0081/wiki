package apitest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Venkat
 *
 */
public class BaseCommand {
	 
    public String baseURI;
    public String petID;
    public String userID;
    public String petsByStatus;
    public int orderID;
    public String petName;

    /**
     * 
     * @throws IOException
     */
    public BaseCommand() throws IOException {

        FileInputStream file = null;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//apiconfig.properties");
			getProperties(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
  
   
   
    
    /**
     * 
     * @param prop
     * @throws IOException 
     */
	public void getProperties(FileInputStream file) throws IOException {
		Properties prop = new Properties();
		prop.load(file);		
		baseURI = prop.getProperty("baseURI");
		petID = prop.getProperty("petID");
		userID =  prop.getProperty("userID");
		petsByStatus = prop.getProperty("petsByStatus");
		orderID = Integer.parseInt(prop.getProperty("orderID"));
		petName =  prop.getProperty("petName");

	}
    
}


