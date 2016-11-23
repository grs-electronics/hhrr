package org.grs.hhrr.ui;

import javax.servlet.ServletException;

import com.vaadin.server.VaadinServlet;


public class PrincipalServlet extends VaadinServlet	{
	@Override
	protected void servletInitialized() throws ServletException {
		super.servletInitialized();
        getService().addSessionInitListener(new PrincipalSessionListener());		
	}
}
