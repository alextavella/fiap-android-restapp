package com.alextavella.fiap_android_restapp.model;

/**
 * Created by alextavella on 21/06/17.
 */

public class Android {

    private String versao;
    private String nome;
    private String api;
    private String urlImagem;

    public Android(String versao, String nome, String api, String urlImagem) {
        this.versao = versao;
        this.nome = nome;
        this.api = api;
        this.urlImagem = urlImagem;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
