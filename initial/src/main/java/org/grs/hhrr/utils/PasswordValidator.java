package org.grs.hhrr.utils;

import com.vaadin.data.validator.AbstractValidator;

public  final class PasswordValidator extends AbstractValidator<String> {

	public PasswordValidator() {
		super("El password ingresado no es válido");
	}

	@Override
	protected boolean isValidValue(String value) {
		//
		// Password must be at least 8 characters long and contain at least
		// one number
		//
		if (value != null && (value.length() < 8 || !value.matches(".*\\d.*"))) {
			return false;
		}
		return true;
	}

	@Override
	public Class<String> getType() {
		return String.class;
	}
}