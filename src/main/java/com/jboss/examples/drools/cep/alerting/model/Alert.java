package com.jboss.examples.drools.cep.alerting.model;

import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Alert {

	protected String id;

	protected Date time;

	protected String deviceName;

	protected String interfaceName;

	protected AlertStatus status;

	protected Link upstreamLink;

	protected Link downstreamLink;

	public Alert() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alert(String id, Date time, String deviceName, String interfaceName,
			AlertStatus status, Link upstreamLink, Link downstreamLink) {
		super();
		this.id = id;
		this.time = time;
		this.deviceName = deviceName;
		this.interfaceName = interfaceName;
		this.status = status;
		this.upstreamLink = upstreamLink;
		this.downstreamLink = downstreamLink;
	}

	/**
	 * Constructor for use with a SystemAlert.
	 * 
	 * @param systemAlert
	 */
	public Alert(InitialAlert systemAlert) {
		this.id = systemAlert.getId();
		this.time = systemAlert.getTime();
		this.deviceName = systemAlert.getDeviceName();
		this.interfaceName = systemAlert.getInterfaceName();
		this.status = systemAlert.getStatus();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(98587971, 810426665).append(id).append(time)
				.append(deviceName).append(interfaceName).append(status)
				.append(upstreamLink).append(downstreamLink).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("time", time)
				.append("deviceName", deviceName)
				.append("upstreamLink", upstreamLink).toString();
	}

	// --------------------------------------------------------------------------
	// generated
	// --------------------------------------------------------------------------
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

	public Link getUpstreamLink() {
		return upstreamLink;
	}

	public void setUpstreamLink(Link upstreamLink) {
		this.upstreamLink = upstreamLink;
	}

	public Link getDownstreamLink() {
		return downstreamLink;
	}

	public void setDownstreamLink(Link downstreamLink) {
		this.downstreamLink = downstreamLink;
	}

}
