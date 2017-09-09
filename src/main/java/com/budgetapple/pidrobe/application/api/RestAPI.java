package com.budgetapple.pidrobe.application.api;

import com.budgetapple.pidrobe.core.services.ItemService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Luis on 09/09/2017.
 * @project pidrobe
 */
@Path("/api")
public class RestAPI {

        @GET
        @Path("/items")
        @Produces(MediaType.TEXT_PLAIN)
        public Response items(){

            ItemService service = new ItemService();

            return Response
                    .status(200)
                    .entity(service.getJsonAllItems())
                    .build();
        }

}
