package lab2;

import java.io.File;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestStudentInfo {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		String driverPath = System.getProperty("user.dir") + "/src/lab2/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		baseUrl = "http://121.193.130.195:8800";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testBaidu() throws Exception {
		Workbook book = Workbook.getWorkbook(new File("C:\\Users\\Administrator\\Desktop\\study\\大三下\\软件测试\\第二次上机实验\\软件测试名单.xls"));
		Sheet sheet = book.getSheet(0);
		int rows = sheet.getRows();
		for (int i = 3; i < rows; i++) {
			String id = sheet.getCell(1, i).getContents();
			String name = sheet.getCell(2, i).getContents();
			String git = sheet.getCell(3, i).getContents();
			driver.get(baseUrl + "/login");
			driver.findElement(By.name("id")).click();
			driver.findElement(By.name("id")).clear();
			driver.findElement(By.name("id")).sendKeys(id);
			driver.findElement(By.name("password")).click();
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(id.substring(4, 10));
			driver.findElement(By.id("btn_login")).click();

			driver.get(baseUrl + "/detail");
			String testId = driver.findElement(By.id("student-id")).getText();
			String testName = driver.findElement(By.id("student-name")).getText();
			String testGit = driver.findElement(By.id("student-git")).getText();
			String[] expectedResult = { id, name, git };
			String[] testResult = { testId, testName, testGit };
			assertArrayEquals(expectedResult, testResult);
			driver.findElement(By.id("btn_logout")).click();
		}
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
		// String verificationErrorString = verificationErrors.toString();
		// if (!"".equals(verificationErrorString)) {
		// fail(verificationErrorString);
		// }
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
