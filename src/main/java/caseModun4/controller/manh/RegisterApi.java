package caseModun4.controller.manh;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class RegisterApi {

  @Autowired
  AuthenticationManager authenticationManager;
}
