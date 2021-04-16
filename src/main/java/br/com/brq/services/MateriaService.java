package br.com.brq.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.brq.dtos.MateriaDTO;
import br.com.brq.exceptions.ObjetoNaoEncontradoException;
import br.com.brq.models.MateriaModel;
import br.com.brq.repositories.MateriaRepository;

@Service
public class MateriaService {

	@Autowired
	private MateriaRepository materiaRepository;
	
	
	public List<MateriaDTO> findAll() {
		List<MateriaModel> listModel = this.materiaRepository.findAll();
		
		if (listModel.isEmpty()) {
			throw new ObjetoNaoEncontradoException("Nenhuma matéria encontrada com o parâmetro informado");
			// here: why was my message fully skipped?
		}
		
		return listModel.stream().map( x -> x.toDto())
	            .collect(Collectors.toCollection(ArrayList::new));
	}
	
	
	public MateriaDTO findById(Integer materiaId) {
		return this.materiaRepository.findById(materiaId)
				.orElseThrow(() -> new ObjetoNaoEncontradoException("Matéria não encontrada")).toDto();
	}
	
	
	public MateriaDTO save(MateriaDTO novaMateria) {
		return this.materiaRepository.save(novaMateria.toEntity()).toDto();
	}
	
	
	public MateriaDTO update(Integer materiaId, MateriaDTO atualizarMat) {		
		Optional<MateriaModel> targetMat = this.materiaRepository.findById(materiaId);
		
		if (targetMat.isPresent()) {			
			MateriaModel objFromDatabase = targetMat.get();			
			objFromDatabase.setNome(atualizarMat.getNome());
			objFromDatabase.setProfessor(atualizarMat.getProfessor());
			
			return this.materiaRepository.save(objFromDatabase).toDto();
		}
		else {
			throw new ObjetoNaoEncontradoException("Matéria não encontrada");
		}
	}
	
	
	public void delete(Integer materiaId) {
		try {
			this.materiaRepository.deleteById(materiaId);
		}
		catch(Exception e) {
			throw new ObjetoNaoEncontradoException("Registro não encontrado");
		}
	}
	
	
	public List<MateriaDTO> findByNomeContains(String nomeMat){		
		List<MateriaModel> listModel = this.materiaRepository.findByNomeContains(nomeMat);
		if (listModel.isEmpty()) {
			throw new ObjetoNaoEncontradoException("Nenhuma matéria encontrada com o parâmetro informado");
			// here: why was my message fully skipped?
		}
		
		return listModel.stream().map( x -> x.toDto() )
        .collect(Collectors.toCollection(ArrayList::new));		
	}
	
	
	public Page<MateriaDTO> paginacao(int pagina, int registros) {
		PageRequest pageRequest = PageRequest.of(pagina, registros);
		
		Page<MateriaModel> pageModel = this.materiaRepository.findAll(pageRequest);
		
		Page<MateriaDTO> pageDTO = pageModel.map(
				new Function<MateriaModel, MateriaDTO>(){
					public MateriaDTO apply(MateriaModel model) {
						return model.toDto();
					}
				}
			);
		
			return pageDTO;
	}
}
