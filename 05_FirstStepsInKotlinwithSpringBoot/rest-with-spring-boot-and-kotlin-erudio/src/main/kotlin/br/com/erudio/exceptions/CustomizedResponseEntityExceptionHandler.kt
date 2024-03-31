package br.com.erudio.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.*
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.Date
import kotlin.Exception

@ControllerAdvice
@RestController
class CustomizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<ExceptionResponse>{
        val excpetionResponse = ExceptionResponse(Date(), ex.message, request.getDescription(false))

        return  ResponseEntity<ExceptionResponse>(excpetionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(UnsupportedMathOperationException::class)
    fun handleBadRequestExceptions(ex: Exception, request: WebRequest): ResponseEntity<ExceptionResponse>{
        val excpetionResponse = ExceptionResponse(Date(), ex.message, request.getDescription(false))

        return  ResponseEntity<ExceptionResponse>(excpetionResponse, HttpStatus.BAD_REQUEST)
    }

}