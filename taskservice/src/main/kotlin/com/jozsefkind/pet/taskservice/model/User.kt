package com.jozsefkind.pet.taskservice.model

import jakarta.persistence.*

@Entity
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(unique = true)
    val username: String,

    @Column
    var password: String,

    @Column(unique = true)
    val email: String
)