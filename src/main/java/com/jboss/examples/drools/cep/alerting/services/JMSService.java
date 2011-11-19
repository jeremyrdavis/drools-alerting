package com.jboss.examples.drools.cep.alerting.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jboss.examples.drools.cep.alerting.model.CompoundAlert;
import com.jboss.examples.drools.cep.alerting.model.DeviceAlert;

public class JMSService {
	
	protected Logger logger = LoggerFactory.getLogger(JMSService.class);

	public void sendAlert(DeviceAlert alert){
		logger.debug("send alert for : " + alert);
	}

	public void sendCompoundAlert(CompoundAlert alert){
		logger.debug("sending compound alert for : " + alert);
	}
}
