package com.jboss.examples.drools.cep.alerting.model;

import java.io.Serializable;

public class Link implements Serializable{

	private static final long serialVersionUID = 7086359566835420893L;

	private int id;
	
	private String upstreamDevice;
	
	private String downstreamDevice;
	
	private String upstreamPort;
	
	private String downstreamPort;

	
	public Link() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Link(int id, String upstreamDevice, String downstreamDevice,
			String upstreamPort, String downstreamPort) {
		super();
		this.id = id;
		this.upstreamDevice = upstreamDevice;
		this.downstreamDevice = downstreamDevice;
		this.upstreamPort = upstreamPort;
		this.downstreamPort = downstreamPort;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUpstreamDevice() {
		return upstreamDevice;
	}


	public void setUpstreamDevice(String upstreamDevice) {
		this.upstreamDevice = upstreamDevice;
	}


	public String getDownstreamDevice() {
		return downstreamDevice;
	}


	public void setDownstreamDevice(String downstreamDevice) {
		this.downstreamDevice = downstreamDevice;
	}


	public String getUpstreamPort() {
		return upstreamPort;
	}


	public void setUpstreamPort(String upstreamPort) {
		this.upstreamPort = upstreamPort;
	}


	public String getDownstreamPort() {
		return downstreamPort;
	}


	public void setDownstreamPort(String downstreamPort) {
		this.downstreamPort = downstreamPort;
	}
}
