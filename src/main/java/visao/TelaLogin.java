package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import servico.*;
import modelo.*;

public class TelaLogin extends JFrame implements ActionListener {

private JTextField txtCpf;
private JButton btnEntrar;
private JButton btnGerarCpf;

public TelaLogin() {
    super("Tela de Login");

    // Cria os componentes da tela
    JLabel lblCpf = new JLabel("CPF:");
    txtCpf = new JTextField(11);
    btnEntrar = new JButton("Entrar");
    btnEntrar.addActionListener(this);
    btnGerarCpf = new JButton("Gerar CPF");
    btnGerarCpf.addActionListener(this);

    // Adiciona os componentes ao painel principal
    JPanel pnlMain = new JPanel();
    pnlMain.setLayout(new GridLayout(2, 3));
    pnlMain.add(lblCpf);
    pnlMain.add(txtCpf);
    pnlMain.add(btnEntrar);
    pnlMain.add(btnGerarCpf);

    // Adiciona o painel principal ao frame
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(pnlMain, BorderLayout.CENTER);

    // Configura o tamanho do frame
    setSize(400, 100);
}

public void actionPerformed(ActionEvent evt) {
    if (evt.getSource() == btnEntrar) {
        // Verifica se o CPF é válido
        String cpf = txtCpf.getText().replaceAll("[^0-9]", "");
        if (Validacao.cpf(cpf)) {
            // Abre a urna eletrônica
            TelaUrna urna = new TelaUrna(cpf);
            urna.setVisible(true);

            // Fecha a tela de login
            dispose();
        } 
        
        else {
            // Mostra mensagem de erro
            JOptionPane.showMessageDialog(this, "CPF inválido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } 
    
    else if (evt.getSource() == btnGerarCpf) {
        // Gera um CPF válido
        String cpf = Gerador.cpf();
        txtCpf.setText(cpf);
    }
}

    public static void main(String[] args) {
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
    }
}

