package pornnatcha.what_your_grade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result_Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result__score);

        Intent intent = getIntent();

        intent = getIntent();
        String name = intent.getStringExtra("name_i");
        String g = intent.getStringExtra("grade");
        TextView v = (TextView) findViewById(R.id.name);
        TextView vv = (TextView) findViewById(R.id.grade);
        v.setText(name);
        vv.setText(g);

    }
}
