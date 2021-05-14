package com.ipsas.GestionDeFormations.Controllers;

import com.ipsas.GestionDeFormations.Models.Employee;
import com.ipsas.GestionDeFormations.Services.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Tag(name = "Employee Controller", description = "Full CRUD for Employee Model")
@SecurityRequirement(name = "JwtAuthentication")
public class EmployeeController {

    private final EmployeeService employeeService;



    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Return ALL Employees")
    @GetMapping("/")
    public ResponseEntity<List<Employee>> index(){
        List<Employee> l = employeeService.findAll();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @Operation(summary = "Return a specific Employee with Id")
    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") Long id){
        Employee e = employeeService.findOneById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @Operation(summary = "Add new Employee")
    @PostMapping ("/add")
    public ResponseEntity<Employee> add(@RequestBody Employee employee){
        Employee e = employeeService.addEmployee(employee);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @Operation(summary = "update an existing Employee")
    @PutMapping  ("/update")
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        Employee e = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @Operation(summary = "Delete a specific Employee with Id")
    @DeleteMapping  ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
