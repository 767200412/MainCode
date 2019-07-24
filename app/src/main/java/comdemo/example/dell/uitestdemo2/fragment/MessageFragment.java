package comdemo.example.dell.uitestdemo2.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import comdemo.example.dell.uitestdemo2.ChatViewActivity;
import comdemo.example.dell.uitestdemo2.R;
import comdemo.example.dell.uitestdemo2.adapter.CollectRecycleAdapter;
import comdemo.example.dell.uitestdemo2.adapter.MyAdapter;
import comdemo.example.dell.uitestdemo2.bean.GoodsEntity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MessageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MessageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private View view;//定义view用来设置fragment的layout
    public RecyclerView mCollectRecyclerView;//定义RecyclerView
    //定义以goodsentity实体类为对象的数据集合
    private ArrayList<GoodsEntity> goodsEntityList = new ArrayList<GoodsEntity>();
    //自定义recyclerveiw的适配器
    private CollectRecycleAdapter mCollectRecyclerAdapter;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public MessageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MessageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MessageFragment newInstance(String param1, String param2) {
        MessageFragment fragment = new MessageFragment();
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

        view = inflater.inflate(R.layout.fragment_message, container, false);
        //对recycleview进行配置
        initRecyclerView();
        //模拟数据
        initData();
        return view;
    }

    /**
     * TODO 模拟数据
     */
    private void initData() {
        /*for (int i=0;i<10;i++){
            GoodsEntity goodsEntity=new GoodsEntity();
            goodsEntity.setGoodsName("模拟数据"+i);
            goodsEntity.setGoodsPrice("100"+i);
            goodsEntityList.add(goodsEntity);
        }*/
        GoodsEntity goodsEntity=new GoodsEntity();
        goodsEntity.setImgPath(R.mipmap.ic_notice_up_down);
        goodsEntity.setGoodsName("关系管理助手");
        goodsEntity.setGoodsPrice("[自定义消息]");
        goodsEntityList.add(goodsEntity);
        GoodsEntity goodsEntity2=new GoodsEntity();
        goodsEntity2.setImgPath(R.mipmap.ic_notice_system);
        goodsEntity2.setGoodsName("系统通知");
        goodsEntity2.setGoodsPrice("[系统通知]");
        goodsEntityList.add(goodsEntity2);
        GoodsEntity goodsEntity3=new GoodsEntity();
        goodsEntity3.setImgPath(R.mipmap.ic_notice_items);
        goodsEntity3.setGoodsName("代办事项");
        goodsEntity3.setGoodsPrice("[自定义消息]");
        goodsEntityList.add(goodsEntity3);
        GoodsEntity goodsEntity4=new GoodsEntity();
        goodsEntity4.setImgPath(R.mipmap.ic_notice_inform);
        goodsEntity4.setGoodsName("通知助手助手");
        goodsEntity4.setGoodsPrice("[系统通知]");
        goodsEntityList.add(goodsEntity4);


    }

    /**
     * TODO 对recycleview进行配置
     */

    private void initRecyclerView() {
        //获取RecyclerView
        mCollectRecyclerView=(RecyclerView)view.findViewById(R.id.collect_recyclerView);
        //创建adapter
        mCollectRecyclerAdapter = new CollectRecycleAdapter(getActivity(), goodsEntityList);
        //给RecyclerView设置adapter
        mCollectRecyclerView.setAdapter(mCollectRecyclerAdapter);
        //设置layoutManager,可以设置显示效果，是线性布局、grid布局，还是瀑布流布局
        //参数是：上下文、列表方向（横向还是纵向）、是否倒叙
        mCollectRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //设置item的分割线
        mCollectRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        //RecyclerView中没有item的监听事件，需要自己在适配器中写一个监听事件的接口。参数根据自定义
        mCollectRecyclerAdapter.setOnItemClickListener(new CollectRecycleAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, GoodsEntity data) {
                //此处进行监听事件的业务处理
               // Toast.makeText(getActivity(),"我是item", Toast.LENGTH_SHORT).show();
                Intent intent;
                intent = new Intent(getActivity(), ChatViewActivity.class);
                startActivity(intent);
            }
        });
    }


}
