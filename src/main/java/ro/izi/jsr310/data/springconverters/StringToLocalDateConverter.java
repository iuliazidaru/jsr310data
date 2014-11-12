package ro.izi.jsr310.data.springconverters;

import java.time.LocalDate;

import org.springframework.core.convert.converter.Converter;

/**
 * Converts String to LocalDate.
 * 
 * @author izidaru
 *
 */
public class StringToLocalDateConverter implements Converter<String, LocalDate>{

	 @Override
	    public LocalDate convert(String source) {
	        return LocalDate.parse(source);
	    }
}
