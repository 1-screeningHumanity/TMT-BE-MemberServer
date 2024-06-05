package com.example.TMTBEMemberServer.global.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JWTUtil {

    private final RedisTemplate<String, String> redisTemplate;
    private final UserDetailsService userDetailsService;

    @Value("${JWT.access-expiration}")
    private long accessTokenExpiration;

    @Value("${JWT.refresh-expiration}")
    private long refreshTokenExpiration;

    @Value("${JWT.SECRET_KEY}")
    public String secretKey;


    public String createAccessToken(Authentication authentication){ //AccessToken 생성
        Claims claims = Jwts.claims().setSubject(authentication.getName());
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + accessTokenExpiration);

        return Jwts.builder()  //AccessToken 리턴
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String createRefreshToken(Authentication authentication){ //refreshToken 생성
        Claims claims  = Jwts.claims().setSubject(authentication.getName());
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + refreshTokenExpiration);

        String refreshToken = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();


        redisTemplate.opsForValue().  //redis에 refreshToken 저장
                set(authentication.getName(), refreshToken,
                refreshTokenExpiration, TimeUnit.MILLISECONDS);

        return refreshToken; //refreshToken 리턴
    }

    public String remakeAccessToken(String uuid){ //AccessToken 재발급
        Claims claims = Jwts.claims().setSubject(uuid);
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + accessTokenExpiration);

        String AccessToken = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        return AccessToken;
    }
}