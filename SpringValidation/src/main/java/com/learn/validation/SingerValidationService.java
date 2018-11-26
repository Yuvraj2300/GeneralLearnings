package com.learn.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.validation.entities.Singer;

@Service("singerValidationService")
public class SingerValidationService {

	@Autowired
	private Validator validator;

	public Set<ConstraintViolation<Singer>> validateSinger(Singer singer) {
		return validator.validate(singer);
	}
}
