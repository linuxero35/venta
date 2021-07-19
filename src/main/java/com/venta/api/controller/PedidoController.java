package com.venta.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venta.api.commons.ResponseObject;
import com.venta.api.dto.PedidoDTO;
import com.venta.api.service.PedidoService;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = "*")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@PostMapping("/save")
	public ResponseObject save(@RequestBody PedidoDTO dto) {
		try {
			return new ResponseObject(pedidoService.save(dto), HttpStatus.OK.value(), null);
		} catch (Exception e) {
			return new ResponseObject(null, HttpStatus.MULTIPLE_CHOICES.value(), e.getMessage());
		}
	}

	@GetMapping("/getAll")
	private ResponseObject getAll() {
		try {
			return new ResponseObject(pedidoService.getAll(), HttpStatus.OK.value(), null);
		} catch (Exception e) {
			return new ResponseObject(null, HttpStatus.MULTIPLE_CHOICES.value(), e.getMessage());
		}
	}
}
