package com.hedrobyte.securepassword.controller;

import com.hedrobyte.securepassword.service.PasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {
    private final PasswordService passwodService;

    public ApiController(PasswordService passwodService) {
        this.passwodService = passwodService;
    }

    @PostMapping(value="validate-password")
    public ResponseEntity<List<String>> isSafe(@RequestBody BodyRequest request) {
        var failures = passwodService.validatePassword(request.password());

        return failures.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.badRequest().body(failures);
    }

}
