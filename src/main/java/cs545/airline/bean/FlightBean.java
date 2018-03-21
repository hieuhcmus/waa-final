package cs545.airline.bean;

import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirplaneService;
import cs545.airline.service.AirportService;
import cs545.airline.service.FlightService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Named
@RequestScoped
public class FlightBean {
	@Inject
	private FlightService flightService;
	@Inject
	AirlineService airlineService;
	@Inject
	AirportService airportService;
	@Inject
	AirplaneService airplaneService;

	private Flight flight = new Flight();

	private List<Flight> flights;
	private List<Airline> airlineList;
	private List<Airport> airportList;
	List<Airplane> airplaneList;

	private List<Flight> filteredFlights;


	@PostConstruct
	public void init() {
		flights = flightService.findAll();
		airlineList = airlineService.findAll();
		airportList = airportService.findAll();
		airplaneList = airplaneService.findAll();
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

	public Map<String, String> getAirlineMap(){

		Map<String, String> airlineMap = new LinkedHashMap<String, String>();
		for(Airline airline : airlineList) {
			airlineMap.put(airline.getName(), airline.getName());
		}

		return airlineMap;
	}

	public Map<String, String> getAirportMap(){


		Map<String, String> airportMap = new LinkedHashMap<String, String>();
		for(Airport airport : airportList) {
			airportMap.put(airport.getName(), airport.getAirportcode());
		}

		return airportMap;
	}

	public Map<String, String> getAirplaneMap(){
		Map<String, String> airplaneMap = new LinkedHashMap<String, String>();
		for(Airplane airplane : airplaneList) {
			airplaneMap.put(airplane.getSerialnr(), airplane.getSerialnr());
		}

		return airplaneMap;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public List<Airline> getAirlineList() {
		return airlineList;
	}

	public void setAirlineList(List<Airline> airlineList) {
		this.airlineList = airlineList;
	}

	public List<Airport> getAirportList() {
		return airportList;
	}

	public void setAirportList(List<Airport> airportList) {
		this.airportList = airportList;
	}

	public List<Airplane> getAirplaneList() {
		return airplaneList;
	}

	public void setAirplaneList(List<Airplane> airplaneList) {
		this.airplaneList = airplaneList;
	}
}
