package comsci.bbuz.myfirstapp;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by bus on 23/2/2560.
 */
//Activityนี้สร้างเพื่อทำlayoutเสมือนเพื่อนำไปแสดงผลหน้าmain
public class MyAdapter extends BaseAdapter {
    //Explicit
    private Context context;
    private int[] ints;
    private String[] titleStrings,detailStrings;

    public MyAdapter(Context context, int[] ints, String[] titleStrings, String[] detailStrings) {
        this.context = context;
        this.ints = ints;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;
    }

    @Override
    public int getCount() { //ใช้นับจำนวนข้อมูล แล้วส่งไปทำงานต่อที่getview
        return ints.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) { //รับจำนวนข้อมูล แล้วส่งไปทำงานบนแอพ
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.my_listview,viewGroup,false);

        //initial view
        ImageView imageView = (ImageView) view1.findViewById(R.id.imvIcon);
        TextView titleTextView = (TextView) view1.findViewById(R.id.txtTittleLiv);
        TextView detailTextView = (TextView) view1.findViewById(R.id.txtDetailLiv);
        //Show view นำข้อมูลไปแสดงผลบนหน้าแอพ
        imageView.setImageResource(ints[i]);
        titleTextView.setText(titleStrings[i]);
        detailTextView.setText(detailStrings[i]);

        return view1;
    }
} //main class
