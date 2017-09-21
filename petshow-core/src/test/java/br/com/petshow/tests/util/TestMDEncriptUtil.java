package br.com.petshow.tests.util;

import org.junit.Test;

import br.com.petshow.util.MD5EncriptUtil;

import static org.junit.Assert.assertTrue;

public class TestMDEncriptUtil {
	
	@Test
	public void encriptData() {
		
		assertTrue(MD5EncriptUtil.toMD5("rafa1>rafa2").equals("d02416e204993355640546daf5c3151b"));
		assertTrue(MD5EncriptUtil.toMD5("Rafa1>Rafa2").equals("699f913d55f0ed15adbc5f78cb3319c4"));
		assertTrue(MD5EncriptUtil.toMD5("RAFA1>RAFA2").equals("d72a314e4b37881fd74b5acbf2d1908e"));
		assertTrue(MD5EncriptUtil.toMD5("ÃãçêẼ$%&*@!)(").equals("ff5e89797112a16f1583bb85a38a58df"));
	}

}
