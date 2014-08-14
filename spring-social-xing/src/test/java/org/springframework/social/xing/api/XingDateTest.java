package org.springframework.social.xing.api;

import static org.junit.Assert.*;

import org.junit.Test;

public class XingDateTest {

	@Test
	public void testDifferentDateFormats() {

		{
			XingDate date = new XingDate("2010-01");
			assertEquals(Integer.valueOf(2010), date.getYear());
			assertEquals(Integer.valueOf(1), date.getMonth());
		}

		{
			XingDate date = new XingDate("2007");
			assertEquals(Integer.valueOf(2007), date.getYear());
			assertNull(date.getMonth());
		}

		{
			XingDate date = new XingDate("");
			assertNull(date.getYear());
			assertNull(date.getMonth());
		}

		{
			XingDate date = new XingDate(null);
			assertNull(date.getYear());
			assertNull(date.getMonth());
		}
	}

}
