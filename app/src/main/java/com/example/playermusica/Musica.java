package com.example.playermusica;

//classe que representa a música que iremos mostrar na tela
public class Musica {

    private String nome;
    private String artista;
    private String nomeArquivo;

    public Musica(String nome, String artista, String nomeArquivo) {
        this.nome = nome;
        this.artista = artista;
        this.nomeArquivo = nomeArquivo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
}
