package com.jozsefkind.pet.taskservice.service

import com.jozsefkind.pet.taskservice.model.User
import com.jozsefkind.pet.taskservice.repository.UserRepository
import com.jozsefkind.pet.taskservice.service.exception.ValidationException
import com.jozsefkind.pet.taskservice.service.validation.EmailValidationService
import com.jozsefkind.pet.taskservice.service.validation.PasswordValidationService
import com.jozsefkind.pet.taskservice.service.validation.UsernameValidationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var emailValidationService: EmailValidationService

    @Autowired
    lateinit var passwordValidationService: PasswordValidationService

    @Autowired
    lateinit var usernameValidationService: UsernameValidationService

    private val bCryptPasswordEncoder = BCryptPasswordEncoder()

    fun registerUser(user: User): User {
        passwordValidationService.validatePassword(user.password)
        user.password = bCryptPasswordEncoder.encode(user.password)

        emailValidationService.validateEmail(user.email)
        usernameValidationService.validateUsername(user.username)

        //TODO: log

        return userRepository.save(user)
    }

    fun updateUser(user: User): User {
        passwordValidationService.validatePassword(user.password)
        user.password = bCryptPasswordEncoder.encode(user.password)
        emailValidationService.validateEmail(user.email)

        val userFromDB = userRepository.findById(user.id!!).get()

        if(userFromDB.username != user.username) {
            throw ValidationException("Username can not be modified!")
        }

        // TODO: log
        return userRepository.save(user)
    }

    fun deleteUser(userId: Long) {
        // TODO: log
        userRepository.deleteTaskByUserId(userId)
        userRepository.deleteById(userId)
    }

    fun getUserById(userId: Long): Optional<User> {
        return userRepository.findById(userId)
    }

}