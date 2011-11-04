package com.jboss.examples.drools.cep.alerting.model;

import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The basic Alert that comes from the external alerting system.
 * 
 * @author Jeremy Davis jeremy.davis@redhat.com
 *
 */
public class RawAlert {

	protected String id;

	protected Date time;

	protected String deviceName;

	protected String interfaceName;

	protected AlertStatus status;

	public RawAlert(String idToSet, Date timeToSet, String deviceNameToSet,
			String interfaceNameToSet, AlertStatus statusToSet) {
		this.id = idToSet;
		this.time = timeToSet;
		this.deviceName = deviceNameToSet;
		this.interfaceName = interfaceNameToSet;
		this.status = statusToSet;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(98587971, 810426665).append(id).append(time)
				.append(deviceName).append(interfaceName).append(status).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("time", time)
				.append("deviceName", deviceName)
				.append("interfaceName", interfaceName)
				.append("status", status).toString();
	}

	//--------------------------------------------------------------------------
	//	generated getters and setters
	//--------------------------------------------------------------------------
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public AlertStatus getStatus() {
		return status;
	}

	public void setStatus(AlertStatus status) {
		this.status = status;
	}
	
}
