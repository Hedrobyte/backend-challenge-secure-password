package com.hedrobyte.securepassword.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswodService {

    public List<String> validatePassword(String password) {
        List<String> failures = new ArrayList<>();

        validateLength(password, failures);
        validateUpperCase(password, failures);
        validateLowerCase(password, failures);
        validateDigit(password, failures);
        validateSpecialChar(password, failures);

        return failures;
    }

    private void validateLength(String password, List<String> failures) {
        if (password != null && password.length() < 8) {
            failures.add("A senha deve conter pelo menos 8 caracteres");
        }
    }

    private void validateUpperCase(String password, List<String> failures) {
        if (password != null && !password.matches(".*[A-Z].*")) {
            failures.add("A senha deve conter pelo menos uma letra maiúscula");
        }
    }

    private void validateLowerCase(String password, List<String> failures) {
        if (password != null && !password.matches(".*[a-z].*")) {
            failures.add("A senha deve conter pelo menos uma letra minúscula");
        }
    }

    private void validateDigit(String password, List<String> failures) {
        if (password != null && !password.matches(".*\\d.*")) {
            failures.add("A senha deve conter pelo menos um dígito numérico");
        }
    }

    private void validateSpecialChar(String password, List<String> failures) {
        if (password != null && !password.matches(".*\\W.*")) {
            failures.add("A senha deve conter pelo menos um caractere especial");
        }
    }

}
