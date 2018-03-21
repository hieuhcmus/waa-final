package cs545.airline.bean;

import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Named
@RequestScoped
public class FlightBean {
	@Inject
	private FlightService flightService;
	private Flight flight = new Flight();
	private List<Flight> flights;
	private List<Flight> filteredFlights;

	@PostConstruct
	public void init() {
		flights = flightService.findAll();
	}

	public Flight getFlight() {
		return flight;
	}

	public String createFlight() {
		flightService.create(flight);
		return "flightList.xhtml?faces-redirect=true";
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public String editFlightRecord(long id) {
		Flight flight = flightService.findById(id);
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("editFlight", flight);
		return "editFlight.xhtml?faces-redirect=true";
	}

	public String updateFlight(Flight flight) {
		flightService.update(flight);
		return "flightList.xhtml?faces-redirect=true";
	}

	public List<Flight> getFilteredFlights() {
		return filteredFlights;
	}

	public void setFilteredFlights(List<Flight> filteredFlights) {
		this.filteredFlights = filteredFlights;
	}
}
