package com.shijie.pojo.customapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shijie.pojo.customapp.R;

import java.util.List;


/**
 * 项目名: SmartApp
 * 包名: com.example.pojo.smartapp.adapter
 * 创建者:  zsj
 * 创建事件: 2017/4/13 16:06
 * 描述:
 */

public class ChatListAdapter extends BaseAdapter{

    //左边的type
    public static final int VALUE_LEFT_TEXT = 1;
    //右边的type
    public static final int VALUE_RIGHT_TEXT = 2;

    private Context mContext;
    private List<String> mList;
    private LayoutInflater inflater;

    public ChatListAdapter(Context mContext, List<String> mList){
        this.mContext = mContext;
        this.mList = mList;
        //获取系统服务
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderLeft viewHolderLeft = null;
        ViewHolderRight viewHolderRight = null;
        //获取当前要显示的type 根据这个type来区分数据的加载
        int type = getItemViewType(position);

        if (convertView == null){
            switch (type){
                case  VALUE_LEFT_TEXT:
                    viewHolderLeft = new ViewHolderLeft();
                    convertView = inflater.inflate(R.layout.chat_item_left,null);
                    viewHolderLeft.tv_left_text= (TextView) convertView.findViewById(R.id.tv_left_text);
                    convertView.setTag(viewHolderLeft);
                    break;
                case  VALUE_RIGHT_TEXT:
                    viewHolderRight = new ViewHolderRight();
                    convertView = inflater.inflate(R.layout.chat_item_right,null);
                    viewHolderRight.tv_right_text= (TextView) convertView.findViewById(R.id.tv_right_text);
                    viewHolderRight.iv_right = (ImageView) convertView.findViewById(R.id.iv_right);
                    convertView.setTag(viewHolderRight);
                    break;
            }
        }else {
            switch (type){
                case  VALUE_LEFT_TEXT:
                    viewHolderLeft = (ViewHolderLeft) convertView.getTag();
                    break;
                case  VALUE_RIGHT_TEXT:
                    viewHolderRight = (ViewHolderRight) convertView.getTag();
                    break;
            }

        }

        //赋值
         String data = mList.get(position);
         switch (type){
             case  VALUE_LEFT_TEXT:
                 viewHolderLeft.tv_left_text.setText(data);
                 break;
             case  VALUE_RIGHT_TEXT:
                 viewHolderRight.tv_right_text.setText(data);
                 break;
         }

        return convertView;
    }
   //根据数据源的positiion来返回要显示的item
    @Override
    public int getItemViewType(int position) {
        if (position%2 != 0){
            return VALUE_RIGHT_TEXT;
        }else {
            return VALUE_LEFT_TEXT;
        }
    }
    //返回所有的layout数据
    @Override
    public int getViewTypeCount() {
        return 3;
    }
    //左边的数据
    class  ViewHolderLeft{
       private TextView tv_left_text;
    }
    class  ViewHolderRight{
        private  TextView tv_right_text;
        private ImageView iv_right;
    }
}
