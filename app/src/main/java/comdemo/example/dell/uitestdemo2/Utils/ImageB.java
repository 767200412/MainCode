package comdemo.example.dell.uitestdemo2.Utils;


import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImageB extends LinearLayout {
    private ImageView imageView;
    private TextView textView;


    public ImageB(Context context) {
        super(context);
    }

    public ImageB(Context context, AttributeSet attrs) {
        super(context, attrs);
        imageView = new ImageView(context, attrs);//创建对象
        imageView.setPadding(16, 17, 16, 17);//设置内边距

        textView = new TextView(context, attrs);
        textView.setGravity(Gravity.RIGHT);//text居中
        textView.setPadding(16, 30, 42, 22);
        //获取系统自带控件包
        setBackgroundResource(android.R.drawable.btn_default);
        setFocusable(true);//获取焦点
        setClickable(true);//可否点击
        setBackgroundColor(Color.WHITE);//设置背景颜色
        setOrientation(LinearLayout.HORIZONTAL);//指定方向
        addView(imageView);//添加子View(有顺序，先添加先显示)
        addView(textView);
    }

}