package com.luis.todo.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luis.todo.domain.todo;

@Repository
public interface todoRepository extends JpaRepository<todo, Integer> {

	@Query("SELECT obj FROM todo obj WHERE obj.finalizado = false ORDER BY obj.dataParaFinalizar")
	List<todo> findAllOpen();

	
	@Query("SELECT obj FROM todo obj WHERE obj.finalizado = true ORDER BY obj.dataParaFinalizar")
	List<todo> findAllClose();

}
