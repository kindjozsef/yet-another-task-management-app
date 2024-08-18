package com.jozsefkind.pet.taskservice.service.validation

import com.jozsefkind.pet.taskservice.repository.UserRepository
import com.jozsefkind.pet.taskservice.service.exception.UsernameNonUniqueException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsernameValidationService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun validateUsername(username: String) {
        userRepository.findUserByUsername(username).ifPresent {
            throw UsernameNonUniqueException()
        }
    }

}