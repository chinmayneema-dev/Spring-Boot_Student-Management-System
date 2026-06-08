package com.Learning.Main.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = "rollno")
)
@Getter
@Setter
@ToString
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int rollno;
    private float marks;
}
