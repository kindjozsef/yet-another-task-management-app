package com.jozsefkind.pet.taskservice.repository

import com.jozsefkind.pet.taskservice.BaseComponentTest
import com.jozsefkind.pet.taskservice.model.Task
import com.jozsefkind.pet.taskservice.model.TaskStatus
import com.jozsefkind.pet.taskservice.model.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class TaskRepositoryComponentTest: BaseComponentTest() {

    @Test
    fun `taskrepository should save a task`() {
        // given
        val user = User(username = "aUsername", password = "aPassword", email = "anEmail")
        val savedUser = userRepository.save(user)

        val task = Task(description = "a random task", title = "with a title", status = TaskStatus.CREATED, user = savedUser)

        // when
        val savedTask = taskRepository.save(task)

        // then
        assertThat(savedTask.id).isNotNull
    }
}