package com.jboss.examples.drools.cep.alerting;

import static org.junit.Assert.assertNotNull;

import org.drools.ClockType;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.audit.WorkingMemoryFileLogger;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.conf.EventProcessingOption;
import org.drools.io.ResourceFactory;
import org.drools.runtime.KnowledgeSessionConfiguration;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.conf.ClockTypeOption;
import org.slf4j.Logger;

public class BaseAlertingTest {
	
	protected Logger logger;
	
	protected static String[] drlFiles;
	
	protected static String[] flowFiles;

	protected WorkingMemoryFileLogger droolsLogger;
	
	protected StatefulKnowledgeSession createKnowledgeSession()
			throws Exception {
		KnowledgeBase kbase = readKnowledgeBase();
		assertNotNull("KnowledgeBase should not be null", kbase);
		
		//create configuration to use a psuedo clock
		KnowledgeSessionConfiguration cfg = KnowledgeBaseFactory.newKnowledgeSessionConfiguration();
		cfg.setOption(ClockTypeOption.get(ClockType.PSEUDO_CLOCK.getId()));
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession(cfg, null);

		assertNotNull("KnowledgeSession should not be null", ksession);
		droolsLogger = new WorkingMemoryFileLogger(ksession);
		droolsLogger.setFileName("alertFlowRulesTests");
		return ksession;
	}

	protected static KnowledgeBase readKnowledgeBase() throws Exception {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		
		// add .drl files
		for (int i = 0; i < drlFiles.length; i++) {
			kbuilder.add(ResourceFactory.newClassPathResource(drlFiles[i]),
					ResourceType.DRL);
		}
		
		// if we have ruleflow files add them
		if( flowFiles != null && 1 >= flowFiles.length){
			for( int i = 0; i < flowFiles.length; i++ )
				kbuilder.add(ResourceFactory.newClassPathResource(flowFiles[i]), ResourceType.DRF);
		}
		
		// check to see if we have any errors before continuing
		KnowledgeBuilderErrors errors = kbuilder.getErrors();
		if (errors.size() > 0) {
			for (KnowledgeBuilderError error : errors) {
				System.err.println(error);
			}
			throw new IllegalArgumentException("Could not parse knowledge.");
		}
		// set to streaming
		KnowledgeBaseConfiguration kbCfg = KnowledgeBaseFactory
				.newKnowledgeBaseConfiguration();
		kbCfg.setOption(EventProcessingOption.STREAM);
		
		// create the KnowledgeBase and add packages
		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase(kbCfg);
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

		return kbase;
	}

}
