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

import br.com.brq.dtos.EscolaDTO;
import br.com.brq.exceptions.ObjetoNaoEncontradoException;
import br.com.brq.models.EscolaModel;
import br.com.brq.repositories.EscolaRepository;

@Service
public class EscolaService {

	
	@Autowired
	private EscolaRepository escolaRepository;
	
	
	public EscolaDTO findById(Integer escolaId) {
		return this.escolaRepository.findById(escolaId).orElseThrow(() -> new ObjetoNaoEncontradoException("Escola não encontrada")).toDto();
	}
	
	
	public List<EscolaDTO> findAll() {
		// An EnderecoModel loaded from Model layer
		List<EscolaModel> listModel = this.escolaRepository.findAll();
		
		if (listModel.isEmpty()) {
			throw new ObjetoNaoEncontradoException("Nenhuma escola encontrada com o parâmetro informado");
			// here: why was my message fully skipped?
		}
		return listModel.stream().map(x -> x.toDto()).collect(Collectors.toCollection(ArrayList::new));		
	}
	
	
	public EscolaDTO save(EscolaDTO novaEscola) {
		return this.escolaRepository.save(novaEscola.toEntity()).toDto();
	}
	
	
	public EscolaDTO update(Integer escolaId, EscolaDTO atualizarEsc) {
		// We're still using bringing a Model directly from Jpa because we don't have a method to convert DTO to Model yet.
		Optional<EscolaModel> optEscola = this.escolaRepository.findById(escolaId);

		if (optEscola.isPresent()) {
			EscolaModel objFromDatabase = optEscola.get();

			// We'll use validation later in order to prevent or not the null values
			objFromDatabase.setNome(atualizarEsc.getNome());
			objFromDatabase.setTipoEscola(atualizarEsc.getTipoEscola());
			objFromDatabase.setNumeroSalas(atualizarEsc.getNumeroSalas());			
			return this.escolaRepository.save(objFromDatabase).toDto();
			
		} else {
			throw new ObjetoNaoEncontradoException("Escola não encontrada para update");
			// check if this message is propagated
		}
	}

	
	public Page<EscolaDTO> paginacao(int pagina, int registros){
		PageRequest pageRequest = PageRequest.of(pagina, registros);
		
		Page<EscolaModel> pageModel = this.escolaRepository.findAll(pageRequest);
		
		Page<EscolaDTO> pageDTO = pageModel.map(
				new Function<EscolaModel, EscolaDTO>(){
					public EscolaDTO apply(EscolaModel model) {
						return model.toDto();
					}
				}
				
				);
		return pageDTO;
	}
	
	
	public void delete(Integer escolaId) {
		try {
			this.escolaRepository.deleteById(escolaId);
		}
		catch (Exception e) {
			throw new ObjetoNaoEncontradoException("Registro não encontrado");
		}
	}
}
