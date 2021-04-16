package br.com.brq.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.brq.dtos.AlunoDTO;
import br.com.brq.services.AlunoService;

@RequestMapping("alunos")
@RestController	
public class AlunoController {	
	
	@Autowired
	private AlunoService alunoService;	
	
	
	@GetMapping("")
	public ResponseEntity<List<AlunoDTO>> findAll(){
		//return this.alunoService.findAll();
		return ResponseEntity.ok().body(this.alunoService.findAll());
	}
	
	
	@GetMapping("/{alunoId}")
	public ResponseEntity<AlunoDTO> findById(@PathVariable Integer alunoId, @RequestParam( value = "q", defaultValue = "") String query) {
		// Note: The @RequestParam doesn't do anything yet. It's missing a body implementation		
		return ResponseEntity.ok().body(this.alunoService.findById(alunoId));
	}
	
	
	@GetMapping("procurar-por-nome/{nomeAluno}")
	public ResponseEntity<List<AlunoDTO>> findByNomeContains(@PathVariable(name = "nomeAluno") String nomeAluno) {
		//return this.alunoService.findByNomeContains(nomeAluno);
		List<AlunoDTO> listDTO = this.alunoService.findByNomeContains(nomeAluno);		
		return ResponseEntity.ok().body(listDTO);
	}
	
	
	@PostMapping("")
	public ResponseEntity<AlunoDTO> save(@RequestBody AlunoDTO novoAluno) {
		//return this.alunoService.save(novoAluno);		
		return ResponseEntity.ok().body(this.alunoService.save(novoAluno));
	}
	
	
	@PatchMapping("/{alunoId}")
	public ResponseEntity<AlunoDTO> update(@PathVariable Integer alunoId, @RequestBody AlunoDTO alterarAluno) {
		//return this.alunoService.update(alunoId, alterarAluno);
		return ResponseEntity.ok().body(this.alunoService.update(alunoId, alterarAluno));
	}
	
	
	@DeleteMapping("/{alunoId}")
	public void delete(@PathVariable Integer alunoId) {		
		this.alunoService.delete(alunoId);
	}
	

}
