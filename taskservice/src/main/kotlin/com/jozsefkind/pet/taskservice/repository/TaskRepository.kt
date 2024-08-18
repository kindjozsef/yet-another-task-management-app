package com.jozsefkind.pet.taskservice.repository

import com.jozsefkind.pet.taskservice.model.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
@Repository
interface TaskRepository: JpaRepository<Task, Long>{



}