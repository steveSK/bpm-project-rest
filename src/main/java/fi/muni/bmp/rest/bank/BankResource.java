/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.muni.bmp.rest.bank;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author steveSK
 */
@Path("bank")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BankResource {

    private final List<String> validCardNumbers;

    public BankResource() {
        validCardNumbers = new ArrayList<>();
        validCardNumbers.add("123456");
        validCardNumbers.add("143434");
        validCardNumbers.add("143978");
        validCardNumbers.add("887434");
        validCardNumbers.add("189234");
        validCardNumbers.add("668899");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("process_payment")
    public Response processPayement(String cardNumber) {
        if (validCardNumbers.contains(cardNumber)) {
            System.out.println("card number valid "+ cardNumber);
            return Response.ok().build();            
        } else {
            System.out.println("card number not valid " + cardNumber);
            return Response.status(Response.Status.NOT_FOUND).entity("card " + cardNumber + " is not valid").build();           
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("reimburse_money")
    public Response reimburseMoney(String cardNumber) {
            return Response.ok().build();
    }
}
