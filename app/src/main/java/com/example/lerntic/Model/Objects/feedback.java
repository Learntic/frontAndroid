package com.example.lerntic.Model.Objects;

public class feedback {

    int id;
    String id_usuario;
    int id_curso;
    String opinion;
    double nota;

    public feedback(int id, String id_usuario, int id_curso, String opinion, double nota) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.id_curso = id_curso;
        this.opinion = opinion;
        this.nota = nota;
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

    public String getOpinion() {
        return opinion;
    }

    public double getNota() {
        return nota;
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

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
