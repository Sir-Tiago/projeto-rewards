package br.com.tiago.projetoRewards.microrewards.edge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;


public class EdgeConfig {

    ScheduledExecutorService agendador = Executors.newScheduledThreadPool(1);

    public void configAutoSerchEdge(){


        //script to avoid the bot
        //I don't know how this exactly works, I picked it up somewhere
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

        //have to use options as a parameter
        WebDriver navegador = new EdgeDriver(options);
        WebDriverManager.edgedriver().setup();

        navegador.get("https://www.bing.com/?cc=br");

        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
        WebElement botao = wait.until(ExpectedConditions.elementToBeClickable(By.id("bnp_btn_accept")));
        botao.click();

        InputStream input = getClass()
                .getClassLoader()
                .getResourceAsStream("RandomWords");

        //list with random strings for a search
        //you can find in directory resources
        List<String> search = new BufferedReader(new InputStreamReader(input)).lines().toList();

        //loop for the search
        for (String pesquisa : search) {

            //to all caractere one at a time
            for (int i = 0; i < pesquisa.length(); i++){
                char caractere = pesquisa.charAt(i);

                //for EVERY action, she must include a pause
                long timeKeyRandom = ThreadLocalRandom.current().nextLong(214, 352);

                try {
                    navegador.findElement(By.id("sb_form_q")).sendKeys(String.valueOf(caractere));
                    Thread.sleep(timeKeyRandom);
                    if(i == pesquisa.length() - i){
                        navegador.findElement(By.id("sb_form_q")).sendKeys(Keys.ENTER);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Ocorreu um erro na pausa do script.");
                }

            }

        }




            








    }





}
