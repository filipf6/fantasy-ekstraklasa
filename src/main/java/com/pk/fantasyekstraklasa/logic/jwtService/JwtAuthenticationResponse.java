package com.pk.fantasyekstraklasa.logic.jwtService;

import java.io.Serializable;

public class JwtAuthenticationResponse implements Serializable {
    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public JwtAuthenticationResponse(String token) {
        System.out.println("hellllloooooooooooooooooooooooooooooooooo");
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
