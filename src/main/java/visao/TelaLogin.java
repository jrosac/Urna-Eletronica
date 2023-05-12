package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import servico.Validacao;

public class TelaLogin extends JFrame implements ActionListener {

    private JTextField txtCpf;
    private JButton btnEntrar;

    public TelaLogin() {
        super("Tela de Login");

        // Cria os componentes da tela
        JLabel lblCpf = new JLabel("CPF:");
        txtCpf = new JTextField(11);
        btnEntrar = new JButton("Entrar");
        btnEntrar.addActionListener(this);

        // Adiciona os componentes ao painel principal
        JPanel pnlMain = new JPanel();
        pnlMain.setLayout(new GridLayout(2, 2));
        pnlMain.add(lblCpf);
        pnlMain.add(txtCpf);
        pnlMain.add(new JLabel(""));
        pnlMain.add(btnEntrar);

        // Adiciona o painel principal ao frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pnlMain, BorderLayout.CENTER);

        // Configura o tamanho do frame
        setSize(300, 100);
    }

    public void actionPerformed(ActionEvent evt) {
        // Verifica se o CPF é válido
        String cpf = txtCpf.getText();
        if (Validacao.cpf(cpf)) {
            // Abre a urna eletrônica
            TelaUrna urna = new TelaUrna("src/main/resources/candidatos.txt");
            urna.setVisible(true);

            // Fecha a tela de login
            dispose();
        } else {
            // Mostra mensagem de erro
            JOptionPane.showMessageDialog(this, "CPF inválido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
    }
}


