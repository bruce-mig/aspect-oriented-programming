package com.github.bruce_mig.aspect_oriented_programming.model;

import com.github.bruce_mig.aspect_oriented_programming.annotations.SensitiveField;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_user")
public class User {

    @Id
    private Integer id;
    private String name;

    @SensitiveField
    private Integer age;
}
