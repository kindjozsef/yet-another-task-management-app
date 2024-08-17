package com.jozsefkind.pet.taskservice.model

import jakarta.persistence.*

@Entity
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    @Column(unique = true)
    private val username: String,

    @Column
    private val password: String,

    @Column(unique = true)
    private val email: String
)