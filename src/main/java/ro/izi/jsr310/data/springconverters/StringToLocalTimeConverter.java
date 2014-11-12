package ro.izi.jsr310.data.springconverters;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;

/**
 * Converts String to LocalTime.
 * @author izidaru
 *
 */
public class StringToLocalTimeConverter implements Converter<String, LocalTime>{
	/**
	 * Formatter used to convert date to String
	 */
	private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
	

	public StringToLocalTimeConverter(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}


	public StringToLocalTimeConverter() {
	}


	@Override
	public LocalTime convert(String source) {
		return LocalTime.parse(source, dateTimeFormatter);
	}

}
