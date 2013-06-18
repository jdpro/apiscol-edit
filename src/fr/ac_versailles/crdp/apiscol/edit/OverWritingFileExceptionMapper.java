package fr.ac_versailles.crdp.apiscol.edit;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import fr.ac_versailles.crdp.apiscol.edit.OverWritingFileException;

@Provider
public class OverWritingFileExceptionMapper implements
		ExceptionMapper<OverWritingFileException> {

	@Override
	public Response toResponse(OverWritingFileException e) {
		return Response.status(Status.CONFLICT).type(MediaType.TEXT_PLAIN)
				.entity(e.getMessage()).build();
	}
}