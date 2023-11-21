package com.todo.todolist.domain.section.todo.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="tn_todo")
public class TodoEntity {

    @Id
    private String todoId;

    private String username;

    private String title;

    private String contents;

    private LocalDateTime registerDate;

    // check or uncheck
    private String state;

}
