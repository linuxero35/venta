package com.venta.api.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venta.api.dto.DetallePedidoDTO;
import com.venta.api.dto.PedidoDTO;
import com.venta.api.model.DetallePedido;
import com.venta.api.model.Pedido;
import com.venta.api.repository.DetallePedidoRepository;
import com.venta.api.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private DetallePedidoService detallePedidoservice;

	@Autowired
	private DetallePedidoRepository detalleRepository;

	private PedidoDTO parseEntityToDTO(Pedido entity) throws Exception {
		PedidoDTO dto = new PedidoDTO();
		try {

			dto.setIdPedido(entity.getIdPedido());
			dto.setDescripcion(entity.getDescripcion());
			dto.setArticulos(entity.getArticulos());
			dto.setTotal(entity.getTotal());
			dto.setIdEstatus(entity.getIdEstatus());
			dto.setIdUsuario(entity.getIdUsuario());
			dto.setFechaCreacion(new SimpleDateFormat("dd/MM/yyyy").format(entity.getFechaCreacion()));

			List<DetallePedidoDTO> detalleList = new ArrayList<>();
			List<DetallePedido> detalle = detalleRepository.findByIdPedido(dto.getIdPedido());

			Optional.of(detalle).orElseGet(Collections::emptyList).forEach(o -> {
				try {
					detalleList.add(detallePedidoservice.parseEntityToDTO(o));
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			});

			dto.setDetalle(detalleList);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return dto;
	}

	private Pedido parseDTOToEntity(PedidoDTO dto) throws Exception {
		Pedido entity = new Pedido();
		try {

			entity.setIdPedido(dto.getIdPedido());
			entity.setDescripcion(dto.getDescripcion());
			entity.setArticulos(dto.getArticulos());
			entity.setTotal(dto.getTotal());
			entity.setIdEstatus(dto.getIdEstatus());
			entity.setIdUsuario(dto.getIdUsuario());
			entity.setFechaCreacion(new SimpleDateFormat("dd/MM/yyyy").parse(dto.getFechaCreacion()));

			return entity;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public PedidoDTO save(PedidoDTO dto) throws Exception {
		try {
			Pedido pedido = pedidoRepository.save(parseDTOToEntity(dto));

			Optional.ofNullable(dto.getDetalle()).orElseGet(Collections::emptyList).stream().forEach(o -> {
				o.setIdPedido(pedido.getIdPedido());
				try {
					detallePedidoservice.save(o);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			});

			return parseEntityToDTO(pedido);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<PedidoDTO> getAll() throws Exception {
		try {
			return Optional.ofNullable(pedidoRepository.findAll()).orElseGet(Collections::emptyList).stream().map(o -> {
				try {
					return parseEntityToDTO(o);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}).collect(Collectors.toList());
		} catch (Exception e) {
			throw e;
		}
	}
}
