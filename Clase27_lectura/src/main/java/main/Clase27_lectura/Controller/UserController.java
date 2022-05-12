package main.Clase27_lectura.Controller;

import main.Clase27_lectura.Config.JwtTokenUtil;
import main.Clase27_lectura.Model.MyUser;
import main.Clase27_lectura.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/token")
public class UserController {
    @Autowired
    UserService us;
    @Autowired
    JwtTokenUtil jwt;

    @GetMapping
    public ResponseEntity getToken(){
        try{
            MyUser u=new MyUser();
            u.setToken(jwt.generateToken());
            return ResponseEntity.status(200).body(u);
        }catch (Exception e){
            return ResponseEntity.status(404).body("not found.");
        }
    }
}
