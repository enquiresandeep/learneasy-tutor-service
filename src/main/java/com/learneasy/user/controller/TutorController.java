package com.learneasy.user.controller;

import com.learneasy.user.infrastructure.dto.AddressDTO;
import com.learneasy.user.infrastructure.dto.TutorDTO;
import com.learneasy.user.service.ITutorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@Slf4j
@RequestMapping("/tutor")
public class TutorController {

    @Autowired
    private final ITutorService _tutorService;

    public TutorController(ITutorService tutorService){
        this._tutorService = tutorService;
    }


    @PostMapping("/")
    public ResponseEntity<TutorDTO> saveTutor(@RequestBody TutorDTO tutor) {
        log.info("TutorService saveTutor new logs "+tutor.getFirstName());
        try{
            return ResponseEntity.ok( _tutorService.createTutor(tutor));
        }catch(Exception e){
            log.error("TutorService error {}", tutor.getFirstName());
            TutorDTO errorTutor = new TutorDTO();
            errorTutor.setErrorMessage("Server Error");
            return new ResponseEntity<>(errorTutor, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<TutorDTO> updateTutor(@RequestBody TutorDTO tutor) {
        try {
            TutorDTO updatedTutor = _tutorService.updateTutor(tutor);
            return ResponseEntity.ok(updatedTutor);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            TutorDTO errorTutor = new TutorDTO();
            errorTutor.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(errorTutor, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            TutorDTO errorTutor = new TutorDTO();
            errorTutor.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(errorTutor, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{id}")
    public TutorDTO findTutorByTutorId(@PathVariable("id") String tutorId){
        log.info("TutorService findTutorBuId "+tutorId);
        return _tutorService.findTutorByTutorId(tutorId);
    }

    @GetMapping("/")
    public List<TutorDTO>  findAll(){
        log.info("findAll ");
        return _tutorService.findAll();
    }

    @PostMapping("/createAddress")
    public ResponseEntity<AddressDTO> createAddress(@RequestBody AddressDTO address) {
        log.info("TutorService saveTutor "+address.getStreet());
        try {
            AddressDTO updatedAddress = _tutorService.createAddress(address);
            return ResponseEntity.ok(updatedAddress);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            AddressDTO errorAddress = new AddressDTO();
            errorAddress.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(errorAddress, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/updateAddress")
    public ResponseEntity<AddressDTO> updateAddress(@RequestBody AddressDTO address) {
        try {
            AddressDTO updatedAddress = _tutorService.updateAddress(address);
            return ResponseEntity.ok(updatedAddress);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            AddressDTO errorAddress = new AddressDTO();
            errorAddress.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(errorAddress, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/address/{id}")
    public ResponseEntity<List<AddressDTO>> findAddresesByTutorId(@PathVariable("id") String tutorId){
        log.info("TutorService findTutorBuId "+tutorId);
        return ResponseEntity.ok(_tutorService.findAddressesByTutorId(tutorId));
    }



}
