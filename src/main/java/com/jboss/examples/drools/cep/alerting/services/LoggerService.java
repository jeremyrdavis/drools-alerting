package com.jboss.examples.drools.cep.alerting.services;

import java.util.Date;

import org.drools.time.SessionClock;

public class LoggerService {

    private SessionClock clock;

    public LoggerService(SessionClock clock) {
        super();
        this.clock = clock;
    }
    
    public void logMessage( String msg ) {
        System.out.println( new Date( clock.getCurrentTime() )+" "+ msg );
    }
}
