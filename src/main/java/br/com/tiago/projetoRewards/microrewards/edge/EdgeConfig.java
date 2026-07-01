package br.com.tiago.projetoRewards.microrewards.edge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

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
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        navegador.get("https://www.google.com/");
        //navegador.findElement(By.className("gb_1")).click();


    }





}
