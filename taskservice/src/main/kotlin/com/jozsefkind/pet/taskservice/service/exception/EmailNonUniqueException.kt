package com.jozsefkind.pet.taskservice.service.exception

class EmailNonUniqueException(
    private val email: String
): ValidationException(
    "The provided eMail address $email is already in use!"
)