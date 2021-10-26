package com.mchaves.Suporte.a.Clientes.repository;

import com.mchaves.Suporte.a.Clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
