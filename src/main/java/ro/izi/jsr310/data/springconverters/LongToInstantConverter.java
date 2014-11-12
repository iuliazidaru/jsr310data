package ro.izi.jsr310.data.springconverters;

import java.time.Instant;

import org.springframework.core.convert.converter.Converter;

/**
 * Converts Long to Instance.
 * @author izidaru
 *
 */
public class LongToInstantConverter implements Converter<Long, Instant>{

	@Override
	public Instant convert(Long source) {
		return  Instant.ofEpochMilli(source);
	}

}
