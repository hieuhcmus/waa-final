package cs545.airline.bean;

import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirplaneService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Named
//@RequestScoped
@SessionScoped
public class AirlineBean implements Serializable{
    @Inject
    private AirlineService airlineService;
    private Airline airline = new Airline();
    private List<Airline> airlines;
    @Inject
    private FlightBean flightBean;

    public FlightBean getFlightBean() {
        return flightBean;
    }

    public void setFlightBean(FlightBean flightBean) {
        this.flightBean = flightBean;
    }

    @PostConstruct
    public void init() {
        airlines = airlineService.findAll();
    }

    public Airline getAirplane() {
        return airline;
    }

    public String createAirline() {
        airlineService.create(airline);
        return "airlineList.xhtml?faces-redirect=true";
    }

    public List<Airline> getAirlines() {
        System.out.println(airlines);
        return airlines;
    }

    public String editAirlineRecord(long id) {
        Airline a = airlineService.findById(id);
        Map<String, Object> sessionMap =
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("editAirline", a);
        return "editAirline.xhtml?faces-redirect=true";
    }

    public String updateAirline(Airline airline) {
        airlineService.update(airline);
        return "airlineList.xhtml?faces-redirect=true";
    }
}
