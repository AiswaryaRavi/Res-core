package com.aishu.validators;

import com.aishu.dao.MenuItemsDao;
import com.aishu.exception.ValidationException;
import com.aishu.model.MenuItems;

public class CustomerService {
	private MenuItemsDao menuitemsdao = new MenuItemsDao();

	public void save(MenuItems m) throws ServiceException {

		try {

			CustomerValidator.validateForInsert(m);
			menuitemsdao.save(m);

		} catch (ValidationException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to insert Item", e);
		}
	}

	public void delete(MenuItems m) throws ServiceException {
		try {
			CustomerValidator.validatorForDelete(m);
			menuitemsdao.delete(m);
		} catch (ValidationException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to delete Item", e);
		}

	}

	public void update(MenuItems m) throws ServiceException {
		try {
			CustomerValidator.validatorForUpdate(m);
			menuitemsdao.delete(m);
		} catch (ValidationException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to update Item", e);
		}

	}
}
