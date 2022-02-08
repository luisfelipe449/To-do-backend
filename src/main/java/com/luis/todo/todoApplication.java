package com.luis.todo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luis.todo.domain.todo;
import com.luis.todo.repositories.todoRepository;

@SpringBootApplication
public class todoApplication implements CommandLineRunner {

	@Autowired
	private todoRepository TodoRepository;

	public static void main(String[] args) {
		SpringApplication.run(todoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		todo t1 = new todo(null, "Estudar", "Estudar Spring boot 2 e angular.", sdf.parse("25/03/2022"), false);
		todo t2 = new todo(null, "Ler", "Ler livro de desenvolvimento pessoal.", sdf.parse("25/03/2022"), true);
		todo t3 = new todo(null, "Exercícios", "Realizar exercícios físicos.", sdf.parse("25/03/2022"), false);
		todo t4 = new todo(null, "Meditar", "Meditar por duas horas por dia.", sdf.parse("25/03/2022"), true);

		TodoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));

	}

}
