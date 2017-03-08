package comsci.bbuz.myfirstapp;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //Initial View ฝั่ง View ที่หน้า UI ให้รู้จักกับ java
        TextView titleTextView = (TextView) findViewById(R.id.txtTitleDetail);
        TextView detailTextView = (TextView) findViewById(R.id.txtDetailScro);
        ImageView imageView = (ImageView) findViewById(R.id.imvlmageDetail);
        Button button = (Button) findViewById(R.id.btnBack);
        // Show Data from MainActivity
        titleTextView.setText(getIntent().getStringExtra("Title"));
        detailTextView.setText(getIntent().getStringExtra("Detail"));
        imageView.setImageResource(getIntent().getIntExtra("Image",R.drawable.traffic_01));
    } //Main Method
    public void  clickBack(View view){
        finish();
    }
} //Main Class

