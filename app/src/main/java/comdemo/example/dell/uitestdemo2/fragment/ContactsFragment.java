package comdemo.example.dell.uitestdemo2.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import comdemo.example.dell.uitestdemo2.R;
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

    // 群组名称（一级条目内容）
    private String[] group = new String[] { "晃光五金","清顺辅料","360","安踏" };

    private String[][] carsList = new String[][] {
            {"张三", "李四", "王五", "赵六"},
            {"张三"},
            {"张三", "李四"},
            {"张三", "李四", "王五"},
    };


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

        //tvLoadMore = (TextView) view.findViewById(R.id.tv_load_more);
        elvCompany = (ExpandableListView) view.findViewById(R.id.android_list);
        BuddyAdapter adapter = new BuddyAdapter(group, carsList, getContext());
        elvCompany.setAdapter(adapter);

        setListeners();

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



}
