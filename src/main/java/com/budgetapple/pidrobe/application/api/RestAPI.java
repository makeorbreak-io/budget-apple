package com.budgetapple.pidrobe.application.api;

import com.budgetapple.pidrobe.PiDrobe;
import com.budgetapple.pidrobe.core.clothes.Item;
import com.budgetapple.pidrobe.core.services.ItemService;

import javax.ws.rs.*;
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response items() {

        ItemService service = new ItemService();

        return Response
                .status(200)
                .entity(service.getJsonAllItems())
                .build();
    }

    @POST
    @Path("/items/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createItem(Item item) {
        ItemService service = new ItemService();
        service.addNewItem(item);
        return Response
                .status(200)
                .build();
    }

}
