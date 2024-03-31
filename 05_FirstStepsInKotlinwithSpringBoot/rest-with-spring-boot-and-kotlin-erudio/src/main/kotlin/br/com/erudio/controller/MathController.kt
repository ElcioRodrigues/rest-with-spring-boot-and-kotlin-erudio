package br.com.erudio.controller

import br.com.erudio.converters.NumberConverter
import br.com.erudio.exceptions.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController {



    @Throws(Exception::class)
    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?): Double {

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value")
        return NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo)
    }

    @Throws(Exception::class)
    @RequestMapping(value = ["/subtraction/{numberOne}/{numberTwo}"])
    fun subtraction(@PathVariable(value="numberOne") numberOne: String?,
                    @PathVariable(value="numberTwo") numberTwo: String?): Double {

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value")
        return NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(numberTwo)
    }

    @Throws(Exception::class)
    @RequestMapping(value = ["/multiplication/{numberOne}/{numberTwo}"])
    fun multiplication(@PathVariable(value="numberOne") numberOne: String?,
                       @PathVariable(value="numberTwo") numberTwo: String?): Double {

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value")
        return NumberConverter.convertToDouble(numberOne) * NumberConverter.convertToDouble(numberTwo)
    }

    @Throws(Exception::class)
    @RequestMapping(value = ["/division/{numberOne}/{numberTwo}"])
    fun division(@PathVariable(value="numberOne") numberOne: String?,
                 @PathVariable(value="numberTwo") numberTwo: String?): Double {

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value")
        return NumberConverter.convertToDouble(numberOne) / NumberConverter.convertToDouble(numberTwo)
    }

    @Throws(Exception::class)
    @RequestMapping(value = ["/mean/{numberOne}/{numberTwo}"])
    fun mean(@PathVariable(value="numberOne") numberOne: String?,
             @PathVariable(value="numberTwo") numberTwo: String?): Double {

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value")
        return (NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo)) / 2
    }

    @Throws(Exception::class)
    @RequestMapping(value = ["/squareRoot/{number}"])
    fun squareRoot(@PathVariable(value="number") number: String?): Double {

        if(!NumberConverter.isNumeric(number) ) throw UnsupportedMathOperationException("Please set a numeric value")
        return (NumberConverter.convertToDouble(number)) / 2
    }

}