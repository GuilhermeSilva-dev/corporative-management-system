package com.example.AtividadePontuada02.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FornecedorRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, message = "O nome deve conter o mínimo de 3 caracteres")
    @Size(max = 40, message = "O nome deve conter o máximo de 40 caracteres")
    private String nome;


    @NotBlank(message = "O cnpj é obrigatório")
    @Size(min = 14, message = "O cnpj deve conter o mínimo de 11 dígitos")
    @Size(max = 18, message = "O cnpj deve conter o máximo de 14 dígitos")
    private String cnpj;


    @NotBlank(message = "Seu email é obrigatório")
    @Email(message = "O email inserido deve ser válido")
    private String email;


    @NotBlank(message = "Seu telefone deve ser válido")
    @Size(min = 9, max = 11, message = "O telefone deve conter mínimo de 9 dígitos e máximo de 11 dígitos")
    private String telefone;

    public FornecedorRequestDTO() {
    }

    public FornecedorRequestDTO(String nome, String cnpj, String email, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
    }

    public @NotBlank(message = "O nome é obrigatório") @Size(min = 3, message = "O nome deve conter o mínimo de 3 caracteres") @Size(max = 40, message = "O nome deve conter o máximo de 40 caracteres") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório") @Size(min = 3, message = "O nome deve conter o mínimo de 3 caracteres") @Size(max = 40, message = "O nome deve conter o máximo de 40 caracteres") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O cnpj é obrigatório") @Size(min = 14, message = "O nome deve conter o mínimo de 11 caracteres") @Size(max = 18, message = "O nome deve conter o máximo de 14 caracteres") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotBlank(message = "O cnpj é obrigatório") @Size(min = 14, message = "O nome deve conter o mínimo de 11 caracteres") @Size(max = 18, message = "O nome deve conter o máximo de 14 caracteres") String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotBlank(message = "Seu email é obrigatório") @Email(message = "O email inserido deve ser válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Seu email é obrigatório") @Email(message = "O email inserido deve ser válido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Seu telefone deve ser válido") @Size(min = 9, max = 11, message = "O telefone deve conter mínimo de 9 dígitos e máximo de 11 dígitos") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "Seu telefone deve ser válido") @Size(min = 9, max = 11, message = "O telefone deve conter mínimo de 9 dígitos e máximo de 11 dígitos") String telefone) {
        this.telefone = telefone;
    }
}
