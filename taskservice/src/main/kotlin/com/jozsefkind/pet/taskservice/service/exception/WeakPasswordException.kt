package com.jozsefkind.pet.taskservice.service.exception

class WeakPasswordException: ValidationException(
    "The password is not complex enough. It must be at least 8 characters long, contain at least one digit, and one uppercase letter."
)