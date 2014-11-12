package ro.izi.jsr310.data.springconverters;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Test;

public class StringToLocalTimeConverterTest {
	
	private StringToLocalTimeConverter stringToLocalTimeConverter = new StringToLocalTimeConverter();
	
	
	@Test
	public void testConverted(){
		LocalTime localTime = LocalTime.of(10, 5, 6);
		Assert.assertEquals("Time converted in expected format", 
				localTime, stringToLocalTimeConverter.convert("10:05:06"));
	}
	
	@Test
	public void testConvertedInCustomFormat(){
		StringToLocalTimeConverter stringToLocalTimeConverter = new StringToLocalTimeConverter(DateTimeFormatter.ofPattern("HH:mm"));
		
		LocalTime localTime = LocalTime.of(10, 5);
		Assert.assertEquals("Time converted in expected format", 
				localTime, stringToLocalTimeConverter.convert("10:05"));
	}
	
}
