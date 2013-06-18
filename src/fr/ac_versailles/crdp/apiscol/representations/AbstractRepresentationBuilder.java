package fr.ac_versailles.crdp.apiscol.representations;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;


public abstract class AbstractRepresentationBuilder implements
		IEntitiesRepresentationBuilder {

	protected URI getUrlForFileTransfer(UriBuilder uriBuilder, Integer fileTransferIdentifier) {
		return uriBuilder.path("transfer").path(fileTransferIdentifier.toString()).build();
	}
	protected URI getUrlForUrlParsing(UriBuilder uriBuilder, Integer urlParsingIdentifier) {
		return uriBuilder.path("url_parsing").path(urlParsingIdentifier.toString()).build();
	}
}
