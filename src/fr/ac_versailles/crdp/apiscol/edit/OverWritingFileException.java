package fr.ac_versailles.crdp.apiscol.edit;

public class OverWritingFileException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OverWritingFileException(String filename, String resourceId) {
		super(String.format(
				"Trying to ovewrite existing file %s in resource %s", filename,
				resourceId));
	}
}
