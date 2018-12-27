package com.learn.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.learn.validation.entities.Singer;

public class CountrySingerValidator	implements	ConstraintValidator<CheckCountrySinger,Singer> {

	@Override
	public boolean isValid(Singer singer, ConstraintValidatorContext context) {
		boolean	result	=	true;
		if (singer.getGenre() != null
				&& (singer.isCountrySinger() && 
						(singer.getLastName() == null && 
						singer.getGender() == null ))) {
			result	=	false;
		}
		return result;
	}

}
