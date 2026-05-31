package com.example.corporatemanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClienteRequestDTO {
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, message = "O nome deve conter o mínimo de 3 caracteres")
    @Size(max = 50, message = "O nome deve conter o máximo de 50 caracteres")
    private String nome;

    @NotBlank(message = "O cpf é obrigatório")
    @Size(min = 11, message = "O nome deve conter o mínimo de 11 caracteres")
    @Size(max = 14, message = "O nome deve conter o máximo de 14 caracteres")
    private String cpf;

    @NotBlank(message = "A sua data de nascimento é obrigatória")
    private String dataNascimento;

    @NotBlank(message = "Seu email é obrigatório")
    @Email(message = "O email inserido deve ser válido")
    private String email;

    @NotBlank(message = "A sua senha é obrigatória")
    @Size(min = 4, message = "Sua senha deve conter o mínimo de 4 digitos")
    @Size(max = 10, message = "Sua senha deve conter o máximo de 10 dígitos")
    private String senha;

    public ClienteRequestDTO() {
    }

    public ClienteRequestDTO(String nome, String cpf, String dataNascimento, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
    }

    public @NotBlank(message = "O nome é obrigatório") @Size(min = 3, message = "O nome deve conter o mínimo de 3 caracteres") @Size(max = 50, message = "O nome deve conter o máximo de 50 caracteres") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório") @Size(min = 3, message = "O nome deve conter o mínimo de 3 caracteres") @Size(max = 50, message = "O nome deve conter o máximo de 50 caracteres") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O cpf é obrigatório") @Size(min = 11, message = "O nome deve conter o mínimo de 11 caracteres") @Size(max = 14, message = "O nome deve conter o máximo de 14 caracteres") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank(message = "O cpf é obrigatório") @Size(min = 11, message = "O nome deve conter o mínimo de 11 caracteres") @Size(max = 14, message = "O nome deve conter o máximo de 14 caracteres") String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank(message = "A sua data de nascimento é obrigatória") String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@NotBlank(message = "A sua data de nascimento é obrigatória") String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotBlank(message = "Seu email é obrigatório") @Email(message = "O email inserido deve ser válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Seu email é obrigatório") @Email(message = "O email inserido deve ser válido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "A sua senha é obrigatória") @Size(min = 4, message = "Sua senha deve conter o mínimo de 4 digitos") @Size(max = 10, message = "Sua senha deve conter o máximo de 10 dígitos") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "A sua senha é obrigatória") @Size(min = 4, message = "Sua senha deve conter o mínimo de 4 digitos") @Size(max = 10, message = "Sua senha deve conter o máximo de 10 dígitos") String senha) {
        this.senha = senha;
    }
}

