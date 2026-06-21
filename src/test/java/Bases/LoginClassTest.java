package Bases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class LoginClassTest {

	
	@Test
	public  void  testLogin() {
		
		 // 1. Start the core Playwright engine
            Playwright ply = Playwright.create();
                       
         // 2. Configure options to turn OFF headless mode
           BrowserType.LaunchOptions   options = new BrowserType.LaunchOptions()
        		   .setHeadless(false)
        		   .setSlowMo(1500);   //  every second its should  by action
           
           // 3. Launch the visible Chromium browser
           
           System.out.println(" browser lonching ");
           
      //   Browser browser = ply.chromium().launch(options);
                   Browser browser = ply.firefox().launch(options);

         // 4. Open a clean, isolated browser tab (Context)
         
        BrowserContext context = browser.newContext();
        
        Page page = context.newPage();
        // 5. Navigate to a website
        System.out.println("navigate new website ");
        page.navigate("https://testautomationpractice.blogspot.com/");

        // 6. Print the page title to the console to verify success
     System.out.println(" page tilte" + page.title());
     // finding the locter 
    String weburl = page.url();
    System.out.println(weburl);
  byte[] screenshort = page.screenshot();
     System.out.println(screenshort);
     
 Locator p = page.locator("//div[@class=\"widget-content\"]//ul[1]/li[5]");
     p.click();
     
   
   //  1. getByRole() Locators

  Locator home1 = page.locator("//nav[@role=\"navigation\"]//li[1]");
     home1.click();
     page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Primary Action")).click();
     
     
      Locator Toggle = page.locator("text = Toggle Button");
      Toggle.click();
      page.locator("#username").fill("testing");
//     page.goBack();
//     page.goForward();
//     page.reload();
 
     // 7. Clean up and close the browser window
     System.out.println("closeing the browser");
     browser.close();
     

	}
}
