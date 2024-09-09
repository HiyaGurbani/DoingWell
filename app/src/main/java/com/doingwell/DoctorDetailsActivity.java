package com.doingwell;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    TextView tv;
    Button btn;
    String [][] doctor_details = {};
    ArrayList<HashMap<String,String>> list;
    HashMap<String,String> item;
    SimpleAdapter sa;
    private String[][] doctor_details1 = {
            {"Doctor Name : Ajit Kapoor", "Hospital Address: Pimpri", "Exp : 5yrs", "Mobile No. : 8568893981", "600"},
            {"Doctor Name : Radhika Sharma", "Hospital Address: Wakad", "Exp : 8yrs", "Mobile No. : 9876543210", "750"},
            {"Doctor Name : Sameer Desai", "Hospital Address: Hinjewadi", "Exp : 10yrs", "Mobile No. : 9988776655", "800"},
            {"Doctor Name : Neha Verma", "Hospital Address: Baner", "Exp : 3yrs", "Mobile No. : 9123456789", "550"},
            {"Doctor Name : Kunal Joshi", "Hospital Address: Aundh", "Exp : 7yrs", "Mobile No. : 9876123456", "700"}
    };
    private String[][] doctor_details2 = {
            {"Doctor Name : Priya Nair", "Hospital Address: Kothrud", "Exp : 12yrs", "Mobile No. : 9823456789", "850"},
            {"Doctor Name : Amit Bansal", "Hospital Address: Viman Nagar", "Exp : 4yrs", "Mobile No. : 9812345678", "600"},
            {"Doctor Name : Sneha Patil", "Hospital Address: Hadapsar", "Exp : 9yrs", "Mobile No. : 9876543211", "780"},
            {"Doctor Name : Vikram Malhotra", "Hospital Address: Kharadi", "Exp : 15yrs", "Mobile No. : 9123987654", "900"},
            {"Doctor Name : Manisha Gupta", "Hospital Address: Shivaji Nagar", "Exp : 6yrs", "Mobile No. : 9988774455", "650"}
    };
    private String[][] doctor_details3 = {
            {"Doctor Name : Rohan Mehta", "Hospital Address: Camp", "Exp : 7yrs", "Mobile No. : 9123451234", "700"},
            {"Doctor Name : Kavita Singh", "Hospital Address: Deccan", "Exp : 11yrs", "Mobile No. : 9234567890", "820"},
            {"Doctor Name : Ankit Roy", "Hospital Address: Koregaon Park", "Exp : 5yrs", "Mobile No. : 9876543120", "750"},
            {"Doctor Name : Swati Kulkarni", "Hospital Address: Pashan", "Exp : 8yrs", "Mobile No. : 9198765432", "720"},
            {"Doctor Name : Aditya Khanna", "Hospital Address: Balewadi", "Exp : 3yrs", "Mobile No. : 9812341234", "600"}
    };
    private String[][] doctor_details4 = {
            {"Doctor Name : Deepak Verma", "Hospital Address: Nigdi", "Exp : 14yrs", "Mobile No. : 9123123123", "880"},
            {"Doctor Name : Aisha Khan", "Hospital Address: Magarpatta", "Exp : 6yrs", "Mobile No. : 9321456789", "670"},
            {"Doctor Name : Rahul Deshmukh", "Hospital Address: Swargate", "Exp : 9yrs", "Mobile No. : 9456123890", "740"},
            {"Doctor Name : Suman Mishra", "Hospital Address: Kalyani Nagar", "Exp : 13yrs", "Mobile No. : 9234567123", "850"},
            {"Doctor Name : Varun Sinha", "Hospital Address: Yerawada", "Exp : 4yrs", "Mobile No. : 9112345678", "620"}
    };
    private String[][] doctor_details5 = {
            {"Doctor Name : Meera Iyer", "Hospital Address: Bavdhan", "Exp : 11yrs", "Mobile No. : 9898981234", "800"},
            {"Doctor Name : Rohit Saxena", "Hospital Address: Warje", "Exp : 7yrs", "Mobile No. : 9812345123", "700"},
            {"Doctor Name : Anjali Pandey", "Hospital Address: Model Colony", "Exp : 10yrs", "Mobile No. : 9945678912", "790"},
            {"Doctor Name : Arjun Rao", "Hospital Address: Karve Nagar", "Exp : 5yrs", "Mobile No. : 9876549876", "720"},
            {"Doctor Name : Sunita Bhatt", "Hospital Address: Bibwewadi", "Exp : 8yrs", "Mobile No. : 9012345678", "750"}
    };

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonLtBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else if (title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else if (title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else if (title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
           }
        });

        list = new ArrayList<>();
        for (int i=0 ; i<doctor_details.length ; i++){
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons. Fees"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.ListViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
};
