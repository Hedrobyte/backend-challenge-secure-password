package com.hedrobyte.securepassword.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswodService {

    public List<String> validatePassword(String password) {
        List<String> failures = new ArrayList<>();

        validateLength(password, failures);

        return failures;
    }

    private void validateLength(String password, List<String> failures) {
        if (password != null && password.length() < 8) {
            failures.add("A senha deve conter pelo menos 8 caracteres");
        }
    }


}
