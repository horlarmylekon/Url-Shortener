package com.intellisensedev.urlshortener_engine.setup;

import com.intellisensedev.urlshortener_engine.model.User;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class PasswordValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","password.password","password field is required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"confirmPassword","password.confirmPassword","password field is required");

        User user = (User)target;

        if(!(user.getPassword().equals(user.getConfirmPassword()))){
            errors.rejectValue("password","notMatch.password");
        }
    }
}
