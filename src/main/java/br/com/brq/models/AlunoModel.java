package br.com.brq.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import br.com.brq.dtos.AlunoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// @Data (from Lombok) criar os getters and setters.


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aluno")
public class AlunoModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno_seq")
	@SequenceGenerator(sequenceName = "aluno_seq", allocationSize = 1, name = "aluno_seq")
	private int matricula;
	private String nome;
	private String turma;
	
		@OneToOne(mappedBy = "aluno")
	private EnderecoModel endereco;
	// relationship between one to one, we use the annotation JoinColumn where is the foreign key.
	// the other entity (this one), we use only use the @OneToOne(mappedBy = "aluno")	
	
	@ManyToOne	
	@JoinColumn(name = "escola_id")
	private EscolaModel escola;
	
	@ManyToMany
	@JoinTable (name = "aluno_materia",
		joinColumns = @JoinColumn(name = "aluno_id", updatable = false),
		inverseJoinColumns = @JoinColumn(name = "materia_id", updatable = false))
	private List<MateriaModel> materias = new ArrayList<>();
	// @JoinTable can be in whatever side of a manyToMany relationship.
	// @JoinTable needs first the table created to join 2 tables (many to many), then, it needs the column of one
	
	
	// this method will clone an object to a DTO class (all of that based on a DTO class).
	public AlunoDTO toDto() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, AlunoDTO.class);
	}
	
}
