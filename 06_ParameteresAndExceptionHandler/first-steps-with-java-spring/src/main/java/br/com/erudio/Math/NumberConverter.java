package br.com.erudio.Math;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

public class NumberConverter {

    public static Double convertToDouble(String value){
        try {
            String number = value.replaceAll(",", ".");
            if(VerifyIfNumberIsNumeric.isNumeric(number)) return Double.parseDouble(number);
            return 0D;
        } catch (NumberFormatException e){
            throw new UnsupportedMathOperationException("Não foi possível realizar a operação matemática");
        }
    }
}
