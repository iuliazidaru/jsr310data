package ro.izi.jsr310.data.springconverters;

import java.time.Instant;

import org.springframework.core.convert.converter.Converter;


/**
 * Converts Instant to Long.
 * 
 * @author izidaru
 *
 */
public class InstantToLongConverter implements Converter<Instant, Long>{
	
	private static final Instant MAX_CONVERTIBLE_INSTANT = Instant.ofEpochMilli(Long.MAX_VALUE); 
	private static final Instant MIN_CONVERTIBLE_INSTANT = Instant.ofEpochMilli(Long.MIN_VALUE);
	
	@Override
	public Long convert(Instant source) {
		if(source.isBefore(MIN_CONVERTIBLE_INSTANT) || source.isAfter(MAX_CONVERTIBLE_INSTANT)){
			throw new IllegalArgumentException();
		}
		return source.toEpochMilli();
	}

}
