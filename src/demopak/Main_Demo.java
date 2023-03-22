package demopak;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Main_Demo extends Parameter_Demo{

@Test()
public void call_Title() {
String ActualTitle =	driver.getTitle();
softassert.assertEquals(ActualTitle, ExpectedTitle);
//softassert i need it call all so if sth failed it will countine 
softassert.assertAll();
	}

@Test ()
public void check_img_drawer() {
//to find elements (img Silders ) defo will decalre list and find the common thing between them.
List<WebElement> imgsSliders = driver.findElements(By.className("img-fluid"));
//to call them by its attribute
// to be sure that these pics aint the same you can call it by its attribute and compare it with other pics
 boolean checkImg1 =imgsSliders.get(0).getAttribute("src") == imgsSliders.get(1).getAttribute("src");
 boolean checkImg2 =imgsSliders.get(1).getAttribute("src") == imgsSliders.get(2).getAttribute("src");
 boolean checkImg3 =imgsSliders.get(2).getAttribute("src") == imgsSliders.get(0).getAttribute("src");
 //dont forget the boolean mesg to know the error .
 softassert.assertEquals(checkImg1,false,"imge zero with one");
 softassert.assertEquals(checkImg2,false ,"imge one with two");
 softassert.assertEquals(checkImg3,false,"imge two with zero");
 softassert.assertAll();
}
@Test(invocationCount=3 )//now you can make the test occur the as many times you need with invocationcount
public void Validation() throws InterruptedException, IOException {
//use implicate wait of the beginning of method so it can make awit for everything need some time 
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

//to enter random emails you have to decalre an array have some random emails
String[] Emails= {"khitam@gmail.com","palestine@hotmail.com","ok.com","noor.com"};

//now declare the random package 
Random randomEmails = new Random();

//now declare an variable from integer datatype means accept random numbers starts from zero etc .
int index = randomEmails.nextInt(4);
driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a")).click();

// now send this index 
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id=\"recipient-email\"]")).sendKeys(Emails[index]);
Thread.sleep(3000);

//clear the form from text
driver.findElement(By.xpath("//*[@id=\"recipient-email\"]")).clear();

//now close it so after closing will repeat the operation and enter the next index
driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[1]/button/span")).click();

//lets try to get an attribute
//String getValue =driver.findElement(By.xpath("//*[@id=\\\"recipient-email\\\"]")).getAttribute("value");
//System.out.println(getValue);


//to validate true emails 
String regex = "^(.+)@(.+)$";

//put it into pattern.
Pattern pat = Pattern.compile(regex);

//match it 
Matcher match = pat.matcher(Emails[index]);
System.out.println(Emails[index]+"yes valid email *-*"+ match.matches());

//and to see if the test fail or pass do assertion
//boolean checkProcess = match.matches();
//softassert.assertEquals(checkProcess,false ,"the email is not matching the correct one");
//softassert.assertAll();

//and for sure you can use ready function to make random emails 
String emailFun = RandomStringUtils.randomAlphanumeric(10)+"gmail.com";
System.out.println(emailFun);

//Screenshot
Date currentTime = new Date();
String myUpdatedate = currentTime.toString();
String NewDate = myUpdatedate.replace(":", "-");
TakesScreenshot ts = (TakesScreenshot) driver;
File file = ts.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(file, new File("./ScreenShot_Folder/" + NewDate + ".jpg"));

}
}




