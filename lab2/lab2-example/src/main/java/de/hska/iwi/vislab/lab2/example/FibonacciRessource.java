package de.hska.iwi.vislab.lab2.example;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("Fibonacci")
public class FibonacciRessource {

    @Inject
    FibonacciService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public int getFibonacci(@DefaultValue("0") @QueryParam("number") int number){

        return service.getFibonacci(number);

    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public int getNextFibonacci(){
        return service.getNextFibonacci();
    }

    @DELETE
    public void resetFibonacci(){
        service.deleteFibonacci();
    }
}
