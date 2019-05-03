package br.com.luan;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CalculatorController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        checkNumericValues(numberOne, numberTwo);
        return  converToDouble(numberOne) + converToDouble(numberTwo);
    }

    @RequestMapping(value="/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        checkNumericValues(numberOne, numberTwo);
        return  converToDouble(numberOne) - converToDouble(numberTwo);
    }

    @RequestMapping(value="/mul/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mul(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        checkNumericValues(numberOne, numberTwo);
        return  converToDouble(numberOne) * converToDouble(numberTwo);
    }

    private void checkNumericValues(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value.");
        }
    }


    private Double converToDouble(String number) {
        return (isNumeric(number))? Double.parseDouble(number) : 0D;
    }

    private boolean isNumeric(String number) {
        return number != null && number.matches("[-+]?\\d*\\.?\\d+");
    }
}
