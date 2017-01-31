package com.aishu.validators;

import com.aishu.exception.ValidationException;
import com.aishu.model.MenuItems;
import com.aishu.util.ValidatorUtil;

public class CustomerValidator {
	private CustomerValidator() {
		throw new IllegalAccessError("Validator class");
	}

	public static void validateForInsert(MenuItems menu) throws ValidationException {

		if (ValidatorUtil.isInvalidString(menu.getItem())) {
			throw new ValidationException("Invalid Item name");
		}
	}

	public static void validatorForDelete(MenuItems menu) throws ValidationException {
		if (ValidatorUtil.isInvalidNumber(menu.getId())) {
			throw new ValidationException("Invalid Id");
		}
	}

	public static void validatorForUpdate(MenuItems menu) throws ValidationException {
		if (ValidatorUtil.isInvalidNumber(menu.getId())) {
			throw new ValidationException("Invalid Id");
		}
	}
}
