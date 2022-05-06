package com.example.flames;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity //implements View.OnClickListener


{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void clk(View view) {


        String name1, name2;
        EditText ed1 = findViewById(R.id.txt1);
        name1 = ed1.getText().toString();

        EditText ed2 = findViewById(R.id.txt2);
        name2 = ed2.getText().toString();
        TextView t = findViewById(R.id.res);


        name1 = name1.trim();
        name2 = name2.trim();

        name1 = name1.toLowerCase();
        name2 = name2.toLowerCase();


        String name1_split[] = name1.split(" ");
        String name2_split[] = name2.split(" ");
        name1 = "";
        name2 = "";
        for (int i = 0; i < name1_split.length; i++) {
            name1 = name1 + name1_split[i];
        }
        for (int i = 0; i < name2_split.length; i++) {
            name2 = name2 + name2_split[i];
        }
        int length = name1.length() + name2.length();
        boolean name_check[] = new boolean[name2.length()];
        for (int i = 0; i < name2.length(); i++) {
            name_check[i] = false;
        }
        for (int i = 0; i < name1.length(); i++) {
            for (int j = 0; j < name2.length(); j++) {
                if ((name_check[j] == false) && (name1.charAt(i) == name2.charAt(j))) {
                    name_check[j] = true;
                    length = length - 2;
                    break;
                }
            }
        }
        boolean flames_check[] = new boolean[6];
        for (int i = 0; i < 6; i++) {
            flames_check[i] = true;
        }
        int count = 6;
        int k = 1, deleted_letters = 0;
        int j;
        for (j = 0; j <= count; j++) {
            if (k <= length) {
                if (j == count) {
                    j = 0;
                }
                if (flames_check[j] == true) {
                    k = k + 1;
                }
            }
            if ((k - 1) == length) {
                deleted_letters = deleted_letters + 1;
                flames_check[j] = false;
                k = 1;
            }
            if (deleted_letters == 6) {
                if (j == 0) {
                    t.setText("FRIENDS");
                } else if (j == 1) {
                    t.setText("LOVERS");
                } else if (j == 2) {
                    t.setText("AFFECTION");
                } else if (j == 3) {
                    t.setText("MARRIED");
                } else if (j == 4) {
                    t.setText("ENEMIES");
                } else if (j == 5) {
                    t.setText("Brothers and Sister");

                }
break;
            }
        }

    }
}


