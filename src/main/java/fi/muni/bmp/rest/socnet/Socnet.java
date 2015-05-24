// License: WTFPL

package fi.muni.bmp.rest.socnet;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author honza
 */
@ApplicationPath("/resources")
@Path("socnet")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Socnet extends Application {
  public Socnet() { }

  @POST
  //@Consumes(MediaType.APPLICATION_JSON)
  @Path("getmsg")
  public Response getmsg() {
    System.out.println("DEBUG Socnet.getmsg()");
    return Response.ok(
      "Hi IFly, you're by far the best company I've ever flew with." +
      " The entertainment lap dance was awesome. Next time I'm definitely" +
      " flying with you as well."
    ).build();
  }

  @POST
  @Consumes(MediaType.TEXT_PLAIN)
  @Path("postmsg")
  public Response postmsg(String msg) {
    System.out.println("DEBUG Socnet.postmsg(\"" + msg + "\")");
    if (msg.length() <= 0)
      return Response.status(Response.Status.NOT_ACCEPTABLE)
              .entity("Empty messages are not allowed.").build();
    return Response.ok().build();
  }
}