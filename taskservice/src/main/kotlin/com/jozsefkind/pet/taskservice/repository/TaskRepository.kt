package com.jozsefkind.pet.taskservice.repository

import com.jozsefkind.pet.taskservice.model.Task
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
@Repository
@Transactional
interface TaskRepository: JpaRepository<Task, Long>{
}