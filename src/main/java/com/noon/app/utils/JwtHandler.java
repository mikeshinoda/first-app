package com.noon.app.utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtHandler {
    public String createToken(String email, String phone, String deviceId, String platform, long ttlMils) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMills = System.currentTimeMillis();
        Date now = new Date(nowMills);

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("cQaNGEPaaXU9Mc6uVaeJYHHg6RlJTCqbcQaNGEPaaXU9Mc6uVaeJYHHg6RlJTCqb");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        Map<String, Object> payload = new HashMap<>();
        payload.put("eid", email);
        payload.put("phn", phone);
        payload.put("did", deviceId);
        payload.put("plt", platform);

        JwtBuilder builder = Jwts.builder()
                .setClaims(payload)
                .setIssuedAt(now)
                .setIssuer("noon")
                .signWith(signingKey, signatureAlgorithm);

        if (ttlMils > 0) {
            long expMillis = nowMills + ttlMils;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    };
}
