package br.com.qualiti.projetoConclusaoCurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.qualiti.projetoConclusaoCurso.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {

	
	
}
