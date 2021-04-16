package br.com.brq.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brq.models.AlunoMateriaModel;

public interface AlunoMateriaRepository extends JpaRepository<AlunoMateriaModel, Integer> {

	List<AlunoMateriaModel> findByAlunoId(int alunoId);
	
	
}
