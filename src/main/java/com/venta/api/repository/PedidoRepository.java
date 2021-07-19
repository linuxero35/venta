package com.venta.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venta.api.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
