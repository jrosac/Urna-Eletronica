import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UrnaEletronica extends JFrame implements ActionListener {

    private int votosCandidato1;
    private int votosCandidato2;
    private int votosCandidato3;

    private JButton candidato1Btn;
    private JButton candidato2Btn;
    private JButton candidato3Btn;

    public UrnaEletronica() {
        votosCandidato1 = 0;
        votosCandidato2 = 0;
        votosCandidato3 = 0;

        candidato1Btn = new JButton("Candidato 1");
        candidato2Btn = new JButton("Candidato 2");
        candidato3Btn = new JButton("Candidato 3");

        candidato1Btn.addActionListener(this);
        candidato2Btn.addActionListener(this);
        candidato3Btn.addActionListener(this);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(3, 1));
        painelBotoes.add(candidato1Btn);
        painelBotoes.add(candidato2Btn);
        painelBotoes.add(candidato3Btn);

        this.add(painelBotoes);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == candidato1Btn) {
            votosCandidato1++;
            System.out.println("Voto para Candidato 1!");
        } else if (e.getSource() == candidato2Btn) {
            votosCandidato2++;
            System.out.println("Voto para Candidato 2!");
        } else if (e.getSource() == candidato3Btn) {
            votosCandidato3++;
            System.out.println("Voto para Candidato 3!");
        }
    }

    public static void main(String[] args) {
        UrnaEletronica urna = new UrnaEletronica();
    }
}
