package com.jboss.examples.drools.cep.alerting.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class DeviceAlert implements Serializable{

	private static final long serialVersionUID = -6083388157960234464L;

	protected Integer id;

	protected Date time;
	
	protected Device device;

	protected String deviceName;

	protected String interfaceName;

	protected AlertStatus status;

	public DeviceAlert() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeviceAlert(Integer id, Date time, String deviceName, String interfaceName,
			AlertStatus status ) {
		super();
		this.id = id;
		this.time = time;
		this.deviceName = deviceName;
		this.interfaceName = interfaceName;
		this.status = status;
	}

	/**
	 * Constructor for use with a RawAlert and a Device.
	 * 
	 * @param rawAlert
	 */
	public DeviceAlert(RawAlert rawAlert, Device deviceToSet) {
		this.id = rawAlert.getId();
		this.time = rawAlert.getTime();
		this.status = rawAlert.getStatus();
		this.device = deviceToSet;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(98587971, 810426665).append(id).append(time)
				.append(deviceName).append(interfaceName).append(status).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("time", time)
				.append("deviceName", deviceName).toString();
	}

	// --------------------------------------------------------------------------
	// generated
	// --------------------------------------------------------------------------
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
