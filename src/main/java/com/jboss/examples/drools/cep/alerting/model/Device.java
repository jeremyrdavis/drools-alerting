package com.jboss.examples.drools.cep.alerting.model;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Networked devices that are being monitored.
 *  
 * @author Jeremy Davis jeremy.davis@redhat.com
 *
 */
public class Device {
	
	private String serialNumber;
	
	private Device northernNeighbor;
	
	private Device southernNeighbor;
	
	public Device() {
	}

	public Device(String serialNumber, Device northernNeighbor, Device southernNeighbor) {
		super();
		this.serialNumber = serialNumber;
		this.northernNeighbor = northernNeighbor;
		this.southernNeighbor = southernNeighbor;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(98587971, 810426665).append(serialNumber).append(northernNeighbor)
				.append(southernNeighbor).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("serialNumber", serialNumber).append("northern neighbor", northernNeighbor)
				.append("southern neighbor", southernNeighbor).toString();
	}

	//--------------------------------------------------------------------------
	//	generated getters and setters
	//--------------------------------------------------------------------------
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}


	public Device getNorthernNeighbor() {
		return northernNeighbor;
	}

	public void setNorthernNeighbor(Device northernNeighbor) {
		this.northernNeighbor = northernNeighbor;
	}

	public Device getSouthernNeighbor() {
		return southernNeighbor;
	}

	public void setSouthernNeighbor(Device southernNeighbor) {
		this.southernNeighbor = southernNeighbor;
	}
	
}
