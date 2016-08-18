package bwf.demo_scroll_message_textview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2016/8/13.
 */
public class MyAdapter extends BaseAdapter{
    private List<Data> datas;
    private Context Context;

    public MyAdapter(List<Data> datas, Context Context) {
        this.datas = datas;
        this.Context = Context;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,null);
        }
        TextView nameTv = (TextView) convertView.findViewById(R.id.user);
        TextView goodsTv = (TextView) convertView.findViewById(R.id.goods);
        final Data data = datas.get(position % datas.size());
        nameTv.setText(data.name);
        goodsTv.setText(data.goodsName);
        convertView.findViewById(R.id.layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Context, ""+data.name, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
