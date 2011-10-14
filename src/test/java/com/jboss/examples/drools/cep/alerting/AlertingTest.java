package com.jboss.examples.drools.cep.alerting;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.drools.ClockType;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.KnowledgeSessionConfiguration;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.conf.ClockTypeOption;
import org.drools.time.SessionPseudoClock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jboss.examples.drools.cep.alerting.model.AlertStatus;
import com.jboss.examples.drools.cep.alerting.model.InitialAlert;
import com.jboss.examples.drools.cep.alerting.services.LoggerService;

public class AlertingTest extends BaseAlertingTest{

	@Before
	public void setUp() throws Exception {
		drlFiles = new String[] { "AlertingRules.drl" };
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testAlertingRules(){
        KnowledgeRuntimeLogger logger = null;
        try {
            // load up the knowledge base
            KnowledgeBase kbase = readKnowledgeBase();
            KnowledgeSessionConfiguration conf = KnowledgeBaseFactory.newKnowledgeSessionConfiguration();
            conf.setOption( ClockTypeOption.get( ClockType.PSEUDO_CLOCK.getId() ) );
            final StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession( conf, null );
            SessionPseudoClock clock = ksession.getSessionClock();
            ksession.setGlobal( "logger", new LoggerService( clock ) );
            logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
            // go !
            
            long currentTime = new Date().getTime();
            clock.advanceTime( currentTime, TimeUnit.MILLISECONDS ); // set clock to current timestamp
            
            InitialAlert[] sa = new InitialAlert[] {
                new InitialAlert( "1", new Date( currentTime + 10000 ), "device1", "interface1", AlertStatus.ACTIVE ),
                new InitialAlert( "2", new Date( currentTime + 50000 ), "device1", "interface1", AlertStatus.ACTIVE ),
                new InitialAlert( "3", new Date( currentTime + 90000 ), "device1", "interface1", AlertStatus.ACTIVE ),
                new InitialAlert( "4", new Date( currentTime + 150000 ), "device1", "interface1", AlertStatus.ACTIVE ),
                new InitialAlert( "5", new Date( currentTime + 170000 ), "device1", "interface1", AlertStatus.ACTIVE )
            };
            
            for( int i = 0; i < sa.length; i++ ) {
                clock.advanceTime( sa[i].getTime().getTime() - clock.getCurrentTime(), TimeUnit.MILLISECONDS );
                ksession.insert( sa[i] );
                ksession.fireAllRules();
            }
            
            clock.advanceTime( 100, TimeUnit.SECONDS );
            ksession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            if( logger != null ) logger.close();
        }
	}
}
