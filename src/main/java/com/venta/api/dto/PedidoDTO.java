package com.venta.api.dto;

import java.io.Serializable;
import java.util.List;

public class PedidoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3978062636374997560L;

	private int idPedido;
	private String descripcion;
	private int articulos;
	private double total;
	private String fechaCreacion;
	private int idUsuario;
	private int idEstatus;
	private List<DetallePedidoDTO> detalle;

	public List<DetallePedidoDTO> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DetallePedidoDTO> detalle) {
		this.detalle = detalle;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getArticulos() {
		return articulos;
	}

	public void setArticulos(int articulos) {
		this.articulos = articulos;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(int idEstatus) {
		this.idEstatus = idEstatus;
	}

}
