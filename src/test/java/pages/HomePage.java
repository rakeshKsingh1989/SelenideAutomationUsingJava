package pages;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.*;

public class HomePage {

	public HomePage() {
		// TODO Auto-generated constructor stub
	}
	
	private SelenideElement searchField = $(byName("q"));

	  public void searchFor(String text) {
	    searchField.val(text).pressEnter();
	  }
}
