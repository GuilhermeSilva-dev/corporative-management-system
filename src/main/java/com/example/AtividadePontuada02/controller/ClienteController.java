package com.example.AtividadePontuada02.controller;

import com.example.AtividadePontuada02.dto.ClienteRequestDTO;
import com.example.AtividadePontuada02.dto.ClienteResponseDTO;
import com.example.AtividadePontuada02.model.ClienteModel;
import com.example.AtividadePontuada02.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    // GET - Listar todos os clientes
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarTodos() {
        List<ClienteResponseDTO> clientes = service.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    // POST - Criar/Salvar um novo cliente
    @PostMapping
    public ResponseEntity<ClienteModel> criarCliente(@RequestBody @Valid ClienteRequestDTO dto) {
        // Chama exatamente o seu método 'salvarClientes'
        ClienteModel novoCliente = service.salvarClientes(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    // PUT - Atualizar um cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizarCliente(
            @PathVariable Long id,
            @RequestBody @Valid ClienteRequestDTO dto) {
        // Chama exatamente o seu método 'atualizarCliente' com os nomes idênticos
        ClienteResponseDTO clienteAtualizado = service.atualizarCliente(id, dto);
        return ResponseEntity.ok(clienteAtualizado);
    }

    // DELETE - Remover um cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        // Chama exatamente o seu método 'deletarCliente'
        service.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}