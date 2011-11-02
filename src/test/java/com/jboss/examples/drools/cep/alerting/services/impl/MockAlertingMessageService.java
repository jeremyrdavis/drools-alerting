package com.jboss.examples.drools.cep.alerting.services.impl;

import java.util.ArrayList;
import java.util.Collection;

import com.jboss.examples.drools.cep.alerting.model.Alert;
import com.jboss.examples.drools.cep.alerting.model.AlertGroup;
import com.jboss.examples.drools.cep.alerting.services.AlertingMessageService;

/**
 * Mocks out the AlertingMessageService and holds the Alerts/AlertGroups sent so
 * that the unit tests can verify.
 * 
 * @author Jeremy Davis jeremy.davis@redhat.com
 * @see {@link AlertingMessageService}, {@link Alert}, {@link AlertGroup}
 */
public class MockAlertingMessageService implements AlertingMessageService {

	/**
	 * Placeholder for the Alert objects passed in to the AlertingMessageService.
	 * 
	 */
	ArrayList<Alert> alerts;

	/**
	 * Placeholder for the AlertGroup objects passed in to the AlertingMessageService.
	 */
	ArrayList<AlertGroup> alertGroups;

	public void sendAlert(Alert alertToSend) {
		if (this.alerts == null)
			this.alerts = new ArrayList<Alert>();
		this.alerts.add(alertToSend);
	}

	public void sendAlertGroup(AlertGroup alertGroupToSend) {
		if (this.alertGroups == null)
			this.alertGroups = new ArrayList<AlertGroup>();
		this.alertGroups.add(alertGroupToSend);
	}

	// -------------------------------------------------------------------------
	// generated getters and setters
	// -------------------------------------------------------------------------
	public ArrayList<Alert> getAlerts() {
		return alerts;
	}

	public void setAlerts(ArrayList<Alert> alerts) {
		this.alerts = alerts;
	}

	public ArrayList<AlertGroup> getAlertGroups() {
		return alertGroups;
	}

	public void setAlertGroups(ArrayList<AlertGroup> alertGroups) {
		this.alertGroups = alertGroups;
	}

}
