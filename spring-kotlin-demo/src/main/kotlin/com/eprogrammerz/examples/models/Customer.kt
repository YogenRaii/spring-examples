package com.eprogrammerz.examples.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by Yogen on 9/11/2017.
 */
@Entity
class Customer(var firstName: String = "",
               var lastName: String = "",
               @Id @GeneratedValue(strategy = GenerationType.AUTO)
               var id: Long = 0)