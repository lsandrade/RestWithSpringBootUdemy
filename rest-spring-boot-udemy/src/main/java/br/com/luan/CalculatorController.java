package br.com.luan;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CalculatorController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        checkNumericValues(numberOne, numberTwo, false);
        return  converToDouble(numberOne) + converToDouble(numberTwo);
    }

    @RequestMapping(value="/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        checkNumericValues(numberOne, numberTwo, false);
        return  converToDouble(numberOne) - converToDouble(numberTwo);
    }

    @RequestMapping(value="/mul/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mul(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        checkNumericValues(numberOne, numberTwo, false);
        return  converToDouble(numberOne) * converToDouble(numberTwo);
    }

    @RequestMapping(value="/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        checkNumericValues(numberOne, numberTwo, true);
        return  converToDouble(numberOne) / converToDouble(numberTwo);
    }

    private void checkNumericValues(String numberOne, String numberTwo, boolean division) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value.");
        }

        if (division && converToDouble(numberTwo) == 0D) {
            throw new Exception("Number two can't be zero.");
        }
    }


    private Double converToDouble(String number) {
        return (isNumeric(number))? Double.parseDouble(number) : 0D;
    }

    private boolean isNumeric(String number) {
        return number != null && number.matches("[-+]?\\d*\\.?\\d+");
    }
}
