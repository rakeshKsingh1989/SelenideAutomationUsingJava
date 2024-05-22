package selenideTests;
import static com.codeborne.selenide.Selenide.open;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.SearchResultsPage;
public class TestSearch {
	
	
	@BeforeTest
	
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		
	}	
	@Test(dataProvider="ReadExcel") 		 
	public void userCanSearch(String searchText, String expectedUItext)		 
		 {
			    open("https://duckduckgo.com");
			    new HomePage().searchFor(searchText);
			    SearchResultsPage results = new SearchResultsPage();
			    results.checkResultsSizeIsAtLeast(1);
			    results.checkResultHasTest(0, expectedUItext);
		}	
	 
	 @Test()
	 public void userCanLaunch()
	 
	 {
		    open("https://duckduckgo.com");
		    //new HomePage().searchFor(searchText);
		   // SearchResultsPage results = new SearchResultsPage();
		   // results.checkResultsSizeIsAtLeast(1);
		    //results.checkResultHasTest(0, expectedUItext);
	}	 
	 
	 @DataProvider(name="ReadExcel")
	 public Object[][] testDataDenerator() throws IOException
	 {
		 FileInputStream file= new FileInputStream("./TestData/TestData.xlsx");
		 XSSFWorkbook wb = new XSSFWorkbook(file);
		 
			XSSFSheet loginSheet = wb.getSheet("Selenide");
			 int noOfData= loginSheet.getPhysicalNumberOfRows();
			 
			 Object [][] testData= new Object[noOfData][2];
			 
			 for(int i=0;i<noOfData;i++)
			 {
				 XSSFRow row =loginSheet.getRow(i);
				 XSSFCell searchText=row.getCell(0);
				 XSSFCell expectedUIText=row.getCell(0);
				 testData[i][0] = searchText.getStringCellValue();
				 testData[i][1] = expectedUIText.getStringCellValue();
			 }		
			return testData;
	}
	 
}

