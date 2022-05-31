package com.io.tedtalk.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class TedtalkErrorHandler {
    @ExceptionHandler(CommonResourceNotFoundException::class)
    fun handleCommonResourceNotFoundException(
        servletRequest: HttpServletRequest,
        exception: Exception
    ): ResponseEntity<String> {
        return ResponseEntity("Tedtalk not found", HttpStatus.NOT_FOUND)
    }
}