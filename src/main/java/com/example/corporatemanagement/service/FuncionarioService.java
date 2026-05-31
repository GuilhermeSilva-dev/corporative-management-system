package com.example.corporatemanagement.service;

import com.example.corporatemanagement.dto.FuncionarioRequestDTO;
import com.example.corporatemanagement.dto.FuncionarioResponseDTO;
import com.example.corporatemanagement.model.FuncionarioModel;
import com.example.corporatemanagement.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    // READ (Todos)
    public List<FuncionarioResponseDTO> listarFuncionarios() {
        return repository
                .findAll()
                .stream()
                .map(f -> new FuncionarioResponseDTO(
                        f.getNome(),
                        f.getEmail(),
                        f.getTelefone(),
                        f.getSetor(),
                        f.getSalario()
                ))
                .toList();
    }

    // READ (Por ID)
    public FuncionarioResponseDTO buscarPorId(Long id) {
        FuncionarioModel f = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Este funcionário não existe!"));

        return new FuncionarioResponseDTO(
                f.getNome(),
                f.getEmail(),
                f.getTelefone(),
                f.getSetor(),
                f.getSalario()
        );
    }

    // CREATE
    public FuncionarioModel salvarFuncionario(FuncionarioRequestDTO dto) {
        if (repository.findByCpf(dto.getCpf()).isPresent()) {
            throw new RuntimeException("Funcionário já cadastrado!");
        }

        FuncionarioModel novoFuncionario = new FuncionarioModel();
        novoFuncionario.setNome(dto.getNome());
        novoFuncionario.setCpf(dto.getCpf());
        novoFuncionario.setEmail(dto.getEmail());
        novoFuncionario.setTelefone(dto.getTelefone());
        novoFuncionario.setSetor(dto.getSetor());
        novoFuncionario.setSalario(dto.getSalario());

        return repository.save(novoFuncionario);
    }

    // UPDATE
    @Transactional
    public FuncionarioResponseDTO atualizarFuncionario(Long id, FuncionarioRequestDTO dto) {
        FuncionarioModel funcionarioExistente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Este funcionário não existe!"));

        funcionarioExistente.setNome(dto.getNome());
        funcionarioExistente.setCpf(dto.getCpf());
        funcionarioExistente.setEmail(dto.getEmail());
        funcionarioExistente.setTelefone(dto.getTelefone());
        funcionarioExistente.setSetor(dto.getSetor());
        funcionarioExistente.setSalario(dto.getSalario());

        FuncionarioModel funcionarioAtualizado = repository.save(funcionarioExistente);

        return new FuncionarioResponseDTO(
                funcionarioAtualizado.getNome(),
                funcionarioAtualizado.getEmail(),
                funcionarioAtualizado.getTelefone(),
                funcionarioAtualizado.getSetor(),
                funcionarioAtualizado.getSalario()
        );
    }

    // DELETE
    @Transactional
    public void deletarFuncionario(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Este funcionário não existe!");
        }
        repository.deleteById(id);
    }
}