package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import org.jboss.logging.Logger;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class Example {
	private static final Logger LOG = Logger.getLogger(Example.class);
	private final MyConfig myConfig;

	@Inject
	public Example(MyConfig myConfig) {
		this.myConfig = myConfig;
	}

	void onStart(@Observes StartupEvent startupEvent) {
		LOG.info("Hello, World!");
		myConfig.global().user().name()
				.ifPresent(name -> LOG.infof("Hello, %s!", myConfig.global().user().name()));
	}

}
