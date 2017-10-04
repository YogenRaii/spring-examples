package com.eprogrammerz.examples.controllers

import com.eprogrammerz.examples.repositories.CustomerRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Yogen on 9/11/2017.
 */
@RestController
class CustomerController(val customerRepository: CustomerRepository) {
    @GetMapping("/")
    fun findAll() = customerRepository.findAll();

    @GetMapping("/{name}")
    fun findByLastName(@PathVariable name: String) = customerRepository.findByLastName(name)
}