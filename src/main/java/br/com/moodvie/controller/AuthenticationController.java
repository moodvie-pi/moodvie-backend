package br.com.moodvie.controller;

import br.com.moodvie.domain.user.User;
import br.com.moodvie.form.LoginForm;
import br.com.moodvie.security.JWTtokenData;
import br.com.moodvie.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping()
    public ResponseEntity<?> login(@RequestBody @Valid LoginForm loginForm) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(loginForm.username(), loginForm.password());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new JWTtokenData(tokenJWT));
    }
}
