package com.hedrobyte.securepassword.controller;

import com.hedrobyte.securepassword.service.PasswodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    private final PasswodService passwodService;

    public ApiController(PasswodService passwodService) {
        this.passwodService = passwodService;
    }

    @PostMapping(value ="/validate-password")
    public ResponseEntity<FailureResponse> validatePassword(@RequestBody BodyRequest request) {

        var failures = passwodService.validatePassword(request.password());

        if (failures.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().body(new FailureResponse(failures));
    }
}
