package com.luis.todo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luis.todo.domain.todo;
import com.luis.todo.repositories.todoRepository;

@Service
public class DBService {

	@Autowired
	private todoRepository TodoRepository;

	public void instanciaBaseDeDados() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");

		todo t1 = new todo(null, "Estudar", "Estudar Spring boot 2 e angular.",
				sdf.parse("25/03/2022 " ), false);
		todo t2 = new todo(null, "Ler", "Ler livro de desenvolvimento pessoal.",
				sdf.parse("25/03/2022 "), true);
		todo t3 = new todo(null, "Exercícios", "Realizar exercícios físicos.",
				sdf.parse("25/03/2022"), false);
		todo t4 = new todo(null, "Meditar", "Meditar por duas horas por dia.",
				sdf.parse("25/03/2022"), true);

		TodoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}
}
