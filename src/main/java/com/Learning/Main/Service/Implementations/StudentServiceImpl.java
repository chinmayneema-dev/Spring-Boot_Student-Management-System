package com.Learning.Main.Service.Implementations;

import com.Learning.Main.DTO.AddStudentDTO;
import com.Learning.Main.DTO.StudentDTO;
import com.Learning.Main.Entity.Students;
import com.Learning.Main.Repository.StudentRepository;
import com.Learning.Main.Service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public StudentDTO getStudentDetailsByID(Long id){
        Students std= studentRepository.findById(id).orElseThrow();
        return modelMapper.map(std, StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getAllStudentDetails() {
        List<Students> stdList= studentRepository.findAll();
        return stdList.stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .toList();
    }


    @Override
    public StudentDTO addStudent(AddStudentDTO addStudentDTO) {
        Students newStd= modelMapper.map(addStudentDTO, Students.class);
        Students student= studentRepository.save(newStd);
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public StudentDTO updateStudent(Long id, AddStudentDTO addStudentDTO) {
        Students student= studentRepository.findById(id).orElseThrow();
        modelMapper.map(addStudentDTO, student);
        student= studentRepository.save(student);
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public void deleteStudentByID(Long id) {
        studentRepository.findById(id).orElseThrow();
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO updatePartialStudent(Long id, Map<String, Object> updates) {
        Students student= studentRepository.findById(id).orElseThrow();
        updates.forEach((fields, value)->{
            switch (fields){
                case "name":
                    student.setName((String) value);
                    break;
                case "rollno":
                    student.setRollno((Integer) value);
                    break;
                case "marks":
                    student.setMarks(((Number) value).floatValue());
                    break;
            }
        });
        Students newStd= studentRepository.save(student);
        return modelMapper.map(newStd, StudentDTO.class);
    }
}
