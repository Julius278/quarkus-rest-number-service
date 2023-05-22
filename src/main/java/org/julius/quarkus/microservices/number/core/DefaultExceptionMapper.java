package org.julius.quarkus.microservices.number.core;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DefaultExceptionMapper implements ExceptionMapper<Exception> {

  @Override
  public Response toResponse(final Exception ex) {
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        .entity(ex.getMessage())
        .build();
  }
}
