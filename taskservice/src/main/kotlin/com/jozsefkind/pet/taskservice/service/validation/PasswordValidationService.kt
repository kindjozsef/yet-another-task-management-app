package com.jozsefkind.pet.taskservice.service.validation

import com.jozsefkind.pet.taskservice.service.exception.WeakPasswordException
import org.springframework.stereotype.Service

@Service
class PasswordValidationService {


    fun validatePassword(password: String) {
        if (password.length < 8 || !password.any { it.isDigit() } || !password.any { it.isUpperCase() }) {
            throw WeakPasswordException()
        }
    }

}