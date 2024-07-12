package com.hedrobyte.securepassword.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswodServiceTest {
    private PasswordService passwordService;

    @BeforeEach
    public void setUp() {
        passwordService = new PasswordService();
    }

    @Test
    public void testPasswordNull() {
        List<String> failures = passwordService.validatePassword(null);
        assertEquals(1, failures.size());
        assertEquals("A senha não pode estar vazia.", failures.get(0));
    }

    @Test
    public void testPasswordEmpty() {
        List<String> failures = passwordService.validatePassword("");
        assertEquals(1, failures.size());
        assertEquals("A senha não pode estar vazia.", failures.get(0));
    }

    @Test
    public void testPasswordLength() {
        List<String> failures = passwordService.validatePassword("1aA!");
        assertEquals(1, failures.size());
        assertEquals("A senha deve conter pelo menos 8 caracteres", failures.get(0));
    }

    @Test
    public void testPasswordUpperCase() {
        List<String> failures = passwordService.validatePassword("12345678a!");
        assertEquals(1, failures.size());
        assertEquals("A senha deve conter pelo menos uma letra maiúscula", failures.get(0));
    }

    @Test
    public void testPasswordLowerCase() {
        List<String> failures = passwordService.validatePassword("12345678A!");
        assertEquals(1, failures.size());
        assertEquals("A senha deve conter pelo menos uma letra minúscula", failures.get(0));
    }

    @Test
    public void testPasswordDigit() {
        List<String> failures = passwordService.validatePassword("aA!bbbbb");
        assertEquals(1, failures.size());
        assertEquals("A senha deve conter pelo menos um dígito numérico", failures.get(0));
    }

    @Test
    public void testPasswordSpecialChar() {
        List<String> failures = passwordService.validatePassword("aA12345678");
        assertEquals(1, failures.size());
        assertEquals("A senha deve conter pelo menos um caractere especial", failures.get(0));
    }

    @Test
    public void testPasswordValid() {
        List<String> failures = passwordService.validatePassword("Val1dPa55word!");
        assertEquals(0, failures.size(), "A senha válida não deveria ter falhas.");
    }

}
