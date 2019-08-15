package comdemo.example.dell.uitestdemo2.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import comdemo.example.dell.uitestdemo2.R;
import comdemo.example.dell.uitestdemo2.SreachActivity;
import comdemo.example.dell.uitestdemo2.adapter.BuddyAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private ExpandableListView elvCompany;

    private TextView tvLoadMore;
    private HorizontalScrollView hs;
    private LinearLayout ls;
    private TextView title;
    private EditText editText;
    private BuddyAdapter adapter;

    private String[] titleName = new String[]{"客户","供应商","加工商","服务商","物流","客户","客户","客户","客户"};

    // 群组名称（一级条目内容）
    private String[] group ;

    private String[][] carsList;


    public ContactsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactsFragment newInstance(String param1, String param2) {
        ContactsFragment fragment = new ContactsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_contacts, container, false);

        editText = (EditText) view.findViewById(R.id.edit_search);
        // 设置hint字体大小
        SpannableString ss = new SpannableString("请输入关键字");
        AbsoluteSizeSpan ass = new AbsoluteSizeSpan(12, true);
        ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 设置hint
        editText.setHint(new SpannedString(ss)); // 一定要进行转换,否则属性会消失

        hs = (HorizontalScrollView)view.findViewById(R.id.hs);
        ls = (LinearLayout)view.findViewById(R.id.liner);
        initView();


        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    Intent intent = new Intent(getContext(), SreachActivity.class);
                    startActivity(intent);

                }
            }
        });


        //tvLoadMore = (TextView) view.findViewById(R.id.tv_load_more);
        elvCompany = (ExpandableListView) view.findViewById(R.id.android_list);
        //设置子列表的分割线
        //elvCompany.setChildDivider(getResources().getDrawable(R.drawable.child_divider));
        /*
        adapter = new BuddyAdapter(group, carsList, getContext());
        elvCompany.setAdapter(adapter);

        setListeners();


         */
        return view;
    }

    private void setListeners() {
        // 分组展开
        elvCompany.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                return false;
            }
        });
        // 分组关闭
        elvCompany.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {

            }
        });

        // 子项点击
        elvCompany.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(getActivity(),
                        group[groupPosition] + ":" + carsList[childPosition],
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        /*
        tvLoadMore.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "没有更多数据了", Toast.LENGTH_SHORT)
                        .show();

            }
        });
        */

    }

    private void initView(){
        for(int i = 0; i < titleName.length;i++){
            View view = LayoutInflater.from(getContext()).inflate(R.layout.top_item,null);
            title = (TextView)view.findViewById(R.id.titleView);
            title.setText(titleName[i]);
            title.setId(i);
            ls.addView(view);
            title.setOnClickListener(new OnClickListenerImpl());
        }

        /*
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 int id = v.getId();
                Log.e("点击了",String.valueOf(id));
                 //更新

            }
        });

        */
    }


    private class OnClickListenerImpl implements View.OnClickListener{
        @Override
        public void onClick(View v){
            //先把所有的title变成黑色
            title.setTextColor(Color.parseColor("#ff232323"));
            title.setBackground(null);

            int id = v.getId();
           // Log.e("点击了",String.valueOf(id));
            //更新
            title = v.findViewById(id);
           // Log.e("控件为：", String.valueOf(title));
            //修改指定title为按下的颜色
           title.setTextColor(Color.parseColor("#ff238efa"));
           title.setBackgroundResource(R.drawable.top_item_select);
            group = new String[] {"晃光五金"+id,"清顺辅料"+id,"360"+id,"安踏"+id };
            carsList = new String[][]{
                    {"张三", "李四", "王五", "赵六"},
                    {"张三"},
                    {"张三", "李四"},
                    {"张三", "李四", "王五"},
            };



            adapter = new BuddyAdapter(group, carsList, getContext());
            elvCompany.setAdapter(adapter);

            setListeners();
        }
    }

}
