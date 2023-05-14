package controle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;

import modelo.*;

public class Leitura {
    
    public static Candidatos[] candidatos(String nomeArquivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            int numCandidatos = 0;
            while ((linha = br.readLine()) != null) {
                numCandidatos++;
            }
            br.close();
    
            Candidatos[] candidatos = new Candidatos[numCandidatos];
            br = new BufferedReader(new FileReader(nomeArquivo));
            for (int i = 0; i < numCandidatos; i++) {
                String[] dadosCandidato = br.readLine().split(", ");
                String caminhoImagem = dadosCandidato[2];
                ImageIcon imagem = new ImageIcon(caminhoImagem);
                candidatos[i] = new Candidatos(dadosCandidato[0], dadosCandidato[1], imagem);
            }
            br.close();
    
            return candidatos;
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + nomeArquivo + ": " + e.getMessage());
            return null;
        }
    }

    public static Candidatos getCandidato(String voto) {
        Candidatos[] candidatos = Leitura.candidatos("src/main/resources/candidatos.txt");
        
        for (Candidatos candidato : candidatos) {
            if (candidato.getAno().equals(voto)) {
                return candidato;
            }
        }
        return null;
    }

    public static Eleitores[] eleitor(String nomeArquivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            int numEleitores = 0;
            while ((linha = br.readLine()) != null) {
                numEleitores++;
            }
            br.close();
    
            Eleitores[] eleitores = new Eleitores[numEleitores];
            br = new BufferedReader(new FileReader(nomeArquivo));
            for (int i = 0; i < numEleitores; i++) {
                String[] dadosEleitores = br.readLine().split(", ");
                eleitores[i] = new Eleitores(dadosEleitores[0], dadosEleitores[1]);
            }
            br.close();
    
            return eleitores;
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + nomeArquivo + ": " + e.getMessage());
            return null;
        }
    }

}
