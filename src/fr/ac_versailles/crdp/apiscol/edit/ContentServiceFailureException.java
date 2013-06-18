package fr.ac_versailles.crdp.apiscol.edit;

import fr.ac_versailles.crdp.apiscol.ApiscolException;

public class ContentServiceFailureException extends ApiscolException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContentServiceFailureException(String message) {
		super(message);
	}
}
