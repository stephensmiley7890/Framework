package com.automation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
				String username = null;
				String password = null;
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from users where username = 'Admin'");
				while (resultSet.next()){
					username = resultSet.getString(1);
					password = resultSet.getString(2);
					
				}
				connection.close();
				
				driver.findElement(By.id("txtUsername")).sendKeys(username);
				driver.findElement(By.id("txtPassword")).sendKeys(password);
				driver.findElement(By.id("btnLogin")).click();
				
		//		driver.findElement(By.id("menu_pim_viewPimModule")).click();
			//	Thread.sleep(2000);
			//	driver.findElement(By.id("menu_pim_addEmployee")).click();
			//	Thread.sleep(2000);
			//	driver.findElement(By.id("firstName")).sendKeys//
			//	driver.findElement(By.id("lastName")).sendKeys("");
			//	driver.findElement(By.id("btnSave")).click();
			//	driver.findElement(By.linkText("Welcome ")).click();
			//	driver.findElement(By.linkText("Logout")).click();
				Thread.sleep(2000);
				driver.quit();
				
	}
}
