package br.com.brq.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import br.com.brq.models.AlunoModel;
import lombok.Data;

@Data
public class AlunoDTO {

	private int Matricula;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String turma;	
	
	private EnderecoDTO endereco;
	private EscolaDTO escola;
	private List<MateriaDTO> materias = new ArrayList<>();
	
	
	// this method will clone an object to a Model/Entity class (all of that based on a Entity class).
	public AlunoModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, AlunoModel.class);
	}	
	
}
