package org.grs.hhrr.view;

import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;

public enum ViewType {
	DASHBOARD(
			"dashboard",DashboardView.class, FontAwesome.HOME,true);
	
	private final String viewName;
    private final Class<? extends View> viewClass;
    private final Resource icon;
    private final boolean stateful;
    
	
    private ViewType(final String viewName,
            final Class<? extends View> viewClass, final Resource icon,
            final boolean stateful) {
        this.viewName = viewName;
        this.viewClass = viewClass;
        this.icon = icon;
        this.stateful = stateful;
    }
    public boolean isStateful() {
        return stateful;
    }
    public String getViewName() {
        return viewName;
    }
    public Class<? extends View> getViewClass() {
        return viewClass;
    }
    public Resource getIcon() {
        return icon;
    }
	public static ViewType getByViewName(final String viewName) {
        ViewType result = null;
        for (ViewType viewType : values()) {
            if (viewType.getViewName().equals(viewName)) {
                result = viewType;
                break;
            }
        }
        return result;
    }    
}
