package fr.ac_versailles.crdp.apiscol.edit.exceptionMappers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import fr.ac_versailles.crdp.apiscol.edit.UnknownMetadataException;

@Provider
public class UnknownMetadataExceptionMapper implements
		ExceptionMapper<UnknownMetadataException> {
	@Override
	public Response toResponse(UnknownMetadataException e) {
		return Response.status(Status.NOT_FOUND)
				.type(MediaType.APPLICATION_XML).entity(e.getXMLMessage())
				.build();
	}
}