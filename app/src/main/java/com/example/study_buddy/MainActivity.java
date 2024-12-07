package com.example.study_buddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button taskManagerButton, pomodoroButton, addTaskButton, addNoteButton, calendarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        taskManagerButton = findViewById(R.id.taskManagerButton);
        pomodoroButton = findViewById(R.id.pomodoroButton);
        addTaskButton = findViewById(R.id.addTaskButton);
        addNoteButton = findViewById(R.id.addNoteButton);
        calendarButton = findViewById(R.id.calendarButton);

        // Task Manager button
        taskManagerButton.setOnClickListener(v -> openTaskManager());

        // Pomodoro Timer button
        pomodoroButton.setOnClickListener(v -> openPomodoroTimer());

        // Add Task button
        addTaskButton.setOnClickListener(v -> openAddTask());

        // Add Note button
        addNoteButton.setOnClickListener(v -> openAddNote());

        // Calendar button
        calendarButton.setOnClickListener(v -> openCalendar());
    }

    // Methods to navigate to respective activities
    private void openTaskManager() {
        Intent intent = new Intent(this, TaskManagerActivity.class);
        startActivity(intent);
    }

    private void openPomodoroTimer() {
        Intent intent = new Intent(this, TimerActivity.class);
        startActivity(intent);
    }

    private void openAddTask() {
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivity(intent);
    }

    private void openAddNote() {
        Intent intent = new Intent(this, AddNoteActivity.class);
        startActivity(intent);
    }

    private void openCalendar() {
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }
}
