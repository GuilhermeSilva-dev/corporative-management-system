package com.example.AtividadePontuada02.controller;

import com.example.AtividadePontuada02.dto.FuncionarioRequestDTO;
import com.example.AtividadePontuada02.dto.FuncionarioResponseDTO;
import com.example.AtividadePontuada02.model.FuncionarioModel;
import com.example.AtividadePontuada02.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    // GET - Listar todos os funcionários
    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDTO>> listarTodos() {
        List<FuncionarioResponseDTO> funcionarios = service.listarFuncionarios();
        return ResponseEntity.ok(funcionarios);
    }

    // GET - Buscar um funcionário por ID
    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDTO> buscarPorId(@PathVariable Long id) {
        FuncionarioResponseDTO funcionario = service.buscarPorId(id);
        return ResponseEntity.ok(funcionario);
    }

    // POST - Criar um novo funcionário
    @PostMapping
    public ResponseEntity<FuncionarioModel> criarFuncionario(@RequestBody @Valid FuncionarioRequestDTO dto) {
        FuncionarioModel novoFuncionario = service.salvarFuncionario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
    }

    // PUT - Atualizar um funcionário existente
    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDTO> atualizarFuncionario(
            @PathVariable Long id,
            @RequestBody @Valid FuncionarioRequestDTO dto) {
        FuncionarioResponseDTO funcionarioAtualizado = service.atualizarFuncionario(id, dto);
        return ResponseEntity.ok(funcionarioAtualizado);
    }

    // DELETE - Deletar um funcionário por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        service.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}