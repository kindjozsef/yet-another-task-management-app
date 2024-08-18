package com.jozsefkind.pet.taskservice

import com.jozsefkind.pet.taskservice.repository.TaskRepository
import com.jozsefkind.pet.taskservice.repository.UserRepository
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles(value = ["componenttest"])
class BaseComponentTest {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var taskRepository: TaskRepository


    @BeforeEach
    fun setUp() {
        taskRepository.deleteAll()
        userRepository.deleteAll()
    }
}