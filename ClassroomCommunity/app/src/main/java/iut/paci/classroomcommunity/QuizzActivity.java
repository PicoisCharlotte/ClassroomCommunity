package iut.paci.classroomcommunity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class QuizzActivity extends AppCompatActivity {

    Button reponse1;
    Button reponse2;
    Button reponse3;
    Button reponse4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        reponse1 = (Button) findViewById(R.id.reponse1);
        reponse2 = (Button) findViewById(R.id.reponse2);
        reponse3 = (Button) findViewById(R.id.reponse3);
        reponse4 = (Button) findViewById(R.id.reponse4);
    }

    public void funcRep(View v){


        if(v.getId() == reponse1.getId()){
            reponse1.setBackgroundColor(Color.parseColor("#f13ba9"));

            reponse2.setBackgroundColor(Color.parseColor("#130b73"));
            reponse3.setBackgroundColor(Color.parseColor("#130b73"));
            reponse4.setBackgroundColor(Color.parseColor("#130b73"));

        } else if(v.getId() == reponse2.getId()){
            reponse2.setBackgroundColor(Color.parseColor("#f13ba9"));

            reponse1.setBackgroundColor(Color.parseColor("#130b73"));
            reponse3.setBackgroundColor(Color.parseColor("#130b73"));
            reponse4.setBackgroundColor(Color.parseColor("#130b73"));

        } else if(v.getId() == reponse3.getId()){
            reponse3.setBackgroundColor(Color.parseColor("#f13ba9"));

            reponse1.setBackgroundColor(Color.parseColor("#130b73"));
            reponse2.setBackgroundColor(Color.parseColor("#130b73"));
            reponse4.setBackgroundColor(Color.parseColor("#130b73"));

        } else if(v.getId() == reponse4.getId()){
            reponse4.setBackgroundColor(Color.parseColor("#f13ba9"));

            reponse1.setBackgroundColor(Color.parseColor("#130b73"));
            reponse2.setBackgroundColor(Color.parseColor("#130b73"));
            reponse3.setBackgroundColor(Color.parseColor("#130b73"));
        }

    }
}
