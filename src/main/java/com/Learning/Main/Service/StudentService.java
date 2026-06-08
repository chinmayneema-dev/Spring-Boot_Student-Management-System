package com.Learning.Main.Service;

import com.Learning.Main.DTO.AddStudentDTO;
import com.Learning.Main.DTO.StudentDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface StudentService {
    StudentDTO getStudentDetailsByID(Long id);

    StudentDTO addStudent(@Valid AddStudentDTO addStudentDTO);

    List<StudentDTO> getAllStudentDetails();


    StudentDTO updateStudent(Long id, @Valid AddStudentDTO addStudentDTO);

    void deleteStudentByID(Long id);

    StudentDTO updatePartialStudent(Long id, Map<String, Object> updates);
}
