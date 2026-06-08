package com.Learning.Main.Controller;

import com.Learning.Main.DTO.AddStudentDTO;
import com.Learning.Main.DTO.StudentDTO;
import com.Learning.Main.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public StudentDTO getStudentDetailsByID(@PathVariable Long id){
        return studentService.getStudentDetailsByID(id);
    }

    @GetMapping("/")
    public List<StudentDTO> getAllStudentDetails(){
        return studentService.getAllStudentDetails();
    }

    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@RequestBody @Valid AddStudentDTO addStudentDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(addStudentDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody @Valid AddStudentDTO addStudentDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.updateStudent(id, addStudentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentByID(@PathVariable Long id){
        studentService.deleteStudentByID(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDTO> updatePartialStudent(@PathVariable Long id, @RequestBody Map<String, Object> updates){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.updatePartialStudent(id, updates));
    }
}
