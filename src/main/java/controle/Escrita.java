package controle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import modelo.*;

public class Escrita {
    
    public static void escreverVoto(Eleitores eleitor) {
        try {
            // Cria um objeto File que representa o arquivo de destino
            File arquivo = new File("src/main/resources/votos.txt");
            
            // Cria um objeto FileWriter para escrever no arquivo de destino
            FileWriter escritor = new FileWriter(arquivo, true);
            
            // Escreve no arquivo o CPF e o ano do voto
            escritor.write(eleitor.getCpf() + ", " + eleitor.getVoto() + "\n");
            
            // Fecha o objeto FileWriter
            escritor.close();
            
        } catch (IOException e) {
            // Trata a exceção caso ocorra um erro ao escrever no arquivo
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
