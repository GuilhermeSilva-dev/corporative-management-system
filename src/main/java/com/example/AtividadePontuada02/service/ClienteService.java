package com.example.AtividadePontuada02.service;

import com.example.AtividadePontuada02.dto.ClienteRequestDTO;
import com.example.AtividadePontuada02.dto.ClienteResponseDTO;
import com.example.AtividadePontuada02.model.ClienteModel;
import com.example.AtividadePontuada02.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<ClienteResponseDTO> listarClientes() {
        return repository
                .findAll()
                .stream()
                .map(cliente -> new ClienteResponseDTO(cliente.getNome(),cliente.getDataNascimento(),cliente.getEmail()))
                .toList();
    }

    public ClienteModel salvarClientes(ClienteRequestDTO clienteDTO){
        if (repository.findByCpf(clienteDTO.getCpf()).isPresent()){
            throw new RuntimeException("Cliente já cadastrado!");

        }

        ClienteModel novoCliente = new ClienteModel();
        novoCliente.setNome(clienteDTO.getNome());
        novoCliente.setCpf(clienteDTO.getCpf());
        novoCliente.setDataNascimento(clienteDTO.getDataNascimento());
        novoCliente.setEmail(clienteDTO.getEmail());

        String senhaCriptografada = passwordEncoder.encode(clienteDTO.getSenha());
        novoCliente.setSenha(senhaCriptografada);


        return repository.save(novoCliente);
    }

    @Transactional
    public ClienteResponseDTO atualizarCliente(Long id, ClienteRequestDTO clienteDTO) {
        ClienteModel clienteExistente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Este cliente não existe!"));

        clienteExistente.setNome(clienteDTO.getNome());
        clienteExistente.setEmail(clienteDTO.getEmail());
        clienteExistente.setDataNascimento(clienteDTO.getDataNascimento());

        clienteExistente.setCpf(clienteDTO.getCpf());

        String senhaCriptografada = passwordEncoder.encode(clienteDTO.getSenha());
        clienteExistente.setSenha(senhaCriptografada);

        ClienteModel clienteAtualizado = repository.save(clienteExistente);

        return new ClienteResponseDTO(clienteAtualizado.getNome(),clienteAtualizado.getDataNascimento(),clienteAtualizado.getEmail());

    }

    @Transactional
    public void deletarCliente(Long id) {
        if (!repository.existsById(id)){
            throw new RuntimeException("Este Cliente não existe!");
        }
        repository.deleteById(id);
    }

}
