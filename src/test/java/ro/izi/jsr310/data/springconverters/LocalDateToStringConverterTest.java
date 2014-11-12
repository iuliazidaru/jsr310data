package ro.izi.jsr310.data.springconverters;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class LocalDateToStringConverterTest {

	private LocalDateToStringConverter localDateToStringConverter = new LocalDateToStringConverter();
	
	@Test
	public void testConverted(){
		LocalDate localDate = LocalDate.of(2014, 11, 13);
		Assert.assertEquals("Date converted in expected format", 
				"2014-11-13", localDateToStringConverter.convert(localDate));
	}
}
