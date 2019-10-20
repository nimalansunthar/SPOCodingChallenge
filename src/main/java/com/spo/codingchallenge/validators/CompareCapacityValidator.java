package com.spo.codingchallenge.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.spo.codingchallenge.annotations.CompareCapacity;
import com.spo.codingchallenge.domain_objects.JobDO;
/**
 * Class Validator to implement the logic of the constraints
 * @author ex1
 *
 */
public class CompareCapacityValidator implements ConstraintValidator<CompareCapacity, JobDO> {
	 
    @Override
    public void initialize(CompareCapacity constraint) {
    }
 
    @Override
    public boolean isValid(JobDO job, ConstraintValidatorContext context) {
        return (job.getSeniorCapacity() > job.getJuniorCapacity());
    }
 
}