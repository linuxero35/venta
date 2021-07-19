package com.venta.api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdPedido")
	private int idPedido;

	@Column(name = "Descripcion", length = 100)
	private String descripcion;

	@Column(name = "Articulos", nullable = false)
	private int articulos;

	@Column(name = "total", nullable = false)
	private double total;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FechaCreacion", updatable = false, nullable = false)
	private Date fechaCreacion;

	@Column(name = "IdUsuario", updatable = false, nullable = false)
	private int idUsuario;

	@Column(name = "IdEstatus", nullable = false)
	private int idEstatus;
	
	@OneToMany
	@JoinColumn(name = "idPedido")
	private List<DetallePedido> detalle;

	public List<DetallePedido> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DetallePedido> detalle) {
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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
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

	@PrePersist
	private void createDate() {
		this.fechaCreacion = new Date();
	}

}
