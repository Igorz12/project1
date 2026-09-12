package com.learning.project1.entity;

public class Usuario {

    private Long id;
    private String nome;
    private int idade;

    public Usuario(Long id,String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Long getId() {
        return id;
    }
}
