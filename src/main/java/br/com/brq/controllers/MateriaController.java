package br.com.brq.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.brq.dtos.MateriaDTO;
import br.com.brq.services.MateriaService;

@RestController
@RequestMapping("materias")
@CrossOrigin(origins = "*")
public class MateriaController {

	@Autowired
	private MateriaService materiaService;
	
	
	@GetMapping("")
	public ResponseEntity<List<MateriaDTO>> findAll(){
		//return this.materiaService.findAll();
		return ResponseEntity.ok().body(this.materiaService.findAll());
		// see later if we'll delete it.
	}
	
	
	@GetMapping("/{materiaId}")
	public ResponseEntity<MateriaDTO> findById(@PathVariable(name = "materiaId") Integer materiaId) {
		//return this.materiaService.findById(materiaId);		
		return ResponseEntity.ok().body(this.materiaService.findById(materiaId));
	}
	
	
	@GetMapping("procurar-por-nome/{nomeMat}")
	public ResponseEntity<List<MateriaDTO>> findByNomeContains(@PathVariable(name = "nomeMat") String nomeMat) {
		//return this.materiaService.findByNomeContains(nomeMat);		
		List<MateriaDTO> listMatDTO = this.materiaService.findByNomeContains(nomeMat);		
		
		return ResponseEntity.ok().body(listMatDTO);
	}
	
	
	@GetMapping("paginacao")
	public ResponseEntity<Page<MateriaDTO>> paginacao(
				@RequestParam(name="pagina", defaultValue = "0") int pagina,
				@RequestParam(name="registros", defaultValue = "10") int registros,
				@RequestParam(name="procurar", defaultValue = "nenhumaMateriaSelecionada") String procurarMateria
			) {		
		
		Page<MateriaDTO> pageDTO = this.materiaService.paginacao(pagina, registros, procurarMateria);		
		return  ResponseEntity.ok().body(pageDTO);
		/*
		 * Always return a ResponseEntity<T>
		 * 
		 */
	}
	
	
	@PostMapping("")
	public ResponseEntity<MateriaDTO> save(@Valid @RequestBody MateriaDTO novaMateria) {
		//return this.materiaService.save(novaMateria);		
		return ResponseEntity.ok().body(this.materiaService.save(novaMateria));
	}
	
	
	@PatchMapping("/{materiaId}")
	public ResponseEntity<MateriaDTO> update(@PathVariable(name = "materiaId") Integer materiaId, @Valid @RequestBody MateriaDTO atualizarMat) {
		//return this.materiaService.update(materiaId, atualizarMat);
		return ResponseEntity.ok().body(this.materiaService.update(materiaId, atualizarMat));
	}
	
	
	@DeleteMapping("/{materiaId}")
	public void delete(@PathVariable(name = "materiaId") Integer materiaId) {
		this.materiaService.delete(materiaId);
	}	
	
}
