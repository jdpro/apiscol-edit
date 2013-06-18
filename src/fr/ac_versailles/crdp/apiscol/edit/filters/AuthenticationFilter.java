package fr.ac_versailles.crdp.apiscol.edit.filters;

import java.util.LinkedList;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

public class AuthenticationFilter implements ContainerRequestFilter,
		ContainerResponseFilter {
	@Context
	ServletContext context;
	private static LinkedList<String> nonces = new LinkedList<String>();

	@Override
	public ContainerRequest filter(ContainerRequest request) {
		String method = request.getMethod();
		if (method.equals(HttpMethod.GET)) {
			return request;
		}
		String token = request.getHeaderValue(HttpHeaders.AUTHORIZATION);
		if (!StringUtils.isEmpty(token)) {
			if (nonces.contains(token)) {
				nonces.remove(token);
				return request;
			}

			if (method.equals(HttpMethod.OPTIONS)
					|| method.equals(HttpMethod.POST)) {
				if (DDUserAuthentication.isAuthorized(context, request))

					throw new WebApplicationException(Response
							.status(200)
							.header("Authentification-Info",
									"nextnonce=\"" + getNewNonce() + "\"")
							.build());
			}

		}

		throw new WebApplicationException(Response.status(403)
				.entity("Invalid credentials").build());
	}

	private String getNewNonce() {
		String newNonce = UUID.randomUUID().toString();
		nonces.add(newNonce.toString());
		return newNonce;
	}

	@Override
	public ContainerResponse filter(ContainerRequest request,
			ContainerResponse response) {
		String method = request.getMethod();
		if (method.equals(HttpMethod.GET))
			return response;
		response.getHttpHeaders().putSingle("Authentification-Info",
				"nextnonce=\"" + getNewNonce() + "\"");

		return response;
	}
}
