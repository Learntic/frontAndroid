package com.example.lerntic.Model.Objects;

public class temario {

    int topic_id;
    String topic_description;
    String topic_name;

    public temario(int topic_id, String topic_description, String topic_name) {
        this.topic_id = topic_id;
        this.topic_description = topic_description;
        this.topic_name = topic_name;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public String getTopic_description() {
        return topic_description;
    }

    public void setTopic_description(String topic_description) {
        this.topic_description = topic_description;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

}
