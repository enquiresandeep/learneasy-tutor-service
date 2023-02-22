package com.learneasy.user.controller;

import com.learneasy.user.domain.Address;
import com.learneasy.user.domain.ErrorResponse;
import com.learneasy.user.domain.Student;
import com.learneasy.user.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@Slf4j
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService _studentService;

    @PostMapping("/")
    public Student saveStudent(@RequestBody Student student) {
        log.info("StudentService saveStudent "+student.getFirstName());
        return _studentService.createStudent(student);
    }

    @PutMapping("/")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        try {
            Student updatedStudent = _studentService.updateStudent(student);
            return ResponseEntity.ok(updatedStudent);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            Student errorStudent = new Student();
            errorStudent.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(errorStudent, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            Student errorStudent = new Student();
            errorStudent.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(errorStudent, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{id}")
    public Student findStudentByStudentId(@PathVariable("id") String studentId){
        log.info("StudentService findStudentBuId "+studentId);
        return _studentService.findStudentByStudentId(studentId);
    }

    @GetMapping("/")
    public List<Student>  findAll(){
        log.info("findAll ");
        return _studentService.findAll();
    }




    @PostMapping("/createAddress")
    public Address createAddress(@RequestBody Address address) {
        log.info("StudentService saveStudent "+address.getStreet());
        return _studentService.createAddress(address);
    }

    @PutMapping("/updateAddress")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
        try {
            Address updatedAddress = _studentService.updateAddress(address);
            return ResponseEntity.ok(updatedAddress);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            Address errorAddress = new Address();
            errorAddress.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(errorAddress, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/address/{id}")
    public ResponseEntity<List<Address>> findAddresesByStudentId(@PathVariable("id") String studentId){
        log.info("StudentService findStudentBuId "+studentId);
        return ResponseEntity.ok(_studentService.findAddressesByStudentId(studentId));
    }



}
