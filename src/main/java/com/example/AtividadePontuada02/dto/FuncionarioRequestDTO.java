package com.example.AtividadePontuada02.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class FuncionarioRequestDTO {
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, message = "O nome deve conter o mínimo de 3 caracteres")
    @Size(max = 50, message = "O nome deve conter o máximo de 50 caracteres")
    private String nome;

    @NotBlank(message = "O cpf é obrigatório")
    @Size(min = 11, message = "O nome deve conter o mínimo de 11 caracteres")
    @Size(max = 14, message = "O nome deve conter o máximo de 14 caracteres")
    private String cpf;

    @NotBlank(message = "Seu email é obrigatório")
    @Email(message = "O email inserido deve ser válido")
    private String email;

    @NotBlank(message = "Seu telefone deve ser válido")
    @Size(min = 9, max = 11, message = "O telefone deve conter mínimo de 9 dígitos e máximo de 11 dígitos")
    private String telefone;

    @NotBlank(message = "Informe um setor válido")
    private String setor;

    @NotNull(message = " O valor do seu salário deve ser informado")
    private double salario;

    public FuncionarioRequestDTO() {
    }

    public FuncionarioRequestDTO(String nome, String cpf, String email, String telefone, String setor, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.setor = setor;
        this.salario = salario;
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

    public @NotBlank(message = "Seu email é obrigatório") @Email(message = "O email inserido deve ser válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Seu email é obrigatório") @Email(message = "O email inserido deve ser válido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Seu telefone deve ser válido") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "Seu telefone deve ser válido") String telefone) {
        this.telefone = telefone;
    }

    public @NotBlank(message = "Informe um setor válido") String getSetor() {
        return setor;
    }

    public void setSetor(@NotBlank(message = "Informe um setor válido") String setor) {
        this.setor = setor;
    }

    @NotNull(message = " O valor do seu salário deve ser informado")
    public double getSalario() {
        return salario;
    }

    public void setSalario(@NotNull(message = " O valor do seu salário deve ser informado") double salario) {
        this.salario = salario;
    }
}
