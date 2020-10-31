package br.com.qualiti.projetoConclusaoCurso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.qualiti.projetoConclusaoCurso.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {

	List<Hotel> findByNameContainingIgnoreCase(String name);
	
}
