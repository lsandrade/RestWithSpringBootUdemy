package br.com.luan;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CalculatorController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        checkNumericValues(numberOne, numberTwo, false, false);
        return converToDouble(numberOne) + converToDouble(numberTwo);
    }

    @RequestMapping(value="/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        checkNumericValues(numberOne, numberTwo, false, false);
        return converToDouble(numberOne) - converToDouble(numberTwo);
    }

    @RequestMapping(value="/mul/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mul(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        checkNumericValues(numberOne, numberTwo, false, false);
        return converToDouble(numberOne) * converToDouble(numberTwo);
    }

    @RequestMapping(value="/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        checkNumericValues(numberOne, numberTwo, true, false);
        return converToDouble(numberOne) / converToDouble(numberTwo);
    }

    @RequestMapping(value="/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        checkNumericValues(numberOne, numberTwo, false, false);
        return (converToDouble(numberOne) + converToDouble(numberTwo))/2;
    }

    @RequestMapping(value="/sqrt/{numberOne}", method = RequestMethod.GET)
    public Double sqrt(@PathVariable("numberOne") String numberOne) throws Exception {
        checkNumericValues(numberOne, "0", false, true);
        return Math.sqrt(converToDouble(numberOne));
    }

    private void checkNumericValues(String numberOne, String numberTwo, boolean isDivision, boolean isSquareroot) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value.");
        }

        if (isDivision && converToDouble(numberTwo) == 0D) {
            throw new Exception("Number two can't be zero.");
        }

        if (isSquareroot && converToDouble(numberOne) < 0) {
            throw new Exception("Number can't be less than zero.");
        }
    }


    private Double converToDouble(String number) {
        return (isNumeric(number))? Double.parseDouble(number) : 0D;
    }

    private boolean isNumeric(String number) {
        return number != null && number.matches("[-+]?\\d*\\.?\\d+");
    }
}
