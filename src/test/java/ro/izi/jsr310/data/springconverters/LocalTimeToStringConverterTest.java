package ro.izi.jsr310.data.springconverters;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Test;

public class LocalTimeToStringConverterTest {
	
	private LocalTimeToStringConverter locaTimeToStringConverter = new LocalTimeToStringConverter();
	
	@Test
	public void testConverted(){
		LocalTime localTime = LocalTime.of(10, 5, 6);
		Assert.assertEquals("Time converted in expected format", 
				"10:05:06", locaTimeToStringConverter.convert(localTime));
	}
	
	@Test
	public void testConvertedInCustomFormat(){
		LocalTimeToStringConverter locaTimeToStringConverter = new LocalTimeToStringConverter(DateTimeFormatter.ofPattern("HH:mm"));
		
		LocalTime localTime = LocalTime.of(10, 5);
		Assert.assertEquals("Time converted in expected format", 
				"10:05", locaTimeToStringConverter.convert(localTime));
	}
}
