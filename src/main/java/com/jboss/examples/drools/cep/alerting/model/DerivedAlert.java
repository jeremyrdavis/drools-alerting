package com.jboss.examples.drools.cep.alerting.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class DerivedAlert {

	String atomicAlertIds;
	
	List<Alert> alerts;

	List<String> deviceNames;

	List<String> linkIds;

	List<String> hubHostIds;

	public DerivedAlert() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DerivedAlert(List<String> deviceNames, List<String> linkIds,
			List<String> hubHostIds) {
		super();
		this.deviceNames = deviceNames;
		this.linkIds = linkIds;
		this.hubHostIds = hubHostIds;
	}

	public void addAlert(Alert alertToAdd) {
		getDeviceNames().add(alertToAdd.getDeviceName());
	}

	public boolean containsDevice(String deviceName) {
		// basic sanity checks
		if (deviceName == null)
			return false;
		if ("".equals(deviceName))
			return false;
		if (this.deviceNames == null || this.deviceNames.isEmpty())
			return false;

		// check for existence
		Iterator<String> it = this.deviceNames.iterator();
		while (it.hasNext()) {
			if (deviceName.equals(it.next()))
				return true;
		}
		return false;
	}
	
	public void addAlerts(List<Alert> alertsToAdd){
		if(this.alerts ==  null) this.alerts = new ArrayList<Alert>();
		this.alerts.addAll(alertsToAdd);
	}
	
	public void addNewAlert( Alert alertToAdd ){
		if(this.alerts ==  null) this.alerts = new ArrayList<Alert>();
		this.alerts.add(alertToAdd);
	}

	/**
	 * Returns an empty ArrayList<String> if null.
	 * 
	 * @return List<String> of device names in the derived alert or an empty
	 *         List<String>
	 */
	public List<String> getDeviceNames() {
		if (this.deviceNames == null)
			this.deviceNames = new ArrayList<String>(0);
		return deviceNames;
	}

	public String toString(){
		return new ToStringBuilder(this).append("Atomic Alert Ids", atomicAlertIds).append("Device Name", deviceNames).append("Link Ids", linkIds).append("Hub Host Ids", hubHostIds).toString();
	}
	// --------------------------------------------------------------------------

	public void setDeviceNames(List<String> deviceNames) {
		this.deviceNames = deviceNames;
	}

	public List<String> getLinkIds() {
		return linkIds;
	}

	public void setLinkIds(List<String> linkIds) {
		this.linkIds = linkIds;
	}

	public List<String> getHubHostIds() {
		return hubHostIds;
	}

	public void setHubHostIds(List<String> hubHostIds) {
		this.hubHostIds = hubHostIds;
	}

	public String getAtomicAlertIds() {
		return atomicAlertIds;
	}

	public void setAtomicAlertIds(String atomicAlertIds) {
		this.atomicAlertIds = atomicAlertIds;
	}

	public List<Alert> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<Alert> alerts) {
		this.alerts = alerts;
	}
}
