package modelo;

public class Eleitores {
    private String cpf;
    private String voto;

    public Eleitores(){

    }
    
    public Eleitores(String cpf, String voto){
        this.cpf = cpf;
        this.voto = voto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }
}
