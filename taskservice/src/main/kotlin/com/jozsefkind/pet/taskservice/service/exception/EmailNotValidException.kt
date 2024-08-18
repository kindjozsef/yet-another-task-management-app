package com.jozsefkind.pet.taskservice.service.exception

class EmailNotValidException(
    private val email: String
): ValidationException(
    "The provided eMail address: $email is not valid!"
)