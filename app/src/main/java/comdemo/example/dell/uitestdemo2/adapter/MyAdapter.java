package comdemo.example.dell.uitestdemo2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import comdemo.example.dell.uitestdemo2.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    //数据源
    private List<String> mList;

    public MyAdapter(List<String> list) {
        mList = list;
    }

    //返回item个数
    @Override
    public int getItemCount() {
        return mList.size() ;
    }

    //创建ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    //填充视图
    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.ViewHolder holder, final int position) {
        holder.mView.setText(mList.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView.findViewById(R.id.item_goods_name);
        }
    }
}
