package com.shijie.pojo.customapp.view.fragment.home;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.shijie.pojo.customapp.R;
import com.shijie.pojo.customapp.adapter.ChatListAdapter;
import com.shijie.pojo.customapp.network.http.HttpConstants;
import com.shijie.pojo.customapp.network.mina.MinaReceiver;
import com.shijie.pojo.customapp.network.mina.SessionManager;
import com.shijie.pojo.customapp.util.L;
import com.shijie.pojo.customapp.view.fragment.BaseFragment;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名: CustomApp
 * 包名: com.shijie.pojo.customapp.view.fragment.home
 * 创建者:  zsj
 * 创建事件: 2017/6/17 10:15
 * 描述:
 */

public class SmartFragment extends BaseFragment implements View.OnClickListener {

    public static String BROADCAST_ACTION = "com.imooc.mina.broadcast";
    public static String MESSAGE = "message";
    private ListView mListView;
    private EditText et_text;
    private TextView tv_send;
    private ChatListAdapter adapter ;
    private List<String> mList = new ArrayList<>();
    private IoSession session;
    /**
     * 负责处理接收到的mina消息
     */
    private MinaReceiver mReceiver;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getActivity();

        new Thread(new Runnable() {
            @Override
            public void run() {
                IoConnector connector = new NioSocketConnector();
                connector.getFilterChain().addLast(
                        "textProtocol",
                        new ProtocolCodecFilter(new TextLineCodecFactory(
                                Charset.forName("UTF-8"), LineDelimiter.WINDOWS
                                .getValue(), LineDelimiter.WINDOWS
                                .getValue())));

                connector.getSessionConfig().setReadBufferSize(1024);
                connector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,
                        10);

                connector.setHandler(new DefaultHandel(mContext));
                // 这里是异步操作 连接后立即返回
                ConnectFuture future = connector.connect(new InetSocketAddress(
                        HttpConstants.MINA_IP2, 4444));
                future.awaitUninterruptibly();// 等待连接创建完成
                session = future.getSession();
            }
        }).start();

        mReceiver = new MinaReceiver(new MinaReceiver.MinaListener() {
            @Override
            public void doHandleMessage(Intent intent) {
                handleMessage(intent);
            }
        });

        registerBroadcast();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_smart_message,null);
        initView(view);
        return view;
    }

    private void initView(View view) {

        mListView = (ListView) view.findViewById(R.id.mListView);
        et_text = (EditText) view.findViewById(R.id.et_text);
        tv_send= (TextView) view.findViewById(R.id.send_message);
        tv_send.setOnClickListener(this);

        adapter = new ChatListAdapter(getActivity(),mList);
        mListView.setAdapter(adapter);
        addLeftItem("你好，我是客服");

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send_message:
                String meaasge = et_text.getText().toString().trim() +"\r\n";
                if (session != null){
                    try {
                        session.write(URLEncoder.encode(meaasge,"UTF-8"));
                        addRightItem(et_text.getText().toString());
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }else {
                    Toast.makeText(mContext, "连接服务端失败", Toast.LENGTH_SHORT).show();
                }
                et_text.setText("");
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterBroadcast();
    }

    private void handleMessage(Intent intent) {
        String message = intent.getStringExtra(MESSAGE);
        Log.e("handleMessage-------", message);
        addLeftItem(message);
    }

    private void registerBroadcast() {

        IntentFilter filter =
                new IntentFilter(BROADCAST_ACTION);
        LocalBroadcastManager.getInstance(mContext)
                .registerReceiver(mReceiver, filter);
    }

    private void unregisterBroadcast() {
        LocalBroadcastManager.getInstance(mContext)
                .unregisterReceiver(mReceiver);
    }
    //添加文字到右边
    private void addRightItem(String str) {

        mList.add(str);
        //刷新listview
        adapter.notifyDataSetChanged();
        //滚动到底部
        mListView.setSelection(mListView.getBottom());
    }
    //添加文字到左边
    private void addLeftItem(String str) {
        mList.add(str);
        //刷新listview
        adapter.notifyDataSetChanged();
        //滚动到底部
        mListView.setSelection(mListView.getBottom());
    }


    private class DefaultHandel extends IoHandlerAdapter {

        private Context mContext;

        private DefaultHandel(Context context) {
            this.mContext = context;
        }

        @Override
        public void sessionOpened(IoSession session) throws Exception {
            if (session != null) {
                SessionManager.getInstance().setSession(session);
            }
        }

        @Override
        public void sessionCreated(IoSession session) throws Exception {
        }

        @Override
        public void messageReceived(IoSession session, Object message) throws Exception {
            if (mContext != null) {
                String result = URLDecoder.decode(message.toString(), "UTF-8");
                L.i("messageReceived------------"+result);
                Intent intent = new Intent(BROADCAST_ACTION);
                intent.putExtra(MESSAGE, result);
                LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);
            }
        }

        @Override
        public void sessionClosed(IoSession session) throws Exception {
            SessionManager.getInstance().removeSession();
        }
    }
}
