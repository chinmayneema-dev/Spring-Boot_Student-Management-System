package com.Learning.Main.DTO;

import lombok.*;

//@Getter
//@Setter
//@ToString     in place of all 3 we can write @Data
@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentDTO {
    private int rollno;
    private String name;
    private float marks;
}
