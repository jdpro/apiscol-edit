package fr.ac_versailles.crdp.apiscol.representations;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import fr.ac_versailles.crdp.apiscol.edit.fileHandling.TransferRegistry;
import fr.ac_versailles.crdp.apiscol.edit.urlHandling.UrlParsingRegistry;

public interface IEntitiesRepresentationBuilder {

	Object getFileTransferRepresentation(Integer fileTransferIdentifier,
			UriInfo uriInfo, TransferRegistry fileTransferRegistry,
			URI uri);

	MediaType getMediaType();

	Object getUrlParsingRespresentation(Integer urlParsingId, UriInfo uriInfo,
			UrlParsingRegistry urlParsingRegistry, URI uri);

}
