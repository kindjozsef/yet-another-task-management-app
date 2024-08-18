package com.jozsefkind.pet.taskservice.service.validation

import com.jozsefkind.pet.taskservice.repository.UserRepository
import com.jozsefkind.pet.taskservice.service.exception.EmailNonUniqueException
import com.jozsefkind.pet.taskservice.service.exception.EmailNotValidException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmailValidationService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun validateEmail(email: String) {
        checkEmail(email)
        checkEmailUniqueness(email)
    }

    private fun checkEmail(email: String) {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
        if(!emailRegex.matches(email)) {
            throw EmailNotValidException(email)
        }
    }

    private fun checkEmailUniqueness(email: String) {
        userRepository.findUserByEmail(email).ifPresent {
            throw EmailNonUniqueException(email)
        }
    }

}