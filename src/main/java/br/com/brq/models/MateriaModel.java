package br.com.brq.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.brq.dtos.MateriaDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "materia")
public class MateriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "materia_seq")
	@SequenceGenerator(sequenceName = "materia_seq", allocationSize = 1, name = "materia_seq")
	private Integer id;
	
	private String nome;
	private String professor;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "materias")
	private List<AlunoModel> alunos = new ArrayList<>();
	
	
	// this method will clone an object to a DTO class (all of that based on a DTO class).
	public MateriaDTO toDto() {
		ModelMapper modelMapper = new ModelMapper();		
		return modelMapper.map(this, MateriaDTO.class);
	}
	
	
}
