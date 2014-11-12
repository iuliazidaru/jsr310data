package ro.izi.jsr310.data.springconverters;

import java.time.LocalDate;

import org.springframework.core.convert.converter.Converter;

/**
 * Converts LocalDate to String
 * @author izidaru
 *
 */
public class LocalDateToStringConverter implements Converter<LocalDate, String>{

	@Override
    public String convert(LocalDate localDate) {
        return localDate.toString();
    }
}
