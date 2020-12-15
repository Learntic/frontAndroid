package com.example.lerntic.View

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.lerntic.Model.Objects.ChatMessage
import com.example.lerntic.R
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class Chat2 : AppCompatActivity() {
    private var TextNameChat: TextView? = null
    private var btnBack: Button? = null
    private var btnSentMessage: Button? = null
    private var recycler_Chat: RecyclerView? = null

    companion object {
        val TAG = "ChatLog"
    }

    val adapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat2)

        TextNameChat = findViewById(R.id.TxtNameChat)
        btnBack = findViewById(R.id.BtnBackChat)
        btnSentMessage = findViewById(R.id.btnSentChatlog)

        recycler_Chat = findViewById(R.id.recycler_ChatLog)

        recycler_Chat!!.adapter = adapter

        val userNameB = intent.getStringExtra("userNameB").toString()
        val userNameA = intent.getStringExtra("userNameA").toString()

        Toast.makeText(applicationContext, userNameB+ "-" + userNameA, Toast.LENGTH_LONG).show()

        TextNameChat!!.setText(userNameB)

        listenForMessages(userNameA, userNameB)

        btnSentMessage!!.setOnClickListener {
            Log.d(TAG, "Attempt to sent massage...")
            performSendMassage(userNameA, userNameB)
        }
        btnBack!!.setOnClickListener {
            var intent = Intent(this, friends::class.java)
            intent.putExtra("name", userNameA)
            this.startActivity(intent)
        }
    }
    private fun listenForMessages(UserKeyA: String, UserKeyB: String) {
        val fromId = UserKeyA
        val toId = UserKeyB

        val ref = FirebaseDatabase.getInstance().getReference("/messages-users/$fromId/$toId")
        ref.addChildEventListener(object : ChildEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {

            }

            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                val chatMessage = p0.getValue(ChatMessage::class.java)
                if (chatMessage != null) {
                    Log.d(TAG, chatMessage?.text)

                    if (chatMessage.fromId == UserKeyA && chatMessage.toId == UserKeyB) {
                        adapter.add(
                                ChatItemTo(chatMessage.text
                                )
                        )
                    } else if (chatMessage.fromId == UserKeyB) {
                        adapter.add(
                                ChatItemFrom(
                                        chatMessage.text
                                )
                        )
                    }
                }
            }

            override fun onChildRemoved(p0: DataSnapshot) {
            }
        })
    }
    private fun performSendMassage(UserKeyA: String, UserKeyB: String) {
        //Send a message to firebase

        var textlog = findViewById<TextView>(R.id.txt_chat_log)
        var text = textlog.text.toString()
        val fromId = UserKeyA
        val toId = UserKeyB

        //val reference = FirebaseDatabase.getInstance().getReference("/messages").push()
        val reference =
                FirebaseDatabase.getInstance().getReference("/messages-users/$fromId/$toId").push()
        val referenceto =
                FirebaseDatabase.getInstance().getReference("/messages-users/$toId/$fromId").push()
        val chatMessage =
                ChatMessage(
                        reference.key!!,
                        text,
                        fromId,
                        toId,
                        System.currentTimeMillis() / 1000
                )
        reference.setValue(chatMessage)
                .addOnSuccessListener {
                    Log.d(TAG, "Saved our chat message: ${reference.key}")
                    textlog.setText("")
                    recycler_Chat!!.scrollToPosition(adapter.itemCount - 1)

                }
        referenceto.setValue(chatMessage)
        val latesMessageeRef = FirebaseDatabase.getInstance().getReference("/latest-messages/$toId/$fromId")
        latesMessageeRef.setValue(chatMessage)
    }
}
class ChatItemFrom(val text: String) : Item<GroupieViewHolder>() {
    override fun getLayout(): Int {
        return R.layout.chat_row_from
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.findViewById<TextView>(R.id.textViewFrom).text = text
    }
}

class ChatItemTo(val text: String) : Item<GroupieViewHolder>() {
    override fun getLayout(): Int {
        return R.layout.chat_row_to
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.findViewById<TextView>(R.id.textViewTo).text = text
    }
}


