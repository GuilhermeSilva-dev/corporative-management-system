package com.example.AtividadePontuada02.service;

import com.example.AtividadePontuada02.dto.FornecedorRequestDTO;
import com.example.AtividadePontuada02.dto.FornecedorResponseDTO;
import com.example.AtividadePontuada02.model.FornecedorModel;
import com.example.AtividadePontuada02.repository.FornecedorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    // READ (Todos)
    public List<FornecedorResponseDTO> listarFornecedores() {
        return repository
                .findAll()
                .stream()
                .map(f -> new FornecedorResponseDTO(
                        f.getNome(),
                        f.getEmail(),
                        f.getTelefone()
                ))
                .toList();
    }

    // READ (Por ID)
    public FornecedorResponseDTO buscarPorId(Long id) {
        FornecedorModel f = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Este fornecedor não existe!"));

        return new FornecedorResponseDTO(
                f.getNome(),
                f.getEmail(),
                f.getTelefone()
        );
    }

    // CREATE
    public FornecedorModel salvarFornecedor(FornecedorRequestDTO dto) {
        if (repository.findByCnpj(dto.getCnpj()).isPresent()) {
            throw new RuntimeException("Fornecedor já cadastrado!");
        }

        FornecedorModel novoFornecedor = new FornecedorModel();
        novoFornecedor.setNome(dto.getNome());
        novoFornecedor.setCnpj(dto.getCnpj());
        novoFornecedor.setEmail(dto.getEmail());
        novoFornecedor.setTelefone(dto.getTelefone());

        return repository.save(novoFornecedor);
    }

    // UPDATE
    @Transactional
    public FornecedorResponseDTO atualizarFornecedor(Long id, FornecedorRequestDTO dto) {
        FornecedorModel fornecedorExistente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Este fornecedor não existe!"));

        fornecedorExistente.setNome(dto.getNome());
        fornecedorExistente.setCnpj(dto.getCnpj());
        fornecedorExistente.setEmail(dto.getEmail());
        fornecedorExistente.setTelefone(dto.getTelefone());

        FornecedorModel fornecedorAtualizado = repository.save(fornecedorExistente);

        return new FornecedorResponseDTO(
                fornecedorAtualizado.getNome(),
                fornecedorAtualizado.getEmail(),
                fornecedorAtualizado.getTelefone()
        );
    }

    // DELETE
    @Transactional
    public void deletarFornecedor(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Este fornecedor não existe!");
        }
        repository.deleteById(id);
    }
}