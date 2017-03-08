package comsci.bbuz.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //ประกาศตัวแปล
    ListView listView;
    private int[] ints = new int[]{R.drawable.traffic_01, R.drawable.traffic_02, R.drawable.traffic_03, R.drawable.traffic_04, R.drawable.traffic_05,
                                    R.drawable.traffic_06, R.drawable.traffic_07, R.drawable.traffic_08, R.drawable.traffic_09, R.drawable.traffic_10,
                                    R.drawable.traffic_11, R.drawable.traffic_12, R.drawable.traffic_13, R.drawable.traffic_14, R.drawable.traffic_15,
                                    R.drawable.traffic_16, R.drawable.traffic_17, R.drawable.traffic_18, R.drawable.traffic_19, R.drawable.traffic_20};
    private String[] titleStrings,detailStrings,shorStrings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //intitail view ผูกตัวแปลบนจาวากับไอดีของview
        listView = (ListView) findViewById(R.id.livTraffic);
        //get value
        titleStrings = getResources().getStringArray(R.array.tittle);
        detailStrings = getResources().getStringArray(R.array.detail);
        //SubString detailString ตัดข้อความให้สั้นตามที่ต้องการ
        shorStrings = new String[detailStrings.length]; //จำลองพื้นที่
        for (int i = 0; i < detailStrings.length;i++){
            shorStrings [i] = detailStrings [i] .substring(0,29)+"...";
        } //end for
        //create listview
        MyAdapter myAdapter = new MyAdapter(MainActivity.this,ints,titleStrings,shorStrings);
        listView.setAdapter(myAdapter);

        //active when click list view ลิ้งไปหน้า detail เมื่อเลือก item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int i, long id) { // เมื่อมีการคลิกข้อมูลที่ตำแหน่งใด จะเเก็บข้อมูลจากการคลิก
                                                Intent intent = new Intent(MainActivity.this, Detail.class);
                                                intent.putExtra("Titel", titleStrings[i]);
                                                intent.putExtra("Detail", detailStrings[i]);
                                                intent.putExtra("Image", ints[i]);
                                                startActivity(intent);
                                            }
                                        });
       //main method onCreate


    public void onClickMoreInfo(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.dlt.go.th/th/dlt-knowledge/view.php?_did=111"));
        startActivity(intent);
    }   //main method onClickMoreInfo

}   //main class
