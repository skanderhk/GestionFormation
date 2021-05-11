package com.ipsas.GestionDeFormations.Controllers;

import com.ipsas.GestionDeFormations.Models.Admin;
import com.ipsas.GestionDeFormations.Services.AdminService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@OpenAPIDefinition(info = @Info(title = "Gestion Formation",description = "Application de gestion pour un Center de formations",version = "1.1.0",contact = @Contact(name = "Skander Hadjkacem",email = "skander.hkacem@gmail.com")))
@RestController
@RequestMapping("/admins")
@Tag(name = "Admin Controller", description = "Full CRUD for Admin Model")
public class AdminController {

    private final AdminService adminService;



    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @Operation(summary = "Return ALL ADMINS")
    @GetMapping("/")
    public ResponseEntity<List<Admin>> index(){
        List<Admin> l = adminService.findAll();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @Operation(summary = "Return A specific ADMIN with Id")
    @GetMapping("/{id}")
    public ResponseEntity<Admin> findById(@PathVariable("id") Long id){
        Admin e = adminService.findOneById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @Operation(summary = "Add new ADMIN")
    @PostMapping ("/add")
    public ResponseEntity<Admin> add(@RequestBody Admin admin){
        Admin e = adminService.addAdmin(admin);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @Operation(summary = "Update an existing ADMIN")
    @PutMapping  ("/update")
    public ResponseEntity<Admin> update(@RequestBody Admin admin){
        Admin e = adminService.updateAdmin(admin);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @Operation(summary = "Delete A specific ADMIN with Id")
    @DeleteMapping  ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        adminService.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
