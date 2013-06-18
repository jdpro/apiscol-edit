package fr.ac_versailles.crdp.apiscol.edit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.core.Application;

import com.sun.jersey.spi.container.servlet.ServletContainer;

import fr.ac_versailles.crdp.apiscol.edit.sync.SyncService;

public class ApiscolEdit extends ServletContainer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApiscolEdit() {

	}

	public ApiscolEdit(Class<? extends Application> appClass) {
		super(appClass);
	}

	public ApiscolEdit(Application app) {
		super(app);
	}

	@PreDestroy
	public void deinitialize() {
		SyncService.stopExecutors();
	}

	@PostConstruct
	public void initialize() {
		// nothing at this time
	}
}
