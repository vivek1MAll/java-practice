package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    //    private static final String TAG="MAinActivity";
    TextView textView;
    Button button;
    ProgressBar switch1;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        switch1 = findViewById(R.id.progressBar2);
        ExecutorService service = Executors.newSingleThreadExecutor();

        button.setOnClickListener(v -> {
            service.execute(() -> {
//                    background task //doin background
                while (true) {
                    Log.e("######", "run");
                }
            });
            runOnUiThread(() -> {
//                    on post execute
                textView.setText("vivek");
            });
        });
    }

    public void uploadTask(View view) {

        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show();
        UploadTask uploadTask = new UploadTask();
        uploadTask.execute("this is my string");

    }

    static class UploadTask extends AsyncTask<String, Void, Void> {
        private Object String;


        protected Void doInBackground(String... voids) {
            Log.i("do in background", "string passed");
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }


}
