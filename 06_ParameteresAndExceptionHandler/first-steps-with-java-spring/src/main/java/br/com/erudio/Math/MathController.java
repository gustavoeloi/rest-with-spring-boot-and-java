package br.com.erudio.Math;

import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    
    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!VerifyIfNumberIsNumeric.isNumeric(numberOne) || !VerifyIfNumberIsNumeric.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return MathCalculator.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if(!VerifyIfNumberIsNumeric.isNumeric(numberOne) || !VerifyIfNumberIsNumeric.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return MathCalculator.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/multi/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multi(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if(!VerifyIfNumberIsNumeric.isNumeric(numberOne) || !VerifyIfNumberIsNumeric.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return MathCalculator.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if(!VerifyIfNumberIsNumeric.isNumeric(numberOne) || !VerifyIfNumberIsNumeric.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return MathCalculator.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if(!VerifyIfNumberIsNumeric.isNumeric(numberOne) || !VerifyIfNumberIsNumeric.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return MathCalculator.avarege(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/square/{numberOne}", method = RequestMethod.GET)
    public Double average(@PathVariable("numberOne") String numberOne){
        if(!VerifyIfNumberIsNumeric.isNumeric(numberOne)){
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return Math.sqrt(NumberConverter.convertToDouble(numberOne));
    }

}
