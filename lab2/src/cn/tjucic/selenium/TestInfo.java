package cn.tjucic.selenium;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestInfo {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  String driverPath = System.getProperty("user.dir") + "/src/resources/driver/geckodriver.exe";
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  driver = new FirefoxDriver();
	  baseUrl = "http://121.193.130.195:8800";
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void testBaidu() throws Exception {
	  InputStream is = new FileInputStream("C:/Users/pc/Desktop/»Ìº˛≤‚ ‘√˚µ•.xlsx");
      Workbook wb = new XSSFWorkbook(is);
      Sheet sheet = wb.getSheetAt(0);
      String login=null;
      String password=null;
      
      int rownum = sheet.getPhysicalNumberOfRows();       
      Row row = sheet.getRow(0);

      driver.get(baseUrl + "/");
      for (int i = 2; i<rownum; i++) {
           row = sheet.getRow(i);
           double a=row.getCell(1).getNumericCellValue();
           long b=(long)a;
           login=String.valueOf(b);//µ«¬º’À∫≈
           System.out.println(login);
           
           password=login.substring(4);//µ«¬º√‹¬Î
           System.out.println(password);
           
           String expectname=row.getCell(2).toString();
           String expectgit=row.getCell(3).toString();
           
           System.out.println(expectname);
           System.out.println(expectgit);
           
           
           driver.findElement(By.name("id")).clear();
           driver.findElement(By.name("id")).sendKeys(login);
           
           driver.findElement(By.name("password")).clear();
           driver.findElement(By.name("password")).sendKeys(password);

           driver.findElement(By.id("btn_login")).sendKeys(Keys.ENTER);
           
      
           assertEquals(login,driver.findElement(By.id("student-id")).getText());
           assertEquals(expectname,driver.findElement(By.id("student-name")).getText());
           assertEquals(expectgit, driver.findElement(By.id("student-git")).getText());
           
           driver.findElement(By.id("btn_logout")).sendKeys(Keys.ENTER);
           driver.findElement(By.id("btn_return")).sendKeys(Keys.ENTER);
      }
//    driver.findElement(By.id("kw")).clear();
//    driver.findElement(By.id("kw")).sendKeys("ÃÏΩÚ¥Û—ß");
//    driver.findElement(By.id("su")).click();

  }

  @After
  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

