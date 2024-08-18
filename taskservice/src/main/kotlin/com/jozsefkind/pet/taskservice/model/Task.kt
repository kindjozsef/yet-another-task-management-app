package com.jozsefkind.pet.taskservice.model

import jakarta.persistence.*

@Entity
data class Task(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val title: String,

    @Column
    @Enumerated(EnumType.STRING)
    val status: TaskStatus,

    @Column
    val description: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User
)

enum class TaskStatus {
    CREATED, BLOCKED, IN_PROGRESS, DONE
}