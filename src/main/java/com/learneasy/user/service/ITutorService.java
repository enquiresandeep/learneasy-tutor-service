package com.learneasy.user.service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.learneasy.user.infrastructure.dto.AddressDTO;
import com.learneasy.user.infrastructure.dto.TutorDTO;

import java.util.List;

public interface ITutorService {
    public TutorDTO createTutor(TutorDTO tutor) throws Exception;

    public TutorDTO findTutorByTutorId(String tutorId);

    public TutorDTO updateTutor(TutorDTO updatedTutor) throws JsonMappingException ;
    public List<TutorDTO> findAll();

    public AddressDTO createAddress(AddressDTO address) throws JsonMappingException;

    public List<AddressDTO> findAddressesByTutorId(String tutorId) ;

    public AddressDTO updateAddress( AddressDTO updatedAddress) throws JsonMappingException ;
}
