package com.mchaves.Suporte.a.Clientes.service;

import com.mchaves.Suporte.a.Clientes.dto.DTOCliente;
import com.mchaves.Suporte.a.Clientes.exception.BadRequestException;
import com.mchaves.Suporte.a.Clientes.model.Cliente;
import com.mchaves.Suporte.a.Clientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> lisAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Cliente não encontrado"));
    }

    public Cliente save(DTOCliente dtoCliente) {
        return clienteRepository.save(Cliente.builder()
                .nome(dtoCliente.getNome())
                .cpf(dtoCliente.getCpf())
                .build());
    }

    public Cliente replace(DTOCliente dtoCliente, Integer id) {
        Cliente clienteSaved = findById(id);
        Cliente cliente = Cliente.builder()
                .id(clienteSaved.getId())
                .nome(dtoCliente.getNome())
                .cpf(dtoCliente.getCpf())
                .dataCadastro(clienteSaved.getDataCadastro())
                .build();
        return clienteRepository.save(cliente);
    }
}
