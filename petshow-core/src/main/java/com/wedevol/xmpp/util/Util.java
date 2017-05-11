package com.wedevol.xmpp.util;

import java.util.UUID;

/**
 * Util class for constants and generic methods
 */

public class Util {

	// For the GCM connection
	public static final String FCM_SERVER = "fcm-xmpp.googleapis.com";
	public static final int FCM_PORT = 5236;
	public static final String FCM_ELEMENT_NAME = "gcm";
	public static final String FCM_NAMESPACE = "google:mobile:data";
	public static final String FCM_SERVER_CONNECTION = "gcm.googleapis.com";

	// For the processor factory
	public static final String PACKAGE = "com.wedevol";
	public static final String BACKEND_ACTION_REGISTER = PACKAGE + ".REGISTER";
	public static final String BACKEND_ACTION_ECHO = PACKAGE + ".ECHO";
	public static final String BACKEND_ACTION_MESSAGE = PACKAGE + ".MESSAGE";

	// For the app common payload message attributes (android - xmpp server)
	public static final String PAYLOAD_ATTRIBUTE_MESSAGE = "message";
	public static final String PAYLOAD_ATTRIBUTE_ACTION = "action";
	public static final String PAYLOAD_ATTRIBUTE_RECIPIENT = "recipient";
	public static final String PAYLOAD_ATTRIBUTE_ACCOUNT = "account";

	/**
	 * Returns a random message id to uniquely identify a message
	 */
	public static String getUniqueMessageId() {
		// TODO: replace for your own random message ID that the DB generates
		return "m-" + UUID.randomUUID().toString();
	}

	public static final String FCM_PROJECT_SENDER_ID ="759015423404" ;
	public static final String FCM_SERVER_KEY = "AAAAsLjYPaw:APA91bFN1e_0lu6_Vjw7d-UME6t9p9fnljj69YRgT62yMlhLqbQfxlgo15dx9FMkNBpkE7mqgWDgnOhR3pGR-svYTLrMRrNbuFdM9eWiWmEPGZDDLaRDcvLCWXpSBRoqoNbfUL-J3J80";
	
}
