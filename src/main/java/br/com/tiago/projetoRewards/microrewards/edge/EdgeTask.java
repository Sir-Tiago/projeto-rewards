package br.com.tiago.projetoRewards.microrewards.edge;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class EdgeTask {

    public static void main(String[] args) {

        EdgeConfig edgeConfig = new EdgeConfig();

        edgeConfig.configAutoSerchEdge();

        /*LocalTime agora = LocalTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

        for (int i = 1; i <= 5; i++) {

            long tempo = ThreadLocalRandom.current().nextLong(149, 352);

            System.out.println("Execução " + i + " - Esperando por " + tempo + "ms...");

            try {
                // Faz o script pausar pelo tempo sorteado
                Thread.sleep(tempo);
            } catch (InterruptedException e) {
                System.out.println("Ocorreu um erro na pausa do script.");
            }
            System.out.println("-----------------------------------");
        }
         */
    }

}
