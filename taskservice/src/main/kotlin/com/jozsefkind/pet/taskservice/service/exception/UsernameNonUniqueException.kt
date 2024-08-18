package com.jozsefkind.pet.taskservice.service.exception

class UsernameNonUniqueException: ValidationException(
    "Username is already used!"
)