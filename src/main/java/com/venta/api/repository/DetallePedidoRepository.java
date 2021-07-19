package com.venta.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.venta.api.model.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {

	@Query("select u from DetallePedido u where u.idPedido = ?1")
	List<DetallePedido> findByIdPedido(int pedidoId);
}
