package cs545.airline.converter;

import cs545.airline.service.AirlineService;
import cs545.airline.service.AirportService;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;


@Named("airportConverter")
public class AirportConverter implements Converter {
    @Inject
    AirportService airportService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return airportService.findByCode(s);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return o.toString();
    }
}
