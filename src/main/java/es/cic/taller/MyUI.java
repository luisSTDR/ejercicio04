package es.cic.taller;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        final TextField name = new TextField();
        name.setCaption("Nombre:");
        name.setPlaceholder("Escribe tu nombre...");
        name.setMaxLength(30);
        
        final TextField apellidos = new TextField();
        apellidos.setCaption("Apellidos:");
        apellidos.setPlaceholder("Escribe tus apellidos...");
        apellidos.setMaxLength(30);
        
        final TextField edad = new TextField();
        edad.setCaption("Edad:");
        edad.setPlaceholder("Escribe tu edad...");
        edad.setMaxLength(3);
        
        final TextField direc = new TextField();
        direc.setCaption("Dirección:");
        direc.setPlaceholder("Escribe tu dirección...");
        direc.setMaxLength(50);
        
        /*name.addValueChangeListener(event -> Notification.show("Value changed:",
                String.valueOf(name.getValue()),
                Type.TRAY_NOTIFICATION));*/

        Button button = new Button("Datos");
        button.addClickListener(event -> Notification.show("Hola " + String.valueOf(name.getValue())
        	+ " " + String.valueOf(apellidos.getValue()) + ", de " + String.valueOf(edad.getValue()) 
        	+ " de edad, con domicilio en " + String.valueOf(direc.getValue()),Type.TRAY_NOTIFICATION));
        
        layout.addComponents(name, apellidos, edad, direc, button);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
