package main.Clase27_lectura.Controller;

import main.Clase27_lectura.Config.JwtTokenUtil;
import main.Clase27_lectura.Model.AuthToken;
import main.Clase27_lectura.Model.MyUser;
import main.Clase27_lectura.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService us;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity<AuthToken> register(@RequestBody MyUser loginUser) throws AuthenticationException {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        final UserDetails user = us.loadUserByUsername(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.status(HttpStatus.OK).body(new AuthToken(token, user.getUsername()));
    }
}