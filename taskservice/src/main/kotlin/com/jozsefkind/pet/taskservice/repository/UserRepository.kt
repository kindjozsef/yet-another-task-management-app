package com.jozsefkind.pet.taskservice.repository

import com.jozsefkind.pet.taskservice.model.User
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
@Transactional
interface UserRepository : JpaRepository<User, Long>{
}