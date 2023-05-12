package modelo;

public class Candidatos {
    private String nome;
    private String numero;
    private int quantVoto = 0;

    public Candidatos(String nome, String numero){
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getQuantVoto() {
        return quantVoto;
    }

    public void adicionarVoto() {
        quantVoto++;
    }
}
