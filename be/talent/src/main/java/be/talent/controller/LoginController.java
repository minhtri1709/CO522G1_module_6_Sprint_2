package be.talent.controller;

import be.talent.model.AuthRequest;
import be.talent.model.AuthResponse;
import be.talent.service.impl.CustomUserDetailService;
import be.talent.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthRequest authRequest;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @PostMapping("/login")
    public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        String jwt;
        UserDetails userDetails;
        List<String> roles;
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            jwt = jwtUtil.generateToken(authRequest.getUsername());
//            myUserDetails = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
        }
        return ResponseEntity.ok(
                new AuthResponse(
                        jwt,
                        userDetails.getUsername(),
                        roles));
    }
}

