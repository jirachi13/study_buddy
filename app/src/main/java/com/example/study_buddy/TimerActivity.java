package com.example.study_buddy;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TimerActivity extends AppCompatActivity {

    private TextView timerDisplay;
    private Button startButton, pauseButton, resetButton;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 25 * 60 * 1000; // 25 minutes
    private boolean isTimerRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        // Initialize UI elements
        timerDisplay = findViewById(R.id.timerDisplay);
        startButton = findViewById(R.id.startButton);
        pauseButton = findViewById(R.id.pauseButton);
        resetButton = findViewById(R.id.resetButton);

        // Start button listener
        startButton.setOnClickListener(v -> startTimer());

        // Pause button listener
        pauseButton.setOnClickListener(v -> pauseTimer());

        // Reset button listener
        resetButton.setOnClickListener(v -> resetTimer());
    }

    private void startTimer() {
        if (!isTimerRunning) {
            countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    timeLeftInMillis = millisUntilFinished;
                    updateTimer();
                }

                @Override
                public void onFinish() {
                    isTimerRunning = false;
                    startButton.setText("Start");
                }
            }.start();
            isTimerRunning = true;
            pauseButton.setVisibility(View.VISIBLE);
        } else {
            countDownTimer.start();
        }
    }

    private void pauseTimer() {
        if (isTimerRunning) {
            countDownTimer.cancel();
            isTimerRunning = false;
        }
    }

    private void resetTimer() {
        countDownTimer.cancel();
        isTimerRunning = false;
        timeLeftInMillis = 25 * 60 * 1000; // Reset to 25 minutes
        updateTimer();
        startButton.setText("Start");
        pauseButton.setVisibility(View.INVISIBLE);
    }

    private void updateTimer() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftText = String.format("%02d:%02d", minutes, seconds);
        timerDisplay.setText(timeLeftText);
    }
}
