package com.example.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<>();

    private EditText editText;

    private RecyclerView recyclerView;

    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();
        editText = findViewById(R.id.input_text_view);
        recyclerView = findViewById(R.id.msg_recycler_view);
        send = findViewById(R.id.send);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        final MsgAdapter adapter = new MsgAdapter(msgList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if (!text.trim().equals("")) {
                    msgList.add(new Msg(text, Msg.TYPE_SENT));
                    adapter.notifyItemInserted(msgList.size() - 1);
                    recyclerView.scrollToPosition(msgList.size() - 1);
                }
                editText.setText("");
            }
        });
    }

    private void initMsgs() {
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            int type;
            int num = rand.nextInt();
            if (num % 2 == 0) {
                type = Msg.TYPE_SENT;
            } else {
                type = Msg.TYPE_RECEIVED;
            }
            msgList.add(new Msg("Msg " + Integer.toString(num), type));
        }
    }
}
