package com.metafour.mpaf.v2;

import java.io.ByteArrayOutputStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.log4j.Logger;

/**
 * This simple SOAPHandler will output the contents of incoming
 * and outgoing messages.
 */
public class SOAPMessageHandler implements SOAPHandler<SOAPMessageContext> {

	private static final Logger logger = Logger.getLogger(SOAPMessageHandler.class);
	
	public Set<QName> getHeaders() {
		return null;
	}

	public boolean handleMessage(SOAPMessageContext smc) {
		logMessage(smc);
		return true;
	}

	public boolean handleFault(SOAPMessageContext smc) {
		logMessage(smc);
		return true;
	}

	// nothing to clean up
	public void close(MessageContext messageContext) {
	}

	/*
	 * Check the MESSAGE_OUTBOUND_PROPERTY in the context to see if this is an
	 * outgoing or incoming message. Write a brief message to the print stream
	 * and output the message. The writeTo() method can throw SOAPException or
	 * IOException
	 */
	private void logMessage(SOAPMessageContext smc) {
		Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		if (outboundProperty.booleanValue()) {
			logger.debug("Outbound message:");
		} else {
			logger.debug("Inbound message:");
		}

		SOAPMessage message = smc.getMessage();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			message.writeTo(baos);
			logger.debug(baos.toString());
		} catch (Exception e) {
			logger.warn("Exception in handler: ", e);
		}
	}
}