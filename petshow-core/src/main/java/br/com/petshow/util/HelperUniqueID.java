package br.com.petshow.util;

import java.util.UUID;

public class HelperUniqueID {
	/**
	 * Gerar um ID unico.
	 * @return
	 */
	public static String get() {
		UUID randomID = UUID.randomUUID();
		return randomID.toString();
	}
}
