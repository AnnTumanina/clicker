package com.example.cats1;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Integer counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_layout);

        Button cat;
        Button pig;
        Button sheep;
        Button rabbit;
        TextView text_to_change1;
        cat = (Button)dialog.findViewById(R.id.cat);
        pig = (Button)dialog.findViewById(R.id.pig);
        sheep = (Button)dialog.findViewById(R.id.sheep);
        rabbit = (Button)dialog.findViewById(R.id.rabbit);
        text_to_change1 = (TextView)findViewById(R.id.text_to_change);

        cat.setOnClickListener(view -> {
            text_to_change1.setText("котиков, мяв ଲ(^˵◕ ᴥ ◕˵^)ଲ");
            dialog.dismiss();
        });

        pig.setOnClickListener(view -> {
            text_to_change1.setText("хрюшек, хрю (○＞（●●）＜○)");
            dialog.dismiss();
        });

        sheep.setOnClickListener(view -> {
            text_to_change1.setText("овечек, беее Ꮚ`ꈊ´Ꮚ");
            dialog.dismiss();
        });

        rabbit.setOnClickListener(view -> {
            text_to_change1.setText("зайчиков, фрр U ●ᆺ● U");
            dialog.dismiss();
        });

        dialog.setCancelable(false);
        dialog.setTitle("Choice");

        dialog.show();
    }

    public void onClickBtnAddStudents(View view) {
        counter++;
        String counter1 = counter.toString();
        TextView counterView = (TextView)findViewById(R.id.txt_counter);
        counterView.setText(counter1);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        TextView counterView = findViewById(R.id.txt_counter);
        ViewGroup.LayoutParams params = counterView.getLayoutParams();
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
        outState.putInt("height", params.height);
        outState.putInt("width", params.width);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        TextView counterView = findViewById(R.id.txt_counter);
        ViewGroup.LayoutParams params = counterView.getLayoutParams();
        counter = savedInstanceState.getInt("counter");
        params.height = savedInstanceState.getInt("height");
        params.width = savedInstanceState.getInt("width");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        ((TextView) findViewById(R.id.txt_counter)).setText(counter.toString());
    }
}

