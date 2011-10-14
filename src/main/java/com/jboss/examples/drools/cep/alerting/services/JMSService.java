package com.jboss.examples.drools.cep.alerting.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jboss.examples.drools.cep.alerting.model.Alert;
import com.jboss.examples.drools.cep.alerting.model.DerivedAlert;

public class JMSService {
	
	protected Logger logger = LoggerFactory.getLogger(JMSService.class);

	public void sendAlert(Alert alert){
		logger.debug("send alert for : " + alert);
	}

	public void sendDerivedAlert(DerivedAlert alert){
		logger.debug("sending derived alert for : " + alert);
	}
}
