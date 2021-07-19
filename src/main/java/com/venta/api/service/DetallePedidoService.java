package com.venta.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venta.api.dto.DetallePedidoDTO;
import com.venta.api.model.DetallePedido;
import com.venta.api.repository.DetallePedidoRepository;

@Service
public class DetallePedidoService {

	@Autowired
	private DetallePedidoRepository detallerepository;

	public DetallePedidoDTO parseEntityToDTO(DetallePedido entity) throws Exception {
		DetallePedidoDTO dto = new DetallePedidoDTO();
		try {
			dto.setIdDetallePedido(entity.getIdDetallePedido());
			dto.setIdPedido(entity.getIdPedido());
			dto.setArticulo(entity.getArticulo());
			dto.setPrecio(entity.getPrecio());
			dto.setIdUsuario(entity.getIdUsuario());

			return dto;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public DetallePedido parseDTOToEntity(DetallePedidoDTO dto) throws Exception {
		DetallePedido entity = new DetallePedido();
		try {
			entity.setIdDetallePedido(dto.getIdDetallePedido());
			entity.setIdPedido(dto.getIdPedido());
			entity.setArticulo(dto.getArticulo());
			entity.setPrecio(dto.getPrecio());
			entity.setIdUsuario(dto.getIdUsuario());

			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public DetallePedidoDTO save(DetallePedidoDTO dto) throws Exception {
		try {
			DetallePedido detalle = detallerepository.save(parseDTOToEntity(dto));

			return parseEntityToDTO(detalle);
		} catch (Exception e) {
			throw e;
		}
	}

}
