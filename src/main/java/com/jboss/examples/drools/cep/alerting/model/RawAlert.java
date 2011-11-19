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

	protected Integer id;

	protected Date time;

	protected String deviceId;
	
	protected AlertStatus status;

	public RawAlert(){};
	
	public RawAlert(Integer id, Date time, String deviceId, AlertStatus status) {
		super();
		this.id = id;
		this.time = time;
		this.deviceId = deviceId;
		this.status = status;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(98587971, 810426665).append(id).append(time)
				.append(deviceId).append(status).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("time", time)
				.append("device id", deviceId)
				.append("status", status).toString();
	}

	//--------------------------------------------------------------------------
	//	generated getters and setters
	//--------------------------------------------------------------------------
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

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public AlertStatus getStatus() {
		return status;
	}

	public void setStatus(AlertStatus status) {
		this.status = status;
	}

}
