package modelo;

import javax.swing.ImageIcon;

public class Candidatos {
    private String nome;
    private String ano;
    private ImageIcon poster;
    private int quantVoto = 0;

    public Candidatos(String nome, String ano, ImageIcon poster){
        this.nome = nome;
        this.ano = ano;
        this.poster = poster;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public ImageIcon getPoster() {
        return poster;
    }

    public void setPoster(ImageIcon poster) {
        this.poster = poster;
    }

    public int getQuantVoto() {
        return quantVoto;
    }

    public void adicionarVoto() {
        quantVoto++;
    }
}
