package com.example.demo;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/identify")
public class IdentifyController {

    private final IdentifyService identityService;

    public IdentifyController(IdentifyService identityService) {
        this.identityService = identityService;
    }

    @PostMapping("/verify")
    public Boolean verifyIdentity(@RequestBody IdentifyRequestDto identifyRequestDto) {
        // Pasamos el objeto completo a IdentityService para que lo maneje
        return identityService.verifyIdentity(identifyRequestDto);
    }
}


