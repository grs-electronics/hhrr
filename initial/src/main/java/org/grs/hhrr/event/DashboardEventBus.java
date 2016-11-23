package org.grs.hhrr.event;

import java.io.Serializable;

import org.grs.hhrr.ui.PrincipalUI;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;

public class DashboardEventBus implements SubscriberExceptionHandler,Serializable{

	private final EventBus eventBus=new EventBus(this);
	public static void post(final Object object){
		PrincipalUI.getDashboardEventbus().eventBus.post(object);
	}
	
	public static void register(final Object object) {
	 	PrincipalUI.getDashboardEventbus().eventBus.register(object);
    }

    public static void unregister(final Object object) {
    	PrincipalUI.getDashboardEventbus().eventBus.unregister(object);
    }
	@Override
	public void handleException(Throwable exception, SubscriberExceptionContext context) {
	}

}
