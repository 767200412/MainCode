package comdemo.example.dell.uitestdemo2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import comdemo.example.dell.uitestdemo2.R;

public class BuddyAdapter extends BaseExpandableListAdapter {

    private String[] group;
    private String[][] buddy;
    private Context context;
    private LayoutInflater inflater;

    public BuddyAdapter(String[] group, String[][] buddy, Context context) {
        super();
        this.group = group;
        this.buddy = buddy;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return group.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return buddy[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return group[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {

        return buddy[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.group, null);
        TextView groupNameTextView = (TextView) convertView
                .findViewById(R.id.tv_group);
        ImageView ivSelector = (ImageView) convertView
                .findViewById(R.id.iv_selector);
        TextView groupCount = (TextView) convertView.findViewById(R.id.goupCount);
        int count = getChildrenCount(groupPosition);
        groupCount.setText(String.valueOf(count));
        groupNameTextView.setText(getGroup(groupPosition).toString());
        ivSelector.setImageResource(R.mipmap.ic_arrow_left);

        // 更换展开分组图片
        if (!isExpanded) {
            ivSelector.setImageResource(R.mipmap.ic_arrow_left_down);
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.child, null);
        TextView nickTextView = (TextView) convertView
                .findViewById(R.id.tv_child);

        nickTextView.setText(getChild(groupPosition, childPosition).toString());

        return convertView;
    }

    // 子选项是否可以选择
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
