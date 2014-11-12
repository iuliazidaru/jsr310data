package ro.izi.jsr310.data.springconverters;

import java.time.Instant;




import org.junit.Assert;
import org.junit.Test;


public class LongToInstantConverterTest {
	
	private LongToInstantConverter longToInstantConverter = new LongToInstantConverter();
	
	@Test
	public void convertValidTimestamp(){
		Instant instant = longToInstantConverter.convert(Long.valueOf(1415697875162L));
		Assert.assertEquals(1415697875162L, instant.toEpochMilli());
	}
}
