package net.bookhall.raasta;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomControls;

public class route extends AppCompatActivity {
    String msource,mdestination;
    TextView textView;

    ImageButton back;
    Dialog myinfo,mymap;

    private static final int NO_PARENT = -1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);


        setupUI();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        int[][] adjacencyMatrix = {{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 4, 0, 0, 0},
                {0, 0, 2, 1, 0, 1, 0, 0, 0, 3, 0, 0, 0, 0},
                {0, 1, 3, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 3, 0, 1, 0, 3, 0, 3, 0},
                {0, 0, 0, 0, 0, 4, 0, 0, 0, 3, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        };

        if(msource.equals("New Delhi")){
            int a = 0;
            dijkstra(adjacencyMatrix, a);
        }
        else if(msource.equals("Rajiv Chowk")){
            int a = 1;
            dijkstra(adjacencyMatrix, a);
        }
        else if(msource.equals("Central Secretriat")){
            int a = 2;
            dijkstra(adjacencyMatrix, a);
        }
        else if(msource.equals("Dilli Hat-INA")){
            int a = 3;
            dijkstra(adjacencyMatrix, a);
        }
        else if(msource.equals("Mayur Vihar Phase-1")){
            int a = 9;
            dijkstra(adjacencyMatrix, a);
        }
        else if(msource.equals("Karkardumba")){
            int a = 11;
            dijkstra(adjacencyMatrix, a);
        }
        else if(msource.equals("Anand Vihar")){
            int a = 12;
            dijkstra(adjacencyMatrix, a);
        }
        else if(msource.equals("Yamuna Bank")){
            int a = 8;
            dijkstra(adjacencyMatrix, a);
        }
        else if(msource.equals("Vaishali")){
            int a = 13;
            dijkstra(adjacencyMatrix, a);
        }
        else if(msource.equals("Lajpath nagar")){
            int a = 6;
            dijkstra(adjacencyMatrix, a);
        }
        else if(msource.equals("Kalkaji Mandir")){
            int a = 5;
            dijkstra(adjacencyMatrix, a);
        }
        else if(msource.equals("Botanical Garden")){
            int a = 10;
            dijkstra(adjacencyMatrix, a);
        }
        else if(msource.equals("Hauz Khas")){
            int a = 4;
            dijkstra(adjacencyMatrix, a);
        }
        else if(msource.equals("Mandi House")){
            int a = 7;
            dijkstra(adjacencyMatrix, a);
        }
        else{
            Toast.makeText(this, "Please select a valid station", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(route.this,MainActivity.class);
            startActivity(i);
            finish();
        }


       }

    private void setupUI() {
        textView = (TextView)findViewById(R.id.textView4);

        back = findViewById(R.id.back);

        mymap = new Dialog(this);
        myinfo = new Dialog(this);
        msource = getIntent().getExtras().getString("sour");

    }



    private void dijkstra(int[][] adjacencyMatrix,
                          int startVertex)
    {
        int nVertices = adjacencyMatrix[0].length;
        int[] shortestDistances = new int[nVertices];
        boolean[] added = new boolean[nVertices];
        for (int vertexIndex = 0; vertexIndex < nVertices;
             vertexIndex++)
        {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }
        shortestDistances[startVertex] = 0;
        int[] parents = new int[nVertices];
        parents[startVertex] = NO_PARENT;
        for (int i = 1; i < nVertices; i++)
        {
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++)
            {
                if (!added[vertexIndex] &&
                        shortestDistances[vertexIndex] <
                                shortestDistance)
                {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }
            added[nearestVertex] = true;
            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++)
            {
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

                if (edgeDistance > 0
                        && ((shortestDistance + edgeDistance) <
                        shortestDistances[vertexIndex]))
                {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance +
                            edgeDistance;
                }
            }
        }

        printSolution(startVertex, shortestDistances, parents);
    }
    private void printSolution(int startVertex,
                                      int[] distances,
                                      int[] parents)
    {
        int nVertices = distances.length;


        textView.setText("Src->Des\t\t\t Time\t\t\t Shortest Path");

        for (int vertexIndex = 0;
             vertexIndex < nVertices;
             vertexIndex++)
        {
            if (vertexIndex != startVertex)
            {
                textView.setText(textView.getText()+"\n" + startVertex + " -> ");
                textView.setText(textView.getText()+ String.valueOf(vertexIndex) + " \t\t\t\t\t\t\t\t\t ");
                textView.setText(textView.getText()+String.valueOf(distances[vertexIndex]) + "\t\t\t\t\t");
                printPath(vertexIndex, parents);
            }
        }
    }


    private void printPath(int currentVertex,
                                  int[] parents)
    {


        if (currentVertex == NO_PARENT)
        {
            return;
        }
        printPath(parents[currentVertex], parents);
        textView.setText(textView.getText()+String.valueOf(currentVertex) + " ");
    }


    public void showinfo(View v){
        TextView close;
        myinfo.setContentView(R.layout.info);
        close = (TextView) myinfo.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myinfo.dismiss();
            }
        });
        myinfo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myinfo.show();

    }

    public void showmap(View v){
        TextView closemap;
        final ZoomControls zoom;
        final ImageView imgmap;
        mymap.setContentView(R.layout.map);

        imgmap = mymap.findViewById(R.id.imgmap);
        zoom = mymap.findViewById(R.id.zoom);
        zoom.hide();

        imgmap.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                zoom.show();
                return false;
            }
        });
        zoom.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = imgmap.getScaleX();
                float y = imgmap.getScaleY();

                imgmap.setScaleX(x+1);
                imgmap.setScaleY(y+1);
                zoom.hide();

            }
        });
        zoom.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final float x = imgmap.getScaleX();
                final float y = imgmap.getScaleY();
                    imgmap.setScaleX(x-1);
                    imgmap.setScaleY(y-1);
                    zoom.hide();

            }
        });


        closemap = (TextView) mymap.findViewById(R.id.closemap);
        closemap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mymap.dismiss();
            }
        });
        mymap.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mymap.show();

    }
}
