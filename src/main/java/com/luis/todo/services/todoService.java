package com.luis.todo.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luis.todo.domain.todo;
import com.luis.todo.repositories.todoRepository;
import com.luis.todo.services.exceptions.ObjectNotFoundException;

@Service
public class todoService {

	@Autowired
	private todoRepository repository;

	public todo findById(Integer id) {
		Optional<todo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ",Tipo: " + todo.class.getName()));
	}

	public List<todo> findAllOpen() {
		List<todo> list = repository.findAllOpen();
		return list;
	}

	public List<todo> findAllClose() {
		List<todo> list = repository.findAllClose();
		return list;
	}

	public List<todo> findAll() {
		List<todo> list = repository.findAll();
		return list;
	}

	public todo create(todo obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public todo update(Integer id, todo obj) {
		todo newObj = findById(id);
		newObj.setTitulo(obj.getTitulo());
		newObj.setDataParaFinalizar(obj.getDataParaFinalizar());
		newObj.setDescricao(obj.getDescricao());
		newObj.setFinalizado(obj.getFinalizado());
		return repository.save(newObj);
	}

}
