package servico;

import controle.*;
import modelo.*;

public class Validacao {

    public static boolean cpf(String cpf) {

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

    public static boolean cpfRepetido(String cpf){
        Eleitores[] eleitores = Leitura.eleitor("src/main/resources/votos.txt");

        for (Eleitores eleitor : eleitores) {
            if (eleitor.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
}
