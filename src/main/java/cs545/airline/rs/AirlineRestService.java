package cs545.airline.rs;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api(value = "airlines", description = "REST API to interact with Airline service")
@Path("airlines")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class AirlineRestService {
	@Inject
	private AirlineService airlineService;

	@GET
	@ApiOperation(value = "Get all Airlines", notes = "Get all the Airlines",
			responseContainer = "List", response = Airline.class)
	public List<Airline> getAllAirlines() {
		return airlineService.findAll();
	}

	@ApiOperation(value = "Get Airline by id", notes = "Get Airline by given id", response = Airline.class)
	@Path("/{id}")
	@GET
	public Airline getAirline(@PathParam("id") long id) {
		return airlineService.findById(id);
	}
}
