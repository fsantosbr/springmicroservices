package br.com.brq.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brq.models.TipoCliente;
import br.com.brq.services.TipoClienteService;

@RequestMapping("tipo-clientes")
@RestController
public class TipoClienteController {

	@Autowired
	private TipoClienteService tipoClienteService;
	
	@GetMapping("")
	public List<TipoCliente> findAll(){
		return this.tipoClienteService.findAll();		
	}
	
	@GetMapping("/{codtipocli}")
	public TipoCliente findOne(@PathVariable String codtipocli) {
		return this.tipoClienteService.findOne(codtipocli);		
	}
	
	@PostMapping("")
	public TipoCliente save(@RequestBody TipoCliente novoTipoCliente) {
		// The  @RequestBody annotation indicates the variable that will get information from the body in the request
		return this.tipoClienteService.save(novoTipoCliente);		
	}
	
	@PatchMapping("/{codtipocli}")
	public TipoCliente update(@PathVariable String codtipocli, @RequestBody TipoCliente alterarTipoCliente) {
		return this.tipoClienteService.update(codtipocli, alterarTipoCliente);
	}
	
	@DeleteMapping("/{codtipocli}")
	public void delete(@PathVariable String codtipocli) {
		this.tipoClienteService.delete(codtipocli);
	}
	
	
	 
}
