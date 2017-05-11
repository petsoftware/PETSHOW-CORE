package com.wedevol.xmpp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;

import com.wedevol.xmpp.bean.CcsOutMessage;
import com.wedevol.xmpp.server.CcsClient;
import com.wedevol.xmpp.server.MessageHelper;
import com.wedevol.xmpp.util.Util;

/**
 * Entry Point class for the XMPP Server in dev mode for debugging and testing purposes
 */
public class EntryPoint {

	public static final Logger logger = Logger.getLogger(EntryPoint.class.getName());

	public static void main(String[] args) throws SmackException, IOException {
		final String fcmProjectSenderId ="759015423404" ;
		final String fcmServerKey = "AAAAsLjYPaw:APA91bFN1e_0lu6_Vjw7d-UME6t9p9fnljj69YRgT62yMlhLqbQfxlgo15dx9FMkNBpkE7mqgWDgnOhR3pGR-svYTLrMRrNbuFdM9eWiWmEPGZDDLaRDcvLCWXpSBRoqoNbfUL-J3J80";
		final String toRegId = "dGg2g61TizM:APA91bEfjxpUxFYL-yguNVsgheYFIiwI5CUfXT4NQbIwypi5EPNxBEEwPtqxUXQc8674EIJRHgKJyxaiJQ8SsozCGrNnEGnsE3NNCi6vWxMEgeULMymTHcgLqIL_rLMFEIdnncvYJDAw";


		CcsClient ccsClient = CcsClient.prepareClient(fcmProjectSenderId, fcmServerKey, true);

		try {
			ccsClient.connect();
		} catch (XMPPException | InterruptedException e) {
			e.printStackTrace();
		}

		// Send a sample downstream message to a device
		String messageId = Util.getUniqueMessageId();
		Map<String, String> dataPayload = new HashMap<String, String>();
		dataPayload.put(Util.PAYLOAD_ATTRIBUTE_MESSAGE, "This is the simple sample message");
		CcsOutMessage message = new CcsOutMessage(toRegId, messageId, dataPayload);
		String jsonRequest = MessageHelper.createJsonOutMessage(message);
		
		ccsClient.send(jsonRequest);

		try {
			CountDownLatch latch = new CountDownLatch(1);
			latch.await();
		} catch (InterruptedException e) {
			logger.log(Level.SEVERE, "An error occurred while latch was waiting.", e);
		}
	}
}
