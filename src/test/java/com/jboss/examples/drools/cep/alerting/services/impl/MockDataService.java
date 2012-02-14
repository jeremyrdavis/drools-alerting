package com.jboss.examples.drools.cep.alerting.services.impl;

import com.jboss.examples.drools.cep.alerting.model.Device;
import com.jboss.examples.drools.cep.alerting.services.DataService;

public class MockDataService implements DataService {

	public Device lookupDevice(String arg) {
		
		return new Device(arg, null, null);
	
	}

}
