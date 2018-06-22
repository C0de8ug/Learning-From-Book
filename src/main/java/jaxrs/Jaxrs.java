package jaxrs;


import org.springframework.stereotype.Service;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Administrator on 2017/1/18.
 */
@Service
@Path("/restaurant")
@Produces(MediaType.APPLICATION_JSON)
public class Jaxrs {

    /*
    * This can annotation with post and get or nothing
    * */
    @Path("/{restaurantId}")
    public String hello(@PathParam("restaurantId") String restaurantId) {
        return restaurantId;
    }
}
