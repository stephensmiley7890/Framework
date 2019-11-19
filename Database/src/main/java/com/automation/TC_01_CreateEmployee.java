package com.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_01_CreateEmployee {
	
	
	@Test

	public void CreateEmployee() throws Exception {
		
		WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver.get("https://opensource-demo.orangehrmlive.com/");
				driver.findElement(By.id("txtUsername")).sendKeys("Admin");
				driver.findElement(By.id("txtPassword")).sendKeys("admin123");
				driver.findElement(By.id("btnLogin")).click();
				driver.findElement(By.id("menu_pim_viewPimModule")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("menu_pim_addEmployee")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("firstName")).sendKeys("Stephen");
				driver.findElement(By.id("lastName")).sendKeys("Smiley");
				driver.findElement(By.id("btnSave")).click();
				driver.findElement(By.linkText("Welcome Admin")).click();
				driver.findElement(By.linkText("Logout")).click();
				Thread.sleep(5000);
				driver.quit();
				
	}
}
