package cs545.airline.rs;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api(value = "flights", description = "REST API to interact with Flight service")
@Path("flights")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class FlightRestService {
	@Inject
	private FlightService flightService;

	@GET
	@ApiOperation(value = "Get all Flights", notes = "Get all Flights",
			responseContainer = "List", response = Flight.class)
	public List<Flight> getAllAirports() {
		return flightService.findAll();
	}

	@ApiOperation(value = "Get Flight by id", notes = "Get Flight by given id", response = Flight.class)
	@Path("/{id}")
	@GET
	public Flight getFlight(@PathParam("id") long id) {
		return flightService.findById(id);
	}
}
