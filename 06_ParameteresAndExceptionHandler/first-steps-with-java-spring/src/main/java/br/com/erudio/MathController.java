package br.com.erudio;

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
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return covertToDouble(numberOne) + covertToDouble(numberTwo);
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return covertToDouble(numberOne) - covertToDouble(numberTwo);
    }

    @RequestMapping(value = "/multi/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multi(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return covertToDouble(numberOne) * covertToDouble(numberTwo);
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return covertToDouble(numberOne) / covertToDouble(numberTwo);
    }

    @RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return (covertToDouble(numberOne) + covertToDouble(numberTwo)) / 2;
    }

    @RequestMapping(value = "/square/{numberOne}", method = RequestMethod.GET)
    public Double average(@PathVariable("numberOne") String numberOne){
        if(!isNumeric(numberOne)){
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return Math.sqrt(covertToDouble(numberOne));
    }

    public static Double covertToDouble(String strNumber) {
        if (strNumber == null) return 0d; 
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 1.0d;
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null) return false; 
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
