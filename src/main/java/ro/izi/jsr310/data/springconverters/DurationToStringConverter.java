package ro.izi.jsr310.data.springconverters;

import java.time.Duration;

import org.springframework.core.convert.converter.Converter;

/**
 * Converts Duration to String
 * @author izidaru
 *
 */
public class DurationToStringConverter implements Converter<Duration, String>{

	@Override
	public String convert(Duration source) {
		return source.toString();
	}

}
