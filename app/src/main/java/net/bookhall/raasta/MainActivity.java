package net.bookhall.raasta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String[] station = new String[]{"New Delhi","Rajiv chowk","Mandi House","Central Secretriat","Dilli Hat-INA","Mayur Vihar Phase-1","Karkardumba","Anand Vihar","Yamuna Bank","Vaishali","Lajpath nagar","Kalkaji Mandir","Hauz Khas","Botanical Garden",""};
    Button route;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AutoCompleteTextView source = findViewById(R.id.autoCompleteTextView2);
        final ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,station);
        source.setAdapter(adapter);

        final AutoCompleteTextView destination = findViewById(R.id.autoCompleteTextView3);
        destination.setAdapter(adapter);

        route = findViewById(R.id.button);
        route.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String msource = source.getText().toString();
               String mdestination = destination.getText().toString();



                if(TextUtils.isEmpty(msource)){
               source.setError("This Field Cannot be empty");
                }
                if(TextUtils.isEmpty(mdestination)) {
                    destination.setError("This Field Cannot be empty");
                }

                Intent i = new Intent(MainActivity.this,route.class);

                i.putExtra("sour",msource);
                i.putExtra("dest",mdestination);

                startActivity(i);

            }
        });

    }
}
