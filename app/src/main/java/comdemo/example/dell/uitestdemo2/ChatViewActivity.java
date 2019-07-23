package comdemo.example.dell.uitestdemo2;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import comdemo.example.dell.uitestdemo2.adapter.MsgAdapter;
import comdemo.example.dell.uitestdemo2.bean.Msg;

public class ChatViewActivity extends AppCompatActivity {

    private ListView msgListView;
    private EditText inputText;
    private Button send;
    private ImageButton mImBtnface,mImBtnAdd;
    private LinearLayout linearLayout;
    private MsgAdapter adapter;

    private List<Msg> msgList = new ArrayList<Msg>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_view);



        initMsgs();
        adapter = new MsgAdapter(ChatViewActivity.this, R.layout.msg_item, msgList);
        inputText = (EditText)findViewById(R.id.et_content);
        send = (Button)findViewById(R.id.bt_send);
        msgListView = (ListView) findViewById(R.id.rv_chatList);
        msgListView.setAdapter(adapter);
        mImBtnAdd = (ImageButton)findViewById(R.id.imageButton3);
        mImBtnface = (ImageButton)findViewById(R.id.imageButton2);
        linearLayout = (LinearLayout)findViewById(R.id.linearLayout2);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                if(!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();
                    msgListView.setSelection(msgList.size());
                    inputText.setText("");
                }
            }
        });

        //点击加号 弹出菜单显示。
        mImBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(linearLayout.getVisibility() == View.GONE ) {
                       //显示底部菜单
                    linearLayout.setVisibility(View.VISIBLE);
                }
                else{
                      //隐藏菜单
                    linearLayout.setVisibility(View.GONE);
                }
            }
        });

        inputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               //Log.e("输入","onText"+s);
                if(s !=""){
                        //有输入，按钮可见 加号不可见
                        mImBtnAdd.setVisibility(View.GONE);
                        send.setVisibility(View.VISIBLE);
                }
                else {
                   // Log.e("为空:","s");
                    //没有输入 按钮不可见
                    mImBtnAdd.setVisibility(View.VISIBLE);
                    send.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
               // Log.e("输入框内容：",s.toString());
                if(s.toString().equals(""))
                {
                    //Log.e("为空:","s");
                    //没有输入 按钮不可见
                    mImBtnAdd.setVisibility(View.VISIBLE);
                    send.setVisibility(View.GONE);
                }
            }
        });
    }

    private void initMsgs() {
        Msg msg1 = new Msg("Hello, how are you?", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Fine, thank you, and you?", Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3 = new Msg("I am fine, too!", Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }


}
