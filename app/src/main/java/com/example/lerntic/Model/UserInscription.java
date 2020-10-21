package com.example.lerntic.Model;

import android.content.Context;
import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.lerntic.CoursesByUserIdQuery;
import com.example.lerntic.CreateInscriptionMutation;
import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.inscription;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.SignUpMutation;
import com.example.lerntic.type.AccountInput;
import com.example.lerntic.type.InscriptionInput;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class UserInscription {

    private final String TAG = "UserInscription";
    public inscription Inscription ;
    public Context context ;

    public UserInscription(inscription Inscription, Context context) {
        this.Inscription = Inscription;
        this.context = context;
        inscripUser(context);
    }

    public synchronized void inscripUser(final Context context) {

        String username = Inscription.getId_usuario();
        int course_id = Inscription.getId_curso();

        InscriptionInput inscriptionInput = InscriptionInput
                .builder()
                .id_curso(course_id)
                .id_usuario(username)
                .max_activity(0)
                .build();

        ApolloConnector.setupApollo().mutate(
                CreateInscriptionMutation
                        .builder()
                        .inscription(inscriptionInput)
                        .build())
                .enqueue(new ApolloCall.Callback<CreateInscriptionMutation.Data>() {

                    @Override
                    public void onResponse(@NotNull Response<CreateInscriptionMutation.Data> response) {
                        CreateInscriptionMutation.CreateInscription data = response.data().createInscription();
                        Inscription.setId(data.id());
                        Inscription.setId_curso(data.id_curso());
                        Inscription.setId_usuario(data.id_usuario());
                        Inscription.setMax_activity(data.max_activity());
                        setInscription(Inscription);
                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        Log.d(TAG, "Exception " + e.getMessage(), e);
                    }
                });

    }

    public void setInscription(inscription Inscription){
        this.Inscription = Inscription;
    }

    public inscription getInscription() {
        return Inscription;
    }

}
