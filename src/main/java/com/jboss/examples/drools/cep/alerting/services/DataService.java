package com.jboss.examples.drools.cep.alerting.services;

import com.jboss.examples.drools.cep.alerting.model.Device;

/**
 * Interface for data handling services.
 * 
 * @author Jeremy Davis jeremy.davis@redhat.com
 *
 */
public interface DataService {
	
	public Device lookupDevice(String deviceID);

}
