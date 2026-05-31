package com.example.AtividadePontuada02.dto;

public class ClienteResponseDTO {
    private String nome;
    private String dataNascimento; // CORRIGIDO: 'data' com d minúsculo
    private String email;

    public ClienteResponseDTO() {
    }

    // CORRIGIDO: Agora o parâmetro e a atribuição usam os nomes idênticos
    public ClienteResponseDTO(String nome, String dataNascimento, String email) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}