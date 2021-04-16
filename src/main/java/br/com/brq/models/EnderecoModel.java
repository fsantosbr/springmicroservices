package br.com.brq.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.brq.dtos.EnderecoDTO;
import lombok.Data;

@Data
@Entity
@Table(name = "endereco")
public class EnderecoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_seq")
	@SequenceGenerator(sequenceName = "endereco_seq", allocationSize = 1, name = "endereco_seq")
	private int id;	
	
	@NotNull
	private String logradouro;
	
	@NotNull
	private String numero;
	
	@NotNull
	private String complemento;
	
	@NotNull
	private String cep;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn (name = "aluno_id")
	private AlunoModel aluno;
	// relationship between one to one, we use the annotation JoinColumn where is the foreign key.
	// the other entity, we use only use the @OneToOne(mappedBy = "aluno")
	// @jsonIgnore will inform the Spring/Json that we do not want the Student's address loaded
	
	
	// this method will clone an object to a DTO class (all of that based on a DTO class).
	public EnderecoDTO toDto() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, EnderecoDTO.class);
	}
}
