package selenideTests;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.SearchResultsPage;

public class FirstTest {

	public FirstTest() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeTest
	
	public void setup()
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
	}
	
	 @Test
	 public void userCanSearch() {
		    open("https://duckduckgo.com");
		    new HomePage().searchFor("selenide java");

		    SearchResultsPage results = new SearchResultsPage();
		    results.checkResultsSizeIsAtLeast(1);
		    results.checkResultHasTest(0, "Selenide: concise UI tests in Java");
		  }
}
