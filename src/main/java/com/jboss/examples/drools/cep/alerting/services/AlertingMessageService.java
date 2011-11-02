package com.jboss.examples.drools.cep.alerting.services;

import com.jboss.examples.drools.cep.alerting.model.Alert;
import com.jboss.examples.drools.cep.alerting.model.AlertGroup;

/**
 * Messaging service to handle alerts.
 * 
 * @author Jeremy Davis jeremy.davis@redhat.com
 *
 */
public interface AlertingMessageService {
	
	public void sendAlert(Alert alertToSend);

	public void sendAlertGroup(AlertGroup alertGroupToSend);
}
