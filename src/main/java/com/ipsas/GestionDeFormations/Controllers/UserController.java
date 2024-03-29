package com.ipsas.GestionDeFormations.Controllers;

import com.ipsas.GestionDeFormations.Models.User;
import com.ipsas.GestionDeFormations.Services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User Conroller", description = "Full CRUD for User Model")
@SecurityRequirement(name = "JwtAuthentication")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService ) {
        this.userService = userService;
    }

    @Operation(security = @SecurityRequirement(name = "JwtAuthentication"))
    @GetMapping("/")
    public ResponseEntity<List<User>> index(){
        List<User> l = userService.findAll();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id){
        User e = userService.findOneById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @PostMapping ("/add")
    public ResponseEntity<User> add(@RequestBody User employee){
        User e = userService.addUser(employee);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @PutMapping  ("/update")
    public ResponseEntity<User> update(@RequestBody User employee){
        User e = userService.updateUser(employee);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @DeleteMapping  ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
