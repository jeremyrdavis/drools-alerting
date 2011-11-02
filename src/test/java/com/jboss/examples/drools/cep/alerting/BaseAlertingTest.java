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

/**
 * Base test class for common functionality.
 * 
 * @author Jeremy Davis jeremy.davis@redhat.com
 * 
 */
public class BaseAlertingTest {

	/**
	 * slf4j Logger
	 */
	protected Logger logger;
	
	/**
	 * Name for the WorkingMemoryFileLogger to use when logging events.  Defaults to "defaultWorkingMemoryFileLog"
	 */
	protected static String workingMemoryFileLogName = "defaultWorkingMemoryFileLog";

	/**
	 * String[] to store all of the Drools rule files that we will use.
	 */
	protected static String[] drlFiles;

	/**
	 * String[] to store all of the DroolsFlow files that we will use.
	 */
	protected static String[] flowFiles;

	/**
	 * For logging the WorkingMemory while executing a test.
	 * 
	 * @see WorkingMemoryFileLogger
	 */
	protected WorkingMemoryFileLogger droolsLogger;

	
	/**
	 * Creates and returns a StatefulKnowledgeSession.
	 * 
	 * @return StatefulKnowledgeSession
	 * @throws Exception
	 */
	protected StatefulKnowledgeSession createStatefulKnowledgeSession()
			throws Exception {
		KnowledgeBase kbase = readKnowledgeBase();
		assertNotNull("KnowledgeBase should not be null", kbase);

		// create configuration to use a psuedo clock
		KnowledgeSessionConfiguration cfg = KnowledgeBaseFactory
				.newKnowledgeSessionConfiguration();
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession(
				cfg, null);

		assertNotNull("KnowledgeSession should not be null", ksession);
		droolsLogger = new WorkingMemoryFileLogger(ksession);
		droolsLogger.setFileName(workingMemoryFileLogName);
		return ksession;
	}

	protected final StatefulKnowledgeSession createKnowledgeSessionWithClock()
			throws Exception {
		// create the KnowledgeBase
		KnowledgeBase kbase = readKnowledgeBase();
		KnowledgeSessionConfiguration conf = KnowledgeBaseFactory
				.newKnowledgeSessionConfiguration();
		conf.setOption(ClockTypeOption.get(ClockType.PSEUDO_CLOCK.getId()));
		final StatefulKnowledgeSession ksession = kbase
				.newStatefulKnowledgeSession(conf, null);
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
		if (flowFiles != null && 1 >= flowFiles.length) {
			for (int i = 0; i < flowFiles.length; i++)
				kbuilder.add(
						ResourceFactory.newClassPathResource(flowFiles[i]),
						ResourceType.DRF);
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
