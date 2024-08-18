package com.jozsefkind.pet.taskservice.service.exception

import java.lang.RuntimeException

open class ValidationException(
    msg: String,
): RuntimeException(msg)