package com.todo.todolist.domain.section.todo.entity;

import com.todo.todolist.domain.section.todo.dto.TodoDto;
import com.todo.todolist.domain.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todo_list")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;

    @Column(name = "contents", nullable = false, length = 100)
    private String contents;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column
    private boolean status;

    @ManyToOne()
    @JoinColumn(name = "id", referencedColumnName = "id")
    UserEntity userEntity;

    public TodoDto toDto() {

        return TodoDto.builder()
                .todoId(todoId)
                .contents(contents)
                .createDate(createDate)
                .status(status)
                .build();
    }

}
