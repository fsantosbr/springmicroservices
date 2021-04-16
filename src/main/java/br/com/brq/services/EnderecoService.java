package br.com.brq.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.brq.dtos.EnderecoDTO;
import br.com.brq.exceptions.ObjetoNaoEncontradoException;
import br.com.brq.models.EnderecoModel;
import br.com.brq.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public EnderecoDTO findById(Integer enderecoId) {
		return this.enderecoRepository.findById(enderecoId).orElseThrow(() -> new ObjetoNaoEncontradoException("Endereço não encontrado")).toDto();
	}
	
	
	public List<EnderecoDTO> findAll(){		
		// An EnderecoModel loaded from Model layer
		List<EnderecoModel> listModel = this.enderecoRepository.findAll();
		
		if (listModel.isEmpty()) {
			throw new ObjetoNaoEncontradoException("Nenhum Endereço encontrada com o parâmetro informado");
			// here: why was my message fully skipped?
		}		
		return listModel.stream().map((x) -> x.toDto()).toList(); // check this line if it will really bring a list for our DTO
		// .collect(Collectors.toCollection(ArrayList::new))
	}
	
	
	public EnderecoDTO save(EnderecoDTO novoEndereco) {
		return this.enderecoRepository.save(novoEndereco.toEntity()).toDto();
	}
	
	
	public EnderecoDTO update(Integer enderecoId, EnderecoDTO atualizarEnd) {
		// We're still using bringing a EnderecoModel directly from Jpa because we don't have a method to convert DTO to Model yet.
		Optional<EnderecoModel> optEndereco = this.enderecoRepository.findById(enderecoId);

		if (optEndereco.isPresent()){
			EnderecoModel objFromDatabase = optEndereco.get();
			
			// We'll use validation later in order to prevent or not the null values 
			objFromDatabase.setLogradouro(atualizarEnd.getLogradouro());
			objFromDatabase.setNumero(atualizarEnd.getNumero());
			objFromDatabase.setComplemento(atualizarEnd.getComplemento());
			objFromDatabase.setCep(atualizarEnd.getCep());
			return this.enderecoRepository.save(objFromDatabase).toDto();
		}
		else {
			throw new ObjetoNaoEncontradoException("Endereço não encontrada");
		}
	}
	
	
	public void delete(Integer enderecoId) {
		try {
			this.enderecoRepository.deleteById(enderecoId);
		}
		catch (Exception e) {
			throw new ObjetoNaoEncontradoException("Registro não encontrado");
		}
	}
	
	
	public Page<EnderecoDTO> paginacao(int pagina, int registros) {
		PageRequest pageRequest = PageRequest.of(pagina, registros);		
		Page<EnderecoModel> pageModel = this.enderecoRepository.findAll(pageRequest);
		
		Page<EnderecoDTO> pageDTO = pageModel.map(
				new Function<EnderecoModel, EnderecoDTO>(){
					public EnderecoDTO apply(EnderecoModel model) {
						return model.toDto();
					}
				}
			);
		
			return pageDTO;
	}
}
