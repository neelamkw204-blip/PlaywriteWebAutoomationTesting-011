package Bases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class loginclass {

	
	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		
		            Browser brwser = pw.chromium().launch(
		            		
		            		new BrowserType.LaunchOptions()
		            		.setHeadless(false)
		            		.setSlowMo(1500)
		        );
		            
		            Page page = brwser.newPage();
            		page.navigate("https://testautomationpractice.blogspot.com/p/playwrightpractice.html");
            		
            		brwser.close();
	}
}


//Playwright playwright = Playwright.create();
//Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//Page page = browser.newPage();
