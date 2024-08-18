package com.jozsefkind.pet.taskservice.repository

import com.jozsefkind.pet.taskservice.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, Long>{

    fun findUserByEmail(email: String): Optional<User>

    fun findUserByUsername(username: String): Optional<User>


    @Query("DELETE FROM Task t WHERE t.user.id = :userId")
    @Modifying
    fun deleteTaskByUserId(userId: Long)

}