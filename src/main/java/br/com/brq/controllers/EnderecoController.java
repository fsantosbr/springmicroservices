package br.com.brq.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.brq.dtos.EnderecoDTO;
import br.com.brq.services.EnderecoService;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {
	
	
	@Autowired
	private EnderecoService enderecoService;
	
	
	@GetMapping("")
	public ResponseEntity<List<EnderecoDTO>> findAll(){
		//return this.enderecoService.findAll();
		return ResponseEntity.ok().body(this.enderecoService.findAll());
	}
	
	
	@GetMapping("/{enderecoId}")
	public ResponseEntity<EnderecoDTO> findById(@PathVariable(name = "enderecoId") Integer enderecoId) {
		//return this.enderecoService.findById(enderecoId);
		return ResponseEntity.ok().body(this.enderecoService.findById(enderecoId));
	}
	
	
	@GetMapping("paginacao")
	public ResponseEntity<Page<EnderecoDTO>> paginacao(
			@RequestParam(name = "pagina", defaultValue = "0") int pagina,
			@RequestParam(name = "registros", defaultValue = "10") int registros
			) {

		Page<EnderecoDTO> pageDTO = this.enderecoService.paginacao(pagina, registros);
		return ResponseEntity.ok().body(pageDTO);
		/*
		 * Always return a ResponseEntity<T>
		 * 
		 */
	}
	
	
	@PostMapping("")
	public ResponseEntity<EnderecoDTO> save(@Valid @RequestBody EnderecoDTO novoEndereco) {
		return ResponseEntity.ok().body(this.enderecoService.save(novoEndereco));
	}
	
	
	@PatchMapping("/{enderecoId}")
	public ResponseEntity<EnderecoDTO> update(@PathVariable(name = "enderecoId") Integer enderecoId,@Valid @RequestBody EnderecoDTO atualizarEnd) {
		return ResponseEntity.ok().body(this.enderecoService.update(enderecoId, atualizarEnd));
	}
	
	
	@DeleteMapping("/{enderecoId}")
	public void delete(@PathVariable(name = "enderecoId") Integer enderecoId) {
		this.enderecoService.delete(enderecoId);
	}
}
