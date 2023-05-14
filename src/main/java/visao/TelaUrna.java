package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TelaUrna extends JFrame implements ActionListener {

    private String[] nomesCandidato;
    private int[] numerosCandidato;
    private int numCandidatos;
    private String voto;
    private JLabel labelDisplay;
    private JButton[] botoesNumeros;
    private JButton botaoBranco;
    private JButton botaoCorrige;
    private JButton botaoConfirma;
    
    public TelaUrna(String nomeArquivo) {
        super("Urna Eletronica");
    
        // Lê o nome e o número dos candidatos no arquivo
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

            // Cria o teclado da urna
            JPanel teclado = new JPanel(null);
            teclado.setPreferredSize(new Dimension(270, 400));
            botoesNumeros = new JButton[10];
            int x = 10;
            int y = 10;
            for (int i = 1; i <= 9; i++) {
                botoesNumeros[i] = new JButton(Integer.toString(i));
                botoesNumeros[i].setBounds(x, y, 80, 80);
                botoesNumeros[i].addActionListener(this);
                teclado.add(botoesNumeros[i]);
                x += 90;
                if (i % 3 == 0) {
                    x = 10;
                    y += 90;
                }
            }

            // Botão 0
            botoesNumeros[0] = new JButton("0");
            botoesNumeros[0].setBounds(100, 280, 80, 80);
            botoesNumeros[0].addActionListener(this);
            teclado.add(botoesNumeros[0]);

            // Botão Branco
            botaoBranco = new JButton("BRANCO");
            botaoBranco.setBounds(10, 370, 100, 60);
            botaoBranco.addActionListener(this);
            teclado.add(botaoBranco);

            // Botão Corrige
            botaoCorrige = new JButton("CORRIGE");
            botaoCorrige.setBounds(100, 370, 100, 60);
            botaoCorrige.addActionListener(this);
            teclado.add(botaoCorrige);

            // Botão Confirma
            botaoConfirma = new JButton("CONFIRMA");
            botaoConfirma.setBounds(190, 370, 100, 60);
            botaoConfirma.addActionListener(this);
            teclado.add(botaoConfirma);

            add(teclado, BorderLayout.CENTER);
            setSize(800, 600);

            // Cria o painel que irá conter o teclado e o display
JPanel painelUrna = new JPanel(new BorderLayout());
add(painelUrna, BorderLayout.CENTER);

// Adiciona o teclado ao painel da urna
painelUrna.add(teclado, BorderLayout.CENTER);

// Cria o display e o adiciona ao painel da urna
labelDisplay = new JLabel();
labelDisplay.setBackground(Color.WHITE);
labelDisplay.setOpaque(true);
labelDisplay.setHorizontalAlignment(JLabel.CENTER);
labelDisplay.setFont(new Font("Arial", Font.BOLD, 48));
painelUrna.add(labelDisplay, BorderLayout.NORTH);



        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo " + nomeArquivo + ": " + e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
    
        if (source == botaoBranco) {
            voto = "BRANCO";
        } else if (source == botaoCorrige) {
            voto = "";
            labelDisplay.setText(voto);
        } else if (source == botaoConfirma) {
            // Confirma o voto
            // ...
        } else {
            // Um dos botões numéricos foi pressionado
            JButton button = (JButton) source;
            voto += button.getText();
            labelDisplay.setText(voto);
        }
    }
    
    public static void main(String[] args) {
        TelaUrna urna = new TelaUrna("src/main/resources/candidatos.txt");
        urna.setVisible(true);
    }
 }
