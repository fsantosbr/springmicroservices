package br.com.brq.dtos;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import br.com.brq.models.EnderecoModel;
import lombok.Data;

@Data
public class EnderecoDTO {

	private int id;
	
	@NotNull
	private String logradouro;
	
	@NotNull
	private String numero;
	
	@NotNull
	private String complemento;
	
	@NotNull
	private String cep;

	// this method will clone an object to a Model/Entity class (all of that based on a Entity class).
	public EnderecoModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, EnderecoModel.class);
	}

}
