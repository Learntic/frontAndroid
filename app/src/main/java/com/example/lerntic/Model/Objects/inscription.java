package com.example.lerntic.Model.Objects;

public class inscription {

    int id;
    String id_usuario;
    int id_curso;
    int max_activity;

    public inscription(int id, String id_usuario, int id_curso, int max_activity) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.id_curso = id_curso;
        this.max_activity = max_activity;
    }

    public inscription() {

    }

    public int getId() {
        return id;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public int getId_curso() {
        return id_curso;
    }

    public int getMax_activity() {
        return max_activity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public void setMax_activity(int max_activity) {
        this.max_activity = max_activity;
    }
}
