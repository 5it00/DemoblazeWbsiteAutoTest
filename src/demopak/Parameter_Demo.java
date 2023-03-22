package demopak;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Parameter_Demo {//clean code so this class for me to declare what i want to use in my test 
	public WebDriver  driver;
String url = "https://www.demoblaze.com";
public SoftAssert softassert = new SoftAssert();
//decalre expected title
String ExpectedTitle ="STORE";
@BeforeTest
public void beforeTest() {
//setup the browser you need
WebDriverManager.edgedriver().setup();
//call it 
 driver = new EdgeDriver();
//maximize the window
driver.manage().window().maximize();
//get the link of web browser
driver.get(url);

}
//@Test()
//public void testing() {
//	
//}
}
