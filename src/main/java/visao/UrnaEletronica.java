package visao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class UrnaEletronica extends JFrame implements ActionListener {

    private JButton[] botoesCandidato;
    private JLabel[] lblVotosCandidato;
    private int[] votosCandidato;
    private int numCandidatos;

    public UrnaEletronica(String nomeArquivo) {
        super("Urna Eletrônica");

        // Lê o nome dos candidatos no txt
        try {
            BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            numCandidatos = 0;
            while ((linha = br.readLine()) != null) {
                numCandidatos++;
            }
            br.close();
            br = new BufferedReader(new FileReader(nomeArquivo));
            String[] nomesCandidato = new String[numCandidatos];
            for (int i = 0; i < numCandidatos; i++) {
                nomesCandidato[i] = br.readLine();
            }
            br.close();

            //Botões de votação
            botoesCandidato = new JButton[numCandidatos];
            for (int i = 0; i < numCandidatos; i++) {
                botoesCandidato[i] = new JButton(nomesCandidato[i]);
                botoesCandidato[i].addActionListener(this);
            }

            // Adiciona os botões de votação ao painel principal
            JPanel pnlVotacao = new JPanel();
            pnlVotacao.setLayout(new GridLayout(numCandidatos, 1));
            for (int i = 0; i < numCandidatos; i++) {
                pnlVotacao.add(botoesCandidato[i]);
            }

            // Adiciona os painéis ao frame
            getContentPane().setLayout(new BorderLayout());
            getContentPane().add(pnlVotacao, BorderLayout.CENTER);

            // Configura o tamanho do frame
            setSize(400, 200);

        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo " + nomeArquivo + ": " + e.getMessage());
            System.exit(1);
        }
    }

    public void actionPerformed(ActionEvent evt) {
        // Verifica qual botão foi clicado
        Object source = evt.getSource();

        // Incrementa o contador de votos do candidato correspondente
        for (int i = 0; i < numCandidatos; i++) {
            if (source == botoesCandidato[i]) {
                votosCandidato[i]++;
                lblVotosCandidato[i].setText(botoesCandidato[i].getText() + ": " + votosCandidato[i]);
                break;
            }
        }
    }

    public static void main(String[] args) {
        UrnaEletronica urna = new UrnaEletronica("src/main/resources/candidatos.txt");
        urna.setVisible(true);
    }
}
