package br.com.brq.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.brq.dtos.AlunoDTO;
import br.com.brq.exceptions.ObjetoNaoEncontradoException;
import br.com.brq.models.AlunoMateriaModel;
import br.com.brq.models.AlunoModel;
import br.com.brq.repositories.AlunoMateriaRepository;
import br.com.brq.repositories.AlunoRepository;
import br.com.brq.repositories.EnderecoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private AlunoMateriaRepository alunoMateriaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	//
	public List<AlunoDTO> findAll() {		
		List<AlunoModel> listModel = this.alunoRepository.findAll();
		
		if (listModel.isEmpty()) {
			throw new ObjetoNaoEncontradoException("Nenhum Aluno encontrado com o parâmetro informado");
			// here: why was my message fully skipped?
		}
		
		return listModel.stream().map((x) -> x.toDto()).collect(Collectors.toCollection(ArrayList::new));
	}
	
	
	public AlunoDTO findById(Integer alunoId) {		
		return this.alunoRepository.findById(alunoId).orElseThrow(() -> new ObjetoNaoEncontradoException("Aluno não encontrado")).toDto();
	}
	
	
	public AlunoDTO save(AlunoDTO novoAluno) {
		return this.alunoRepository.save(novoAluno.toEntity()).toDto();
	}
	
	
	public AlunoDTO update(Integer alunoId, AlunoDTO alterarAluno) {		
		Optional<AlunoModel> optAluno = this.alunoRepository.findById(alunoId);

		if (optAluno.isPresent()) {
			AlunoModel objFromDatabase = optAluno.get();

			// We'll use validation later in order to prevent or not the null values			
			objFromDatabase.setNome(alterarAluno.getNome());
			objFromDatabase.setTurma(alterarAluno.getTurma());			
			return this.alunoRepository.save(objFromDatabase).toDto();
			
		} else {
			throw new ObjetoNaoEncontradoException("Aluno não encontrada");
		}
	}

	
	@Transactional
	public void delete(Integer matricula) {
		List<AlunoMateriaModel> list = this.alunoMateriaRepository.findByAlunoId(matricula);
		
		if(list.size() > 0) {
			for (AlunoMateriaModel alunoMateriaModel : list) {
				this.alunoMateriaRepository.deleteById(alunoMateriaModel.getId());
			}
		}
		
		this.enderecoRepository.deleteByAlunoMatricula(matricula);
		//this.enderecoRepository.deleteByAlunoObj(matricula);		
		this.alunoRepository.deleteById(matricula);
	}
	
	
	public List<AlunoDTO> findByNomeContains(String nomeAluno){
		List<AlunoModel> listModel = this.alunoRepository.findByNomeContains(nomeAluno);
		return listModel.stream().map((x) -> x.toDto()).collect(Collectors.toCollection(ArrayList::new));
	}
	
	
	public Page<AlunoDTO> paginacao(int pagina, int registros) {
		PageRequest pageRequest = PageRequest.of(pagina, registros);
		
		Page<AlunoModel> pageModel = this.alunoRepository.findAll(pageRequest);
		
		Page<AlunoDTO> pageDTO = pageModel.map(
				new Function<AlunoModel, AlunoDTO>(){
					public AlunoDTO apply(AlunoModel model) {
						return model.toDto();
					}
				}
			);		
		return pageDTO;
	}
	
	
}
