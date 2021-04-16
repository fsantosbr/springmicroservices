package br.com.brq.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.brq.models.EnderecoModel;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Integer>{

	@Modifying
	//@Transactional
//	@Query (value = "DELETE FROM endereco where aluno_id = :aluno", nativeQuery = true)
//	void deleteByAlunoObj(@Param("aluno") int aluno);

	void deleteByAlunoMatricula(Integer matricula);
	
}
