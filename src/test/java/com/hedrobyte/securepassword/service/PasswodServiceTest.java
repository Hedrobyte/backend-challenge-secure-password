package com.hedrobyte.securepassword.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswodServiceTest {
    private PasswodService passwodService;

    @BeforeEach
    public void setUp() {
        passwodService = new PasswodService();
    }

    @Test
    public void testPasswordLength() {
        List<String> failures = passwodService.validatePassword("1aA!");
        assertEquals(1, failures.size());
        assertEquals("A senha deve conter pelo menos 8 caracteres", failures.get(0));
    }

    @Test
    public void testPasswordUpperCase() {
        List<String> failures = passwodService.validatePassword("12345678a!");
        assertEquals(1, failures.size());
        assertEquals("A senha deve conter pelo menos uma letra maiúscula", failures.get(0));
    }

    @Test
    public void testPasswordLowerCase() {
        List<String> failures = passwodService.validatePassword("12345678A!");
        assertEquals(1, failures.size());
        assertEquals("A senha deve conter pelo menos uma letra minúscula", failures.get(0));
    }

    @Test
    public void testPasswordDigit() {
        List<String> failures = passwodService.validatePassword("aA!bbbbb");
        assertEquals(1, failures.size());
        assertEquals("A senha deve conter pelo menos um dígito numérico", failures.get(0));
    }

}
