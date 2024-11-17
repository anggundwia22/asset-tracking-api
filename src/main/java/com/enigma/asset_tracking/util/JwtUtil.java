package com.enigma.asset_tracking.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "mysecretkey";
    private final String REFRESH_SECRET_KEY = "refreshsecretkey";

    private final long ACCESS_TOKEN_VALIDITY = 30 * 60 * 1000;

    private final long REFRESH_TOKEN_VALIDITY = 7 * 24 * 60 * 60 * 1000;

    public String generateToken(String username) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY); // Using HMAC256 algorithm with the secret key
        return JWT.create()
                .withSubject(username)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY))
                .sign(algorithm); // Signing the JWT with the algorithm
    }

    public String generateRefreshToken(String username) {
        Algorithm algorithm = Algorithm.HMAC256(REFRESH_SECRET_KEY); // Using a different secret key for refresh token
        return JWT.create()
                .withSubject(username)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + REFRESH_TOKEN_VALIDITY))
                .sign(algorithm); // Signing the JWT with the algorithm
    }

    public String validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        DecodedJWT decodedJWT = JWT.require(algorithm)
                .build()
                .verify(token); // Verifying the token and decoding it
        return decodedJWT.getSubject(); // Extracting the username from the token
    }

    public String validateRefreshToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(REFRESH_SECRET_KEY);
        DecodedJWT decodedJWT = JWT.require(algorithm)
                .build()
                .verify(token); // Verifying the token and decoding it
        return decodedJWT.getSubject(); // Extracting the username from the refresh token
    }
}
