package com.jboss.examples.drools.cep.alerting.services.impl;

import java.util.ArrayList;
import java.util.Collection;

import com.jboss.examples.drools.cep.alerting.model.DeviceAlert;
import com.jboss.examples.drools.cep.alerting.model.CompoundAlert;
import com.jboss.examples.drools.cep.alerting.services.AlertingMessageService;

/**
 * Mocks out the AlertingMessageService and holds the Alerts/AlertGroups sent so
 * that the unit tests can verify.
 * 
 * @author Jeremy Davis jeremy.davis@redhat.com
 * @see {@link AlertingMessageService}, {@link DeviceAlert}, {@link CompoundAlert}
 */
public class MockAlertingMessageService implements AlertingMessageService {

	/**
	 * Placeholder for the Alert objects passed in to the AlertingMessageService.
	 * 
	 */
	ArrayList<DeviceAlert> alerts;

	/**
	 * Placeholder for the AlertGroup objects passed in to the AlertingMessageService.
	 */
	ArrayList<CompoundAlert> alertGroups;

	public void sendAlert(DeviceAlert alertToSend) {
		if (this.alerts == null)
			this.alerts = new ArrayList<DeviceAlert>();
		this.alerts.add(alertToSend);
	}

	public void sendAlertGroup(CompoundAlert alertGroupToSend) {
		if (this.alertGroups == null)
			this.alertGroups = new ArrayList<CompoundAlert>();
		this.alertGroups.add(alertGroupToSend);
	}

	// -------------------------------------------------------------------------
	// generated getters and setters
	// -------------------------------------------------------------------------
	public ArrayList<DeviceAlert> getAlerts() {
		return alerts;
	}

	public void setAlerts(ArrayList<DeviceAlert> alerts) {
		this.alerts = alerts;
	}

	public ArrayList<CompoundAlert> getAlertGroups() {
		return alertGroups;
	}

	public void setAlertGroups(ArrayList<CompoundAlert> alertGroups) {
		this.alertGroups = alertGroups;
	}

}
