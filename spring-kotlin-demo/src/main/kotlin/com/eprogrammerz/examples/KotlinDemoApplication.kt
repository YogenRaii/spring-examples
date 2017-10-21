package com.eprogrammerz.examples

import com.eprogrammerz.examples.models.Customer
import com.eprogrammerz.examples.repositories.CustomerRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class KotlinDemoApplication {
    @Bean
    fun init(customerRepository: CustomerRepository) = CommandLineRunner {
        customerRepository.save(Customer("Yogen", "Rai"))
        customerRepository.save(Customer("Gogen", "Gurung"))
        customerRepository.save(Customer("Yogesh", "Bhattrai"))
        customerRepository.save(Customer("Yogendra", "Rai"))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(KotlinDemoApplication::class.java, *args)
}
