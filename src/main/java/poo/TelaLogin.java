package poo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        if (validarCpf(cpf)) {
            // Abre a urna eletrônica
            UrnaEletronica urna = new UrnaEletronica("src/main/resources/candidatos.txt");
            urna.setVisible(true);

            // Fecha a tela de login
            dispose();
        } else {
            // Mostra mensagem de erro
            JOptionPane.showMessageDialog(this, "CPF inválido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validarCpf(String cpf) {
        // remove caracteres não-numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // CPF deve ter 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int resto = 11 - (soma % 11);
        int digito1 = (resto >= 10) ? 0 : resto;

        // Calcula o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        resto = 11 - (soma % 11);
        int digito2 = (resto >= 10) ? 0 : resto;

        // Verifica se os dígitos calculados são iguais aos dígitos informados
        return (Character.getNumericValue(cpf.charAt(9)) == digito1 && Character.getNumericValue(cpf.charAt(10)) == digito2);
    }

    public static void main(String[] args) {
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
    }
}


