package com.eprogrammerz.examples.springbootmongo;

import com.eprogrammerz.examples.springbootmongo.models.Base;
import com.eprogrammerz.examples.springbootmongo.models.Derived;
import com.eprogrammerz.examples.springbootmongo.repositories.DerivedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringBootMongoApplication implements CommandLineRunner {
	@Autowired
	private DerivedRepository derivedRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoApplication.class, args);
	}


	@Override
	public void run(String... strings) throws Exception {
		System.out.println("logging app...");
		Derived derived = new Derived();
		derived.setFieldB("fieldB");
		derived.setFieldA("fieldA");
		this.derivedRepository.save(derived);

		List<Derived> deriveds = this.derivedRepository.findByFieldA("fieldA");
		System.out.println(deriveds);
	}
}
