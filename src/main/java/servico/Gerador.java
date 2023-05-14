package servico;

import java.util.Random;

public class Gerador {
  
  public static String cpf() {
   
    int digito1 = 0;
    int digito2 = 0; 
    int soma = 0;
    int peso = 10;
    Random random = new Random();

    // Gera um número aleatório de 9 dígitos
    int n = random.nextInt(900000000) + 100000000;
    String cpf = Integer.toString(n); 

    // Cálculo do primeiro dígito verificador
    for (int i = 0; i < 9; i++) {
      soma += Integer.parseInt(cpf.substring(i, i+1)) * peso--; 
    }

    int resto = soma % 11; // Calcula o resto da divisão por 11
    if (resto < 2) {
      digito1 = 0;
    } else {
      digito1 = 11 - resto; // Se o resto for maior ou igual a 2, subtrai-se do valor 11 para obter o primeiro dígito verificador
    }

    // Cálculo do segundo dígito verificador
    soma = 0; 
    peso = 11; 
    cpf += digito1; 
    for (int i = 0; i < 10; i++) {
      soma += Integer.parseInt(cpf.substring(i, i+1)) * peso--; // Realiza a soma dos dígitos multiplicados pelos pesos
    }

    resto = soma % 11; 
    if (resto < 2) {
      digito2 = 0;
    } else {
      digito2 = 11 - resto; 
    }
    // Adiciona o segundo dígito verificador ao CPF
    cpf += digito2; 
    return cpf;
  }
}