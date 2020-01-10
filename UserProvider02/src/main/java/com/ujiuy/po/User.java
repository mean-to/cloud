package com.ujiuy.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "td_user")
public class User {
@Id
@GeneratedValue
    private Long id;
@Column(name = "name",nullable = false,length = 25)
    private String name;
@Column(name = "age",nullable = false,length = 25)
    private Integer age;

}
