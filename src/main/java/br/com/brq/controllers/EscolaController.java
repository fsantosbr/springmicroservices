package br.com.brq.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brq.dtos.EscolaDTO;
import br.com.brq.services.EscolaService;

@RestController
@RequestMapping("escolas")
public class EscolaController {

	@Autowired
	private EscolaService escolaService;
	
	
	@GetMapping("")
	public ResponseEntity<List<EscolaDTO>> findAll(){
		///return this.escolaService.findAll();		
		return ResponseEntity.ok().body(this.escolaService.findAll());
	}
	
	
	@GetMapping("/{escolaId}")
	public ResponseEntity<EscolaDTO> findById(@PathVariable(name = "escolaId") Integer escolaId) {
		//return this.escolaService.findById(escolaId);
		return ResponseEntity.ok().body(this.escolaService.findById(escolaId));
	}
	
	
	@PostMapping("")
	public ResponseEntity<EscolaDTO> save(@Valid @RequestBody EscolaDTO novaEscola) {
		//return this.escolaService.save(novaEscola);
		return ResponseEntity.ok().body(this.escolaService.save(novaEscola));
	}
	
	
	@PatchMapping("/{escolaId}")
	public ResponseEntity<EscolaDTO> update(@PathVariable(name = "escolaId") Integer escolaId, @Valid @RequestBody EscolaDTO atualizarEsc) {
		//return this.escolaService.update(escolaId, atualizarEsc);
		return ResponseEntity.ok().body(this.escolaService.update(escolaId, atualizarEsc));
	}
	
	
	@DeleteMapping("/{escolaId}")
	public void delete(@PathVariable(name = "escolaId") Integer escolaId) {
		this.escolaService.delete(escolaId);
	}
}
