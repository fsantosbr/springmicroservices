package br.com.brq.dtos;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import br.com.brq.models.EscolaModel;
import lombok.Data;

@Data
public class EscolaDTO {
	
	private Integer id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String tipoEscola;
	
	@NotNull
	private Integer numeroSalas;
	
	
	// this method will clone an object to a Model/Entity class (all of that based on a Entity class).
	public EscolaModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, EscolaModel.class);
	}
}
