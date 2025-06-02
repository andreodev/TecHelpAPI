package br.com.TecHelpAPI.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import br.com.TecHelpAPI.model.User;


public class JwtUtil {

    private static final String SECRET_KEY = "c2VuaGFzZW1wcmV2YWlzZXJzZW5oYQ==";

    private static final Key KEY = new SecretKeySpec(SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());

    public static String generateToken(User user) {
    return Jwts.builder()
            .setSubject(user.getNameUser())
            .claim("id", user.getIdUser())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 3600_000)) // 1 hora
            .signWith(KEY, SignatureAlgorithm.HS256)
            .compact();
}

    public static Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
