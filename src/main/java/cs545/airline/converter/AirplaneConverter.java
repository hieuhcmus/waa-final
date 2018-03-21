package cs545.airline.converter;

import cs545.airline.service.AirplaneService;
import cs545.airline.service.AirportService;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named("airplaneConverter")
public class AirplaneConverter implements Converter {
    @Inject
    AirplaneService airplaneService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return airplaneService.findBySrlnr(s);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return o.toString();
    }
}
