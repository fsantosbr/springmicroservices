package br.com.brq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brq.models.EscolaModel;

@Repository
public interface EscolaRepository extends JpaRepository<EscolaModel, Integer> {

}
