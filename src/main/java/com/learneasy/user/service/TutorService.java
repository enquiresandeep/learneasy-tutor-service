package com.learneasy.user.service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.learneasy.user.domain.Address;
import com.learneasy.user.domain.Tutor;
import com.learneasy.user.infrastructure.AddressRepository;
import com.learneasy.user.infrastructure.TutorRepository;
import com.learneasy.user.infrastructure.dto.AddressDTO;
import com.learneasy.user.infrastructure.dto.TutorDTO;
import com.learneasy.user.infrastructure.mapper.AddressMapper;
import com.learneasy.user.infrastructure.mapper.PhoneMapper;
import com.learneasy.user.infrastructure.mapper.TutorMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TutorService implements ITutorService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
     private TutorRepository tutorRepository;

    @Autowired
    private TutorMapper tutorMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private PhoneMapper phoneMapper;

    public TutorDTO createTutor(TutorDTO tutorDTO) throws Exception{
        log.info("TutorService saveTutor "+ tutorDTO.getFirstName());
        Tutor tutor =  tutorRepository.save(tutorMapper.tutorDTOToTutor(tutorDTO) );
        return tutorMapper.tutorToTutorDTO(tutor);
    }

    public TutorDTO findTutorByTutorId(String tutorId){
        log.info("TutorService findTutorBuId "+tutorId);
        return  tutorMapper.tutorToTutorDTO(tutorRepository.findById(tutorId).get());
    }

    public TutorDTO updateTutor(TutorDTO updatedTutor) throws JsonMappingException {
         tutorRepository.findById(updatedTutor.getTutorId())
                .orElseThrow(() -> new RuntimeException("Tutor not found with id " + updatedTutor.getTutorId()));
        Tutor tutor = tutorRepository.save(tutorMapper.tutorDTOToTutor(updatedTutor));
        return  tutorMapper.tutorToTutorDTO(tutor);
    }

    public List<TutorDTO> findAll(){
        return tutorMapper.tutorToTutorDTOs(tutorRepository.findAll());
    }

    public AddressDTO createAddress(AddressDTO addressDTO) throws JsonMappingException{
        log.info("TutorService createAddress "+addressDTO.getStreet());
        String tutorId = addressDTO.getTutorId();
        tutorRepository.findById(tutorId)
                .orElseThrow(() -> new RuntimeException("Tutor not found with id " + tutorId));
        Address address = addressRepository.save(addressMapper.addressDTOToAddress(addressDTO));
        return  addressMapper.addressToAddressDTO(address);
    }

    public List<AddressDTO> findAddressesByTutorId(String tutorId) {
        return  addressMapper.addressToAddressDTOs(addressRepository.findByTutorId(tutorId));
    }

    public AddressDTO updateAddress( AddressDTO updatedAddress) throws JsonMappingException {
         addressRepository.findById(updatedAddress.getId())
                .orElseThrow(() -> new RuntimeException("Tutor not found with id " + updatedAddress.getId()));

        Address address = addressRepository.save( addressMapper.addressDTOToAddress(updatedAddress));

        return addressMapper.addressToAddressDTO(address);
    }


}
