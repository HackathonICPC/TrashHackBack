package org.example.trashhackback.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class UserDao {
    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false)
    String login, password;

    @Column
    Color color = Color.MAGENTA;

    @Column(nullable = false)
    Long experiencePoints = 0L;

    @Column
    @OneToMany(mappedBy = "id")
    List<TaskDao> tasks;

    public boolean hasTask(Long taskID) {
        if (tasks == null) {
            return false; // если список заданий пуст, то задание точно отсутствует
        }

        for (TaskDao userTask : tasks) {
            if (userTask.getId().equals(taskID)) {
                return true; // если находим задание с таким же идентификатором, возвращаем true
            }
        }

        return false; // если не находим задание с таким же идентификатором, возвращаем false
    }

    public void addTask(TaskDao task) {
        if (tasks == null) {
            tasks = new ArrayList<>(); // если список заданий пуст, создаем новый
        }

        task.setCreator(this); // устанавливаем создателя задания

        tasks.add(task); // добавляем новое задание в список заданий пользователя
    }
}