package com.mchaves.Suporte.a.Clientes.controller;

import com.mchaves.Suporte.a.Clientes.dto.DTOCliente;
import com.mchaves.Suporte.a.Clientes.model.Cliente;
import com.mchaves.Suporte.a.Clientes.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listAll() {
        return ResponseEntity.ok(clienteService.lisAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody @Valid DTOCliente dtoCliente) {
        return new ResponseEntity<>(clienteService.save(dtoCliente), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> replace(@RequestBody DTOCliente dtoCliente, @PathVariable Integer id) {
        return ResponseEntity.ok(clienteService.replace(dtoCliente, id));
    }


}
