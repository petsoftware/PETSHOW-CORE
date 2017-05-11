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

public class NotificationSend {

	public static final Logger logger = Logger.getLogger(EntryPoint.class.getName());
	
	
	public static void sendNotificationAndroid(String toRegId,String mensagem) {
		final String fcmProjectSenderId =com.wedevol.xmpp.util.Util.FCM_PROJECT_SENDER_ID;
		final String fcmServerKey = com.wedevol.xmpp.util.Util.FCM_SERVER_KEY;
		

		CcsClient ccsClient = CcsClient.prepareClient(fcmProjectSenderId, fcmServerKey, true);

		try {
			
				ccsClient.connect();
			
		} catch (XMPPException | InterruptedException | SmackException | IOException e) {
			e.printStackTrace();
		}

		// Send a sample downstream message to a device
		String messageId = Util.getUniqueMessageId();
		Map<String, String> dataPayload = new HashMap<String, String>();
		dataPayload.put(Util.PAYLOAD_ATTRIBUTE_MESSAGE, mensagem);
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
