package com.eprogrammerz.examples.springbootmongo;

import com.eprogrammerz.examples.springbootmongo.models.Base;
import com.eprogrammerz.examples.springbootmongo.models.Derived;
import com.eprogrammerz.examples.springbootmongo.repositories.DerivedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
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
		Derived derived1 = new Derived();
		derived1.setFieldB("fieldB1");
		derived1.setFieldA("fieldA1");

		Derived derived2 = new Derived();
		derived2.setFieldB("fieldB2");
		derived2.setFieldA("fieldA2");
		this.derivedRepository.save(Arrays.asList(derived1, derived2));

		List<Derived> deriveds = this.derivedRepository.findByFieldA("fieldA1");
		System.out.println(deriveds);

		List<Derived> deriveds1 = this.derivedRepository.findByFieldB("fieldB2");
		System.out.println(deriveds1);
	}
}
