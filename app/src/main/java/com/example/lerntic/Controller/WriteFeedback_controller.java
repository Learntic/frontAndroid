package com.example.lerntic.Controller;

import android.content.Context;
import com.example.lerntic.Model.Objects.feedback;
import com.example.lerntic.Model.WriteFeedbackFunc;

public class WriteFeedback_controller {
    public WriteFeedbackFunc writeFeedbackFunc;
    public feedback f;

    public WriteFeedback_controller(feedback fi){
        this.f = fi;
    }

    public void writeFeedback(Context context, String token){
        writeFeedbackFunc = new WriteFeedbackFunc(context, token, f);
        writeFeedbackFunc.writeFeedback(context);
    }
}
