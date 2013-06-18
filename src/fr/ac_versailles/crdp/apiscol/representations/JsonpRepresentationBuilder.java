package fr.ac_versailles.crdp.apiscol.representations;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.w3c.dom.Document;

import fr.ac_versailles.crdp.apiscol.CustomMediaType;
import fr.ac_versailles.crdp.apiscol.edit.fileHandling.TransferRegistry;
import fr.ac_versailles.crdp.apiscol.edit.urlHandling.UrlParsingRegistry;
import fr.ac_versailles.crdp.apiscol.utils.XMLUtils;

public class JsonpRepresentationBuilder extends XMLRepresentationBuilder {

	@Override
	public Object getFileTransferRepresentation(Integer fileTransferIdentifier,
			UriInfo uriInfo, TransferRegistry fileTransferRegistry,
			URI contentWebServiceUri) {
		String string = XMLUtils.XMLToString((Document) super
				.getFileTransferRepresentation(fileTransferIdentifier, uriInfo,
						fileTransferRegistry, contentWebServiceUri));
		return new StringBuilder().append("notice(\"")
				.append(string.replaceAll("\"","\\\\\"")).append("\");")
				.toString();
	}

	@Override
	public MediaType getMediaType() {
		return CustomMediaType.JSONP;
	}

	@Override
	public Object getUrlParsingRespresentation(Integer urlParsingId,
			UriInfo uriInfo, UrlParsingRegistry urlParsingRegistry,
			URI contentWebServiceUri) {
		return new StringBuilder()
				.append("notice(\"")
				.append(XMLUtils.XMLToString(
						(Document) super.getUrlParsingRespresentation(
								urlParsingId, uriInfo, urlParsingRegistry,
								contentWebServiceUri)).replaceAll("\"", "\\\""))
				.append("\");").toString();
	}

}
