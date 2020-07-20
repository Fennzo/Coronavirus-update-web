package com.covid.tracker;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class WebScrap {
	
	private WebDriver load() {
		try {
			Resource resource = new ClassPathResource("chromedriver.exe");
			String filePath = resource.getFile().getPath();
			System.setProperty("webdriver.chrome.driver", filePath);
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(true);
			WebDriver browser = new ChromeDriver(options);
			browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			return browser;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Data> getAllData() {
		ArrayList<Data> allData = new ArrayList<Data>();
		WebDriver browser = load();
		browser.get("https://www.worldometers.info/coronavirus/");
		List<WebElement> rows = browser
				.findElements(By.xpath("//table[@id='main_table_countries_today']//tr[@role='row']"));
		for (int i = 3; i < rows.size(); i++) {
			if (!(rows.get(i).getText().length() < 1)) {
				List<WebElement> subcol = rows.get(i).findElements(By.tagName("td"));

				Data curr = new Data();
				curr.setId(subcol.get(0).getText());
				curr.setCountry(subcol.get(1).getText());
				curr.setTotalCases(subcol.get(2).getText());
				curr.setNewCases(subcol.get(3).getText());
				curr.setTotalDeaths(subcol.get(4).getText());
				curr.setNewDeaths(subcol.get(5).getText());
				curr.setTotalRecovered(subcol.get(6).getText());
				curr.setActiveCases(subcol.get(7).getText());
				curr.setSeriousCases(subcol.get(8).getText());
				curr.setTotalCasesPerMillionPop(subcol.get(9).getText());
				curr.setTotalDeathsPerMillionPop(subcol.get(10).getText());
				curr.setTotalTests(subcol.get(11).getText());
				curr.setTestsPerMillion(subcol.get(12).getText());
				curr.setPop(subcol.get(13).getText());
				// System.out.println(curr);
				allData.add(curr);
			}
		}
		browser.close();
		browser.quit();
		return allData;
	
	}
	
	public String getWorldPop(){
		WebDriver browser = load();
		browser.get("https://www.worldometers.info/world-population/");
		String worldP = browser.findElement(By.className("maincounter-number")).getText();
		browser.close();
		browser.quit();
		return worldP;
	}
	
	public String getWorldCases() {
		WebDriver browser = load();
		browser.get("https://www.worldometers.info/coronavirus/");
		String worldC = browser
		.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[4]/div[1]/span[1]"))
		.getText();
		String worldP = this.getWorldPop();
		BigDecimal worldCases = new BigDecimal(worldC.replace(",", ""));
		System.out.println("worldCases " + worldCases);
		BigDecimal worldPop = new BigDecimal(worldP.replace(",", ""));
		System.out.println("worldpop" + worldPop);
		BigDecimal percentage = worldCases.divide(worldPop, 4, RoundingMode.CEILING);
		System.out.println("PERCEN" + percentage);
		String percen = "(" + percentage.toString() + "%" + ")" ;
		worldC = worldC + " " + percen;
		browser.close();
		browser.quit();
		return worldC;
	}
	
	public String getWorldDeaths() {
		WebDriver browser = load();
		browser.get("https://www.worldometers.info/coronavirus/");
		String worldD = browser.findElement(By.cssSelector(
		"div.container:nth-child(11) div.row:nth-child(2) div.col-md-8 div.content-inner div:nth-child(9) div.maincounter-number:nth-child(2) > span:nth-child(1)"))
		.getText();
		browser.close();
		browser.quit();
		return worldD;
	}

//	public ArrayList<String> getWorlValues() {
//		ArrayList<String> values = new ArrayList<String>();
//		try {
//			WebDriver browser = load();
//			browser.get(url);
//			WebDriver browser1 = load();
//			browser1.get("https://www.worldometers.info/world-population/");
//			// total world cases
//			String worldC = browser
//					.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[4]/div[1]/span[1]"))
//					.getText();
//
//			// total world deaths
//			String worldD = browser.findElement(By.cssSelector(
//					"div.container:nth-child(11) div.row:nth-child(2) div.col-md-8 div.content-inner div:nth-child(9) div.maincounter-number:nth-child(2) > span:nth-child(1)"))
//					.getText();
//			values.add(worldD);
//			// world pop
//			String worldP = browser1.findElement(By.className("maincounter-number")).getText();
//			values.add(worldP);
//			BigDecimal worldCases = new BigDecimal(worldC.replace(",", ""));
//			System.out.println("worldCases " + worldCases);
//			BigDecimal worldPop = new BigDecimal(worldP.replace(",", ""));
//			System.out.println("worldpop" + worldPop);
//			BigDecimal percentage = worldCases.divide(worldPop, 4, RoundingMode.CEILING);
//			System.out.println("PERCEN" + percentage);
//			String percen = "(" + percentage.toString() + "%" + ")" ;
//			worldC = worldC + " " + percen;
//			values.add(worldC);
//			System.out.println(values);
//			browser.close();
//			browser1.close();
//			browser.quit();
//			browser1.quit();
//
//		} catch (Exception e) {
//			System.out.println("getWorldCases error");
//			e.printStackTrace();
//		}
//
//		return values;
//	}

}
