package com.jboss.examples.drools.cep.alerting.services;

import com.jboss.examples.drools.cep.alerting.model.DeviceAlert;
import com.jboss.examples.drools.cep.alerting.model.CompoundAlert;

/**
 * Messaging service to handle alerts.
 * 
 * @author Jeremy Davis jeremy.davis@redhat.com
 *
 */
public interface AlertingMessageService {
	
	public void sendAlert(DeviceAlert alertToSend);

	public void sendAlertGroup(CompoundAlert alertGroupToSend);
}
