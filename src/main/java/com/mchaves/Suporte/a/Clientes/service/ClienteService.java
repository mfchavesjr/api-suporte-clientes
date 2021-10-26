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

    public Cliente save(DTOCliente dtoCliente) {
        return clienteRepository.save(Cliente.builder()
                .nome(dtoCliente.getNome())
                .cpf(dtoCliente.getCpf())
                .build());
    }

    public Cliente findById(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Cliente não encontrado"));
    }
}
