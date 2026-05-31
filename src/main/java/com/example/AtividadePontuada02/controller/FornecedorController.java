package com.example.AtividadePontuada02.controller;

import com.example.AtividadePontuada02.dto.FornecedorRequestDTO;
import com.example.AtividadePontuada02.dto.FornecedorResponseDTO;
import com.example.AtividadePontuada02.model.FornecedorModel;
import com.example.AtividadePontuada02.service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    // GET - Listar todos os fornecedores
    @GetMapping
    public ResponseEntity<List<FornecedorResponseDTO>> listarTodos() {
        List<FornecedorResponseDTO> fornecedores = service.listarFornecedores();
        return ResponseEntity.ok(fornecedores);
    }

    // GET - Buscar um fornecedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<FornecedorResponseDTO> buscarPorId(@PathVariable Long id) {
        FornecedorResponseDTO fornecedor = service.buscarPorId(id);
        return ResponseEntity.ok(fornecedor);
    }

    // POST - Criar um novo fornecedor
    @PostMapping
    public ResponseEntity<FornecedorModel> criarFornecedor(@RequestBody @Valid FornecedorRequestDTO dto) {
        FornecedorModel novoFornecedor = service.salvarFornecedor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFornecedor);
    }

    // PUT - Atualizar um fornecedor existente
    @PutMapping("/{id}")
    public ResponseEntity<FornecedorResponseDTO> atualizarFornecedor(
            @PathVariable Long id,
            @RequestBody @Valid FornecedorRequestDTO dto) {
        FornecedorResponseDTO fornecedorAtualizado = service.atualizarFornecedor(id, dto); // Mapeado para o método do seu Service
        return ResponseEntity.ok(fornecedorAtualizado);
    }

    // DELETE - Eliminar um fornecedor por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable Long id) {
        service.deletarFornecedor(id);
        return ResponseEntity.noContent().build();
    }
}