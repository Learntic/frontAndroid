package com.example.lerntic.Controller;

import android.content.Context;
import com.example.lerntic.Model.Objects.feedback;
import com.example.lerntic.Model.WriteFeedbackFunc;

public class WriteFeedback_controller {
    public WriteFeedbackFunc writeFeedbackFunc;
    public feedback f;

    public WriteFeedback_controller(){
    }

    public void writeFeedback(feedback feedback,Context context, String token){
        this.f = feedback;
        writeFeedbackFunc = new WriteFeedbackFunc(context, token, f);
    }
}
