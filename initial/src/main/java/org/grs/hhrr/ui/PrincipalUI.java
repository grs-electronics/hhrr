package org.grs.hhrr.ui;

import java.util.ArrayList;
import java.util.List;

import org.grs.hhrr.bean.Usuario;
import org.grs.hhrr.event.DashboardEvent.BrowserResizeEvent;
import org.grs.hhrr.event.DashboardEvent.UserLoginRequestEvent;
import org.grs.hhrr.event.DashboardEventBus;
import org.grs.hhrr.view.LoginView;
import org.grs.hhrr.view.MainView;

import com.google.common.eventbus.Subscribe;
import com.vaadin.annotations.Theme;
import com.vaadin.server.Page;
import com.vaadin.server.Page.BrowserWindowResizeEvent;
import com.vaadin.server.Page.BrowserWindowResizeListener;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.Position;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI
@Theme("vproject")
public class PrincipalUI extends UI {
	private final DashboardEventBus dashboardEventbus = new DashboardEventBus();
	@Override
	protected void init(VaadinRequest request) {
		Responsive.makeResponsive(this);
		DashboardEventBus.register(this);
		addStyleName(ValoTheme.UI_WITH_MENU);
		//setContent(new LoginView());
		actualizarContenido();
		Page.getCurrent().addBrowserWindowResizeListener(
                new BrowserWindowResizeListener() {
                    @Override
                    public void browserWindowResized(
                            final BrowserWindowResizeEvent event) {
                        DashboardEventBus.post(new BrowserResizeEvent());
                    }
                });
	}
	public static DashboardEventBus getDashboardEventbus() {
        return ((PrincipalUI) getCurrent()).dashboardEventbus;
    }
	private void actualizarContenido(){
		Usuario usuario=(Usuario)VaadinSession.getCurrent().getAttribute(Usuario.class.getName());
		if(usuario!=null){
			this.setContent(new MainView());
			this.removeStyleName("loginview");
			this.getNavigator().navigateTo(getNavigator().getState());
		}else{
			this.setContent(new LoginView());
			this.addStyleName("loginview");
		}
	}
	@Subscribe
	public void userLoginRequested(final UserLoginRequestEvent evt){
		List users=new ArrayList();//=HibernateUtil.getInstancia().autenticarUsuario(evt.getUserEmail(),evt.getPassword());
		
		/*if(users!=null && !users.isEmpty()){
			VaadinSession.getCurrent().setAttribute(Usuario.class.getName(), (Usuario)users.get(0));
			//Notification.show("Inicio de sesión","Notificación",Notification.TYPE_TRAY_NOTIFICATION);
			actualizarContenido();
		}*/
		if("in6am".equals(evt.getUserEmail()) && "123".equals(evt.getPassword())){
			VaadinSession.getCurrent().setAttribute(Usuario.class.getName(), new Usuario());
			//Notification.show("Inicio de sesión","Notificación",Notification.TYPE_TRAY_NOTIFICATION);
			actualizarContenido();
		}else{
			Notification noty=new Notification("Verifique sus credenciales","<br/>Fallo al válidar credenciales ",Notification.TYPE_ERROR_MESSAGE);
			noty.setDelayMsec(10000);
			noty.setHtmlContentAllowed(true);
			noty.setPosition(Position.BOTTOM_CENTER);
			noty.setStyleName("tray dark small closable login-help");
			noty.show(Page.getCurrent());
		}
	}
}
