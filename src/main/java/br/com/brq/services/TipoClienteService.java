package br.com.brq.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brq.models.TipoCliente;
import br.com.brq.repositories.TipoClienteRepository;

@Service
public class TipoClienteService {

	@Autowired
	private TipoClienteRepository tipoClienteRepository;
	
	public List<TipoCliente> findAll(){
		return this.tipoClienteRepository.findAll();
	}
	
	public TipoCliente findOne(String codtipocli) {
		//Optional<TipoCliente> opTipoCli = this.tipoClienteRepository.findById(codtipocli);
		return this.tipoClienteRepository.findById(codtipocli).orElseThrow(() -> new RuntimeException("Registro não localizado"));
	}
	
	public TipoCliente save(TipoCliente novoTipoCliente) {
		return this.tipoClienteRepository.save(novoTipoCliente);
	}
	
	public TipoCliente update(String codtipocli, TipoCliente alterarTipoCliente) {
		TipoCliente updated = this.findOne(codtipocli);
		
		if (alterarTipoCliente.getDesctipocli() != null) {
			updated.setDesctipocli(alterarTipoCliente.getDesctipocli());
		}
		
		return this.tipoClienteRepository.save(updated);		
	}
	
	public void delete(String codtipocli) {
		try {
			this.tipoClienteRepository.deleteById(codtipocli);
		}
		catch (Exception e) {
			throw new RuntimeException("Erro ao deletar registro");
		}
	}
	
}
