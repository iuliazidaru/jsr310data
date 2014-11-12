package ro.izi.jsr310.data.springconverters;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;

/**
 * COnverts LocalTime to String
 * @author izidaru
 *
 */
public class LocalTimeToStringConverter implements Converter<LocalTime, String>{
	
	private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
	
	public LocalTimeToStringConverter(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}

	public LocalTimeToStringConverter() {
		super();
	}

	@Override
	public String convert(LocalTime source) {
		return source.format(dateTimeFormatter);
	}

}
