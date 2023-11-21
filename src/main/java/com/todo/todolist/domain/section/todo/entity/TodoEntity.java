package com.todo.todolist.domain.section.todo.entity;

import com.todo.todolist.domain.section.todo.dto.TodoResponseDto;
import com.todo.todolist.domain.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tn_todo")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;

    private String title;

    private String contents;

    private LocalDateTime registerDate;

    private String state;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "username", referencedColumnName = "username")
    UserEntity userEntity;


}
