package fr.ac_versailles.crdp.apiscol.representations;

import javax.servlet.ServletContext;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;

import fr.ac_versailles.crdp.apiscol.CustomMediaType;

public class EntitiesRepresentationBuilderFactory {

	public static IEntitiesRepresentationBuilder getRepresentationBuilder(
			String requestedFormat, ServletContext context) {
		if (StringUtils.equals(requestedFormat, MediaType.APPLICATION_XML)
				|| StringUtils.equals(requestedFormat,
						MediaType.APPLICATION_ATOM_XML)
				|| StringUtils.equals(requestedFormat,
						MediaType.MULTIPART_FORM_DATA)) {
			return new XMLRepresentationBuilder();
		}
		if (StringUtils.equals(requestedFormat,
				CustomMediaType.JSONP.toString())) {
			return new JsonpRepresentationBuilder();
		}
		return new XMLRepresentationBuilder();
	}

}
