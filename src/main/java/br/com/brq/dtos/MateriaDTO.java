package br.com.brq.dtos;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import br.com.brq.models.MateriaModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MateriaDTO {
	
	private Integer id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String professor;
	
	// this method will clone an object to a Model/Entity class (all of that based on a Entity class).
	public MateriaModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, MateriaModel.class);
	}

}
