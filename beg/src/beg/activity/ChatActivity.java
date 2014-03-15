package beg.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class ChatActivity extends BegActivity {

    private ArrayAdapter chatAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.chat);

        chatAdapter = new ArrayAdapter<String>(this,R.layout.chat_list_item);

        getChatListView().setAdapter(chatAdapter);
        removeChatListLineSeparator();

        findViewById(R.id.chat_button_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = getChatMessage();
                //TODO qui viene inviato il messaggio tramite le API al destinatario
                if(msg != ""){
                    displayMsg(msg);
                    getChatEditText().setText("");
                }
            }
        });
    }

    private void displayMsg(String msg)
    {
        chatAdapter.add(msg);
        getChatListView().setAdapter(chatAdapter);
    }

    private EditText getChatEditText() {
        return (EditText) findViewById(R.id.chat_editText);
    }

    private void removeChatListLineSeparator() {
        getChatListView().setDivider(null);
        getChatListView().setDividerHeight(0);
    }

    private ListView getChatListView() {
        return (ListView) findViewById(R.id.chat_listView);
    }

    private String getChatMessage() {
        return getChatEditText().getText().toString();
    }
}