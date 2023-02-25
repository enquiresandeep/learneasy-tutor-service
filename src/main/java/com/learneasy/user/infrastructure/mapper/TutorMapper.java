package com.learneasy.user.infrastructure.mapper;

import com.learneasy.user.domain.Tutor;
import com.learneasy.user.infrastructure.dto.TutorDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TutorMapper {

    TutorDTO tutorToTutorDTO(Tutor tutor);
    Tutor tutorDTOToTutor(TutorDTO tutorDTO);

     List<TutorDTO> tutorToTutorDTOs(List<Tutor> tutors);

     List<Tutor> tutorDTOToTutors(List<TutorDTO> tutorDTOS);


}
