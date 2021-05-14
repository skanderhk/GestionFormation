package com.ipsas.GestionDeFormations.Controllers;

import com.ipsas.GestionDeFormations.Jwt.AuthRequest;
import com.ipsas.GestionDeFormations.Jwt.AuthResponse;
import com.ipsas.GestionDeFormations.Jwt.JwtUtils;
import com.ipsas.GestionDeFormations.Services.UserPrincipalDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
@Tag(name = "Auth Controller", description = "Authentication Controller")
public class AuthController {

    @Autowired
    private UserPrincipalDetailsService userPrincipalDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Operation(summary = "Login JWT",description = "After signing successfully ,a JWT will be generated")
    @PostMapping("/login")
    public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest authRequest) throws Exception{

        try{
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())
        );
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect Username or Password",e);
        }

        final UserDetails userDetails= userPrincipalDetailsService.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt));
    }

}
