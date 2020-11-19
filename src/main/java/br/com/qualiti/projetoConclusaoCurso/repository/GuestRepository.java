package br.com.qualiti.projetoConclusaoCurso.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.qualiti.projetoConclusaoCurso.model.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, String>{
	
	public Boolean checkLogin(String cpf, String password);


}
