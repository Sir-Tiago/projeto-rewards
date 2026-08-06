package br.com.tiago.projetoRewards.microrewards.edge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class EdgeConfig {

    public void configAutoSerchEdge(){

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");

        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        options.addArguments(
                        "user-agent=Mozilla/5.0 " +
                        "(Windows NT 10.0; Win64; x64)" +
                        " AppleWebKit/537.36" +
                        " (KHTML, like Gecko) " +
                        "Chrome/120.0.0.0 Safari/537.36 Edg/120.0.0.0"
        );


        WebDriver navegador = new EdgeDriver(options);
        WebDriverManager.edgedriver().setup();

        navegador.get("https://www.bing.com/?cc=br");

        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
        WebElement botao = wait.until(ExpectedConditions.elementToBeClickable(By.id("bnp_btn_accept")));

        System.out.println("Achei o botão");
        botao.click();

    }





}
