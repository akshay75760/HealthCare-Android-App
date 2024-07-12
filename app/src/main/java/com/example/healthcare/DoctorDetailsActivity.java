package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 = {
        {"Doctor Name: Ajit Sasta","Hospital Address: Pimpri","Exp:7yrs","Mobile No:9898022151","600"},
            {"Doctor Name: Prashad Kumar","Hospital Address: Pune","Exp:8yrs","Mobile No:6204320868","800"},
            {"Doctor Name: Aniket Singh","Hospital Address: Niqdi","Exp:9yrs","Mobile No:8873440011","600"},
            {"Doctor Name: Ashok Panda","Hospital Address: Bhilai","Exp:7yrs","Mobile No:6203100921","500"},
            {"Doctor Name: Deepak Kumar","Hospital Address: Durg","Exp:15yrs","Mobile No:9898022151","1000"}
    };

    private String[][] doctor_details2 = {
            {"Doctor Name: Murali Sachdeva","Hospital Address: Bhilai","Exp:7yrs","Mobile No:8873440011","500"},
            {"Doctor Name:Subhash Biswas","Hospital Address: Pune","Exp:10yrs","Mobile No:9898022151","600"},
            {"Doctor Name: Pran Chander","Hospital Address: Pune","Exp:8yrs","Mobile No:6204320868","600"},
            {"Doctor Name: Dharma Batra","Hospital Address: Bhilai","Exp:7yrs","Mobile No:6203100921","500"},
            {"Doctor Name: Deepak Singh","Hospital Address: Durg","Exp:9yrs","Mobile No: 6121070062","800"}
    };

    private String[][] doctor_details3 = {
            {"Doctor Name: Nishant Singh","Hospital Address: Raipur","Exp:10yrs","Mobile No: 6121070062","600"},
            {"Doctor Name: Jayendra Ramesh","Hospital Address: Nagpur","Exp:8yrs","Mobile No:9898022151","800"},
            {"Doctor Name: Sudarshan Sane","Hospital Address: Bhilai","Exp:5yrs","Mobile No:9898022151","500"},
            {"Doctor Name: Pallav Bhandari","Hospital Address: Bhilai","Exp:7yrs","Mobile No:9898022151","500"},
            {"Doctor Name: Aryan Khosla","Hospital Address: Durg","Exp:13yrs","Mobile No:9898022151","5000"}
    };

    private String[][] doctor_details4 = {
            {"Doctor Name: Punit Khanna","Hospital Address: Durg","Exp:7yrs","Mobile No: 9898022151","600"},
            {"Doctor Name: Vasu Dani","Hospital Address: Pune","Exp:8yrs","Mobile No:  6121070062","800"},
            {"Doctor Name: Ankur Rana","Hospital Address: Raipur","Exp:9yrs","Mobile No: 9898022151","600"},
            {"Doctor Name: Pravin Sodhi","Hospital Address: Raighar","Exp:9yrs","Mobile No: 6203100921","500"},
            {"Doctor Name: Punit Khanna","Hospital Address: Bhilai","Exp:10yrs","Mobile No: 61279 83624","1000"}
    };

    private String[][] doctor_details5 = {
            {"Doctor Name: Surya Bajwa","Hospital Address: Pune","Exp:9yrs","Mobile No: 6121070062","600"},
            {"Doctor Name: Shashi Rai","Hospital Address: Pune","Exp:9yrs","Mobile No: 80782 87261","800"},
            {"Doctor Name: Anah Agrawal","Hospital Address: Durg","Exp:9yrs","Mobile No: 6204320868","600"},
            {"Doctor Name: Dinesh Nagar","Hospital Address: Bhilai","Exp:6yrs","Mobile No: 61279 83624","500"},
            {"Doctor Name: Nirmal Saxena","Hospital Address: Durg","Exp:11yrs","Mobile No: 6203100921","500"}
    };

    String[][] doctor_details={};

    TextView tv;
    Button btn;
    ArrayList list;
    HashMap<String,String> item;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details =doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details =doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details =doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details =doctor_details4;
        else
            doctor_details =doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
                    );
        ListView lst = findViewById(R.id.ListViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppoinmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });

    }
}