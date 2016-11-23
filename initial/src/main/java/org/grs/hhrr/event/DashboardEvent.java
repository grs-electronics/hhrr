package org.grs.hhrr.event;

import org.grs.hhrr.view.ViewType;

public abstract class DashboardEvent {
	public static final class UserLoginRequestEvent {
		private final String userEmail, password;

		public UserLoginRequestEvent(final String userEmail, final String password) {
			this.userEmail = userEmail;
			this.password = password;
		}

		public String getUserEmail() {
			return userEmail;
		}

		public String getPassword() {
			return password;
		}
	}

	public static class ProfileUpdatedEvent {
	}

	public static class CloseOpenWindowsEvent {
	}

	public static class UserLoggedOutEvent {

	}

	public static final class PostViewChangeEvent {
		private final ViewType view;

		public PostViewChangeEvent(final ViewType view) {
			this.view = view;
		}

		public ViewType getView() {
			return view;
		}
	}

	public static class BrowserResizeEvent {

	}
}
