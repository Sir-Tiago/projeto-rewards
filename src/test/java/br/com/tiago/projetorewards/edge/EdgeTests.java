package br.com.tiago.projetorewards.edge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

@DisplayName("Teste Automatizados do Navegador Microsoft Edge")
public class EdgeTests {

    @Test
    @DisplayName("Verificar se o Navegador está instalado")
    public void VerificarSeNavegadorEstaInstalado(){

        WebDriverManager.edgedriver().setup();
        WebDriver navegador = new EdgeDriver();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        navegador.get("https://www.google.com/");

        try{
            navegador.findElements(By.className("gb_1"));
            System.out.println("achei");
        }catch (NoSuchElementException e){
            System.out.println("não achei");
        }
        navegador.quit();



        //navegador.findElement(By.id("bnp_btn_accept")).click();



    }
}
