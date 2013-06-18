package fr.ac_versailles.crdp.apiscol.edit.fileHandling;

public enum UrlParsingStates {
	initiated("initiated"), aborted("aborted"), pending(
			"pending"), unknown("unknown"), done("done");
	private String value;

	private UrlParsingStates(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

}
