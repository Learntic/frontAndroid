package com.example.lerntic.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lerntic.Controller.WriteFeedback_controller;
import com.example.lerntic.Model.Objects.feedback;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.R;

import androidx.appcompat.app.AppCompatActivity;

public class WriteFeedback extends AppCompatActivity {

    public com.example.lerntic.Model.Objects.user User = new user();

    public EditText opinion = null;
    public EditText nota = null;
    public Button botonEnviar = null;

    private WriteFeedback_controller writeFeedback_controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String username = getIntent().getStringExtra("Username");
        final String token = getIntent().getStringExtra("Token");
        String courseId = getIntent().getStringExtra("course_id");
        opinion =  findViewById(R.id.et_opinionFeedback);
        nota = findViewById(R.id.et_notaFeedback);
        feedback f = new feedback(-1, username, Integer.parseInt(courseId), opinion.getText().toString(), Integer.parseInt(nota.getText().toString()));
        writeFeedback_controller = new WriteFeedback_controller(f);
        botonEnviar =  findViewById(R.id.btn_enviarFeedback);

        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeFeedback_controller.writeFeedback(getApplicationContext(), token);
                }
        });

    }


}
