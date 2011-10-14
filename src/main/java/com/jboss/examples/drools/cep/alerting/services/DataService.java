package com.jboss.examples.drools.cep.alerting.services;

import com.jboss.examples.drools.cep.alerting.model.Link;

public class DataService {

	public Link lookupUpstreamLink(String deviceName){
		return new Link();
	}

	public Link lookupDownstreamLink(String deviceName){
		return new Link();
	}
}
