package com.eprogrammerz.examples.repositories

import com.eprogrammerz.examples.models.Customer
import org.springframework.data.repository.CrudRepository

/**
 * Created by Yogen on 9/11/2017.
 */
interface CustomerRepository: CrudRepository<Customer, Long> {
    fun findByLastName(name: String): List<Customer>
}