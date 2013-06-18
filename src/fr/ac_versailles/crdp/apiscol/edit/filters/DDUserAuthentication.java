package fr.ac_versailles.crdp.apiscol.edit.filters;

import javax.servlet.ServletContext;
import javax.ws.rs.core.HttpHeaders;

import com.sun.jersey.spi.container.ContainerRequest;

import fr.ac_versailles.crdp.apiscol.ParametersKeys;
import fr.ac_versailles.crdp.apiscol.edit.ResourceEditionAPI;

public class DDUserAuthentication {

	public static boolean isAuthorized(ServletContext context,
			ContainerRequest request) {
		String user = ResourceEditionAPI.getProperty(ParametersKeys.user, context);
		String password = ResourceEditionAPI.getProperty(ParametersKeys.password
				, context);
		return (request.getHeaderValue(HttpHeaders.AUTHORIZATION).equals(user
				+ password));
	}
}
