package ro.izi.jsr310.data.springconverters;

import java.time.Duration;

import org.springframework.core.convert.converter.Converter;

/**
 * Converts String to Duration.
 * 
 * @author izidaru
 *
 */
public class StringToDurationConverter implements Converter<String, Duration>{

	@Override
	public Duration convert(String source) {
		return Duration.parse(source);
	}

}
