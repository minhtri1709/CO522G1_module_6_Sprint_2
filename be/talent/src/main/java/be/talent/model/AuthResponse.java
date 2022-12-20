package be.talent.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
public class AuthResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private String username;
    Collection<String> roles = new ArrayList<>();

    public AuthResponse() {
    }

    public AuthResponse(String accessToken, String username, Collection<String> roles) {
        this.accessToken = accessToken;
        this.username = username;
        this.roles = roles;
    }
}
