package com.example.lerntic.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.lerntic.R;

public class Chat extends AppCompatActivity {


    public TextView TextNameChat = null;
    public Button btnBack;
    public Button btnSentMessage;
    public RecyclerView recycler_ChatLog = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        TextNameChat = findViewById(R.id.TxtNameChat);
        btnBack = findViewById(R.id.BtnBackChat);
        btnSentMessage = findViewById(R.id.btnSentChatlog);

        recycler_ChatLog = findViewById(R.id.recycler_ChatLog);



        String usernameA = getIntent().getStringExtra("UsernameA");
        String usernameB = getIntent().getStringExtra("UsernameB");

        TextNameChat.setText(usernameB);


        listenForMessages(usernameA, usernameB);

    }

    private void listenForMessages(String usernameA, String usernameB) {
        final String fromId = usernameA;
        final String toId = usernameB;

        /*Query ref = FirebaseDatabase.getInstance().getReference("/messages-users/$fromId/$toId");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot p0, @Nullable String p1) {
                ChatMessage chatMessage = p0.getValue(ChatMessage.class);
                if (chatMessage != null) {

                    if (chatMessage.getFromUser() == fromId && chatMessage.getToUser() == toId) {
                        madapter.add(
                                ChatItemTo(
                                        chatMessage.text
                                )
                        )
                    } else if (chatMessage.fromId == UserKeyB) {
                        madapter.add(
                                ChatItemFrom(
                                        chatMessage.text
                                )
                        )
                    }
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        ChatItemFrom from = new ChatItemFrom();
        from.setText("hola");

        ChatItemTo to = new ChatItemTo();
        to.setText("hola 2");

    }
    class ChatItemFrom {
        String text;
        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    class ChatItemTo  {
        String text;
        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }


}
