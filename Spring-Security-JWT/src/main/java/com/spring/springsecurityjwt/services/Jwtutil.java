/*
 * author: Sadik Hassan
 * created: 12:58 pm, 29/09/2022
 */
package com.spring.springsecurityjwt.services;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class Jwtutil {
    private String SECRET_KEY="secret";

    public String extractUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }
    private <T> T extractClaim(String token, Function<Claims,T>claimsResolver){
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
    public Date extraExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }
    public Boolean isTokenExpired(String token){
        return extraExpiration(token).before(new Date());
    }
    public String generateToken(UserDetails userDetails){
        Map<String,Object>claims=new HashMap<>();
        return createToken(claims,userDetails.getUsername());
    }
    private String createToken(Map<String ,Object>claims,String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();
    }
    public Boolean validateToken(String token, UserDetails userDetails){
        final String username=extractUsername(token);
        return (username.equals(userDetails.getUsername())&&!isTokenExpired(token));
    }
}
