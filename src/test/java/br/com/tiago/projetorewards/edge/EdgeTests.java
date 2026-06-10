package br.com.tiago.projetorewards.edge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

@DisplayName("Teste Automatizados do Navegador Microsoft Edge")
public class EdgeTests {

    @Test
    @DisplayName("Verificar se o Navegador está instalado")
    public void VerificarSeNavegadorEstaInstalado(){

        WebDriverManager.edgedriver().setup();
        WebDriver navegador = new EdgeDriver();

        navegador.get("https://www.bing.com/search?qs=AS&pq=google&sk=CSYN1UAS9AS10&sc=23-6&pglt=43&q=google&cvid=109a5bfdb29947da86b646804ac415e1&gs_lcrp=EgRlZGdlKgYIABAAGEAyBggAEAAYQDIGCAEQLhhAMgYIAhAuGEAyBggDEAUYQDIGCAQQBRhAMgYIBRAFGEAyBggGEAUYQDIGCAcQBRhAMgYICBAFGEDSAQgxODg4ajBqN6gCALACAA&FORM=ANNTA1&PC=U531");

        navegador.findElement(By.id("sb_form_q")).click();

        navegador.findElement(By.id("sw_clx")).click();

        //navegador.findElement(By.id("bnp_btn_accept")).click();



    }
}
