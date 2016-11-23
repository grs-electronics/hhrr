package org.grs.hhrr.view;

import org.grs.hhrr.ui.DashboardMenu;
import org.grs.hhrr.ui.DashboardNavigator;

import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;

public class MainView extends HorizontalLayout	{
	public MainView(){
		this.setSizeFull();
		this.addStyleName("mainview");
		addComponent(new DashboardMenu());
		
		ComponentContainer content = new CssLayout();
        content.addStyleName("view-content");
        content.setSizeFull();
        addComponent(content);
        setExpandRatio(content, 1.0f);

       new DashboardNavigator(content);
	}
}
