package com.hedrobyte.securepassword.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswodServiceTest {

    private final PasswodService passwodService = new PasswodService();

    @Test
    public void testPasswordLength() {
        List<String> failures = passwodService.validatePassword("1234567");
        assertEquals(1, failures.size());
        assertEquals("A senha deve conter pelo menos 8 caracteres", failures.getFirst());
    }

}
