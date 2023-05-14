package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import controle.*;
import modelo.*;

public class TelaUrna extends JFrame implements ActionListener {

    private String voto = "";
    private JLabel labelDisplay;
    private JButton[] botoesNumeros;
    private JButton botaoBranco;
    private JButton botaoCorrige;
    private JButton botaoConfirma;
    
    public TelaUrna() {
        super("Urna Eletronica");
    
        // Recebe os dados candidatos atraves do arquivo txt
        Leitura.candidatos("src/main/resources/candidatos.txt");

        exibirTeclado();
        }

    private void exibirTeclado(){
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
        painelUrna.add(labelDisplay, BorderLayout.EAST);    
    }

    private void exibirInfo() {
    
        Candidatos candidato = Leitura.getCandidato(voto);

        if (candidato != null) {
            // Exibe as informações do candidato no display
            String info = "<html><div style='text-align:center;'>";
            info += candidato.getNome() + "<br>";
            info += "Ano: " + candidato.getAno() + "<br>";
            info += "<img src='" + candidato.getPoster().toString() + "'><br>";
            info += "</div></html>";
            labelDisplay.setText(info);
        } else {
            // Exibe informação de voto nulo no display
            labelDisplay.setText("<html><div style='text-align:center;'>VOTO NULO</div></html>");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
    
        if (source == botaoBranco) {
            voto = "BRANCO";
        } 

        else if (source == botaoCorrige) {
            voto = "";
            labelDisplay.setText(voto);
        } 
        
        else if (source == botaoConfirma) {
            
        }
        
        else {
            // Um dos botões numéricos foi pressionado
            JButton button = (JButton) source;
            if (voto.length() < 4) {
                voto += button.getText();
                labelDisplay.setText(voto);
            }

            if(voto.length() == 4)
                exibirInfo();
        }
    }
    
    public static void main(String[] args) {
        TelaUrna urna = new TelaUrna();
        urna.setVisible(true);
    }
 }
