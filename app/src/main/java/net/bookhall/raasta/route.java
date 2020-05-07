package net.bookhall.raasta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class route extends AppCompatActivity {
    String msource,mdestination;
    TextView textView;
    ImageView imageView;
    int a=3,b=2,c=1,d=5,e=4,f=2,g=3,h=1,i=2,j=3,k=4,l=2,m=3,n=1,o=5,p=6,q=1,r=7,s=8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        textView = (TextView)findViewById(R.id.textView4);
        imageView = (ImageView)findViewById(R.id.imageView);

        msource = getIntent().getExtras().getString("sour");
        mdestination = getIntent().getExtras().getString("dest");

       if(msource.equals("New Delhi")){
           if(mdestination.equals("Rajiv chowk")){
              textView.setText("Shortest route from "+msource+" to "+mdestination+" will take "+a+"minutes");
           }
           if(mdestination.equals("Central Secretriat")) {

               if ((a + s) <= (a + b + r)) {
                   textView.setText("Shortest route from " + msource + " to " + mdestination + " will take " + (a + s) + "minutes");
               } else {
                   textView.setText("Shortest route from " + msource + " to " + mdestination + " will take " + (a + b + r) + "minutes");
               }
           }
               if(mdestination.equals("Dilli Hat-INA")){
                   if((a+s+p)<(a+r+b+q+o)){
                       textView.setText("Shortest route from " + msource + " to " + mdestination + " will take " + (a + s+p) + "minutes");
                   }
                   else{
                       textView.setText("Shortest route from " + msource + " to " + mdestination + " will take " + (a +r+b+q+o) + "minutes");
                   }
               }
               if(mdestination.equals("Hauj Khas")){
                   if((a+b+r+q+o+n)<(a+b+r+q+l+m)){
                       if((a+s+p+n)<(a+b+r+q+o+n)){
                       textView.setText("Shortest route from " + msource + " to " + mdestination + " will take " + (a+s+p+n) + "minutes");
                   }
                       else{
                           textView.setText("Shortest route from " + msource + " to " + mdestination + " will take " + (a+b+r+q+o+n) + "minutes");
                       }
               }
               }
                   else{

                       if((a+s+p+n)<(a+b+r+q+l+m)){
                           textView.setText("Shortest route from " + msource + " to " + mdestination + " will take " + (a+s+p+n) + "minutes");
                       }
                       else{
                           textView.setText("Shortest route from " + msource + " to " + mdestination + " will take " + (a+b+r+q+l+m) + "minutes");
                       }
                   }



    }
}}
