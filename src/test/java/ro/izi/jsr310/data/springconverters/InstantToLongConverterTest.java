package ro.izi.jsr310.data.springconverters;

import java.time.Instant;

import org.junit.Assert;
import org.junit.Test;


public class InstantToLongConverterTest {
	private InstantToLongConverter instantToLongConverter = new InstantToLongConverter();
	
	@Test
	public void validInstantConverted(){
		Instant instant = Instant.parse("2007-12-03T10:15:30.00Z");
		Assert.assertEquals(1196676930000L, instantToLongConverter.convert(instant).longValue());
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void maxInstantCannotBeConverted(){
		instantToLongConverter.convert(Instant.MAX);
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void minInstantCannotBeConverted(){
		instantToLongConverter.convert(Instant.MAX);
	}
}
