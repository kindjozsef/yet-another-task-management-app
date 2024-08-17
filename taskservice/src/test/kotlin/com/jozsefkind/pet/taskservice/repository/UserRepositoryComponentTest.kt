package com.jozsefkind.pet.taskservice.repository

import com.jozsefkind.pet.taskservice.BaseComponentTest
import com.jozsefkind.pet.taskservice.model.User
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class UserRepositoryComponentTest: BaseComponentTest() {

    @Autowired
    lateinit var underTest: UserRepository


    @Test
    fun `test the spring data repository`() {
        // given a user
        val user = User(username="aUsername", email="anEmail", password = "aPassword")

        // when
        val savedUser = underTest.save(user)
        val ret = underTest.findAll()

        // then
        Assertions.assertThat(ret).hasSize(1)
        Assertions.assertThat(ret[0].username).isEqualTo("aUsername")
        Assertions.assertThat(savedUser.id).isNotNull
    }




}