package br.com.petshow.tests.util;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.petmooby.util.DateTimeDiffer;
import br.com.petmooby.util.DateUtil;

public class TestDateUtil {

	@Test
	public void deveCalcularDirencaEntreDatas() {
		DateTimeDiffer result = DateUtil.calculateTime(280);
		assertEquals(0, result.getDay());
		assertEquals(0, result.getHours());
		assertEquals(4L, result.getMinutes());
		assertEquals(40L, result.getSecond());
	}
	
	@Test
	public void deveCalcularDirencaEntreDatas18Min() {
		DateTimeDiffer result = DateUtil.calculateTime(1101);
		assertEquals(0, result.getDay());
		assertEquals(0, result.getHours());
		assertEquals(18L, result.getMinutes());
		assertEquals(21L, result.getSecond());
	}
	
	

}
