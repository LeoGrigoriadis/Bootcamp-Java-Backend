package main.Clase27_lectura.Config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import main.Clase27_lectura.Model.MyUser;
import main.Clase27_lectura.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class JwtTokenUtil implements Serializable {
    @Autowired
    UserService us;
    private final String secret="secretToken";

    public String generateToken(){
        Date expirationDate = new Date(System.currentTimeMillis() + 604800L * 1000);

        return Jwts.builder().setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512,secret.getBytes()).compact();
    }
}
