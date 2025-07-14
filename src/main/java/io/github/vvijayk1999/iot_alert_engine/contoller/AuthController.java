package io.github.vvijayk1999.iot_alert_engine.contoller;

import io.github.vvijayk1999.iot_alert_engine.dto.AuthRequest;
import io.github.vvijayk1999.iot_alert_engine.dto.AuthResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest auth) {
        if ("admin".equals(auth.getUsername()) && "admin123".equals(auth.getPassword())) {
            String token = Jwts.builder()
                    .setSubject("admin")
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                    .signWith(Keys.hmacShaKeyFor("secret_key_which_is_at_least_32_chars!".getBytes()), SignatureAlgorithm.HS256)
                    .compact();
            return ResponseEntity.ok(new AuthResponse(token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}

