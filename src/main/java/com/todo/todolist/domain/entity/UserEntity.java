package com.todo.todolist.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tn_user")
public class UserEntity{

    @Id
    private String userEmail;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String role;

}
