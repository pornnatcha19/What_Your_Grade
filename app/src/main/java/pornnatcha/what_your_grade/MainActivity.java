package pornnatcha.what_your_grade;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText NameInput,ScoreInput;
    private Button CalButton,ExitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NameInput = (EditText) findViewById(R.id.NameEditText);
        ScoreInput = (EditText) findViewById(R.id.ScoreEditText);
        CalButton = (Button) findViewById(R.id.CalButton);
        ExitButton = (Button) findViewById(R.id.ExitButton);


        CalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = String.valueOf(NameInput.getText().toString());
                String score = String.valueOf(ScoreInput.getText().toString());
                if(NameInput.getText().length()==0){
                    NameInput.setError("โปรดกรอกข้อมูล");
                }else if (ScoreInput.getText().length()==0) {
                    ScoreInput.setError("โปรดกรอกข้อมูล");
                }else if (NameInput.getText().length()==0||ScoreInput.getText().length()==0){
                    NameInput.setError("โปรดกรอกข้อมูล");
                    ScoreInput.setError("โปรดกรอกข้อมูล");
                }else if(NameInput.getText().length()!=0&&ScoreInput.getText().length()!=0) {
                    Double score_1 = Double.valueOf(ScoreInput.getText().toString());
                    String grade = getScore(score_1);
                    Intent intent = new Intent((MainActivity.this), Result_Score.class);
                    intent.putExtra("name_i", name);
                    intent.putExtra("grade", grade);

                    startActivity(intent);
                }
            }
        });

       /* CalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = String.valueOf(NameInput.getText().toString());
                Double score = Double.valueOf(ScoreInput.getText().toString());

                String grade = getScore(score);
                Intent intent = new Intent((MainActivity.this),Result_Score.class);
                intent.putExtra("name_i",name);
                intent.putExtra("grade",grade);

                startActivity(intent);




            }
        }



        );

*/
        ExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Are you sure you want to exit?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                MainActivity.this.finish();
                            }

                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });



    }
    private String getScore(Double score) {
        String ScoreText = "";
        if(score < 50){
            ScoreText = "F";
        }else if (score<60){
            ScoreText = "D";
        }else if (score<70){
            ScoreText = "C";
        }else if (score<80){
            ScoreText = "B";
        }
        else{
            ScoreText = "A";
        }
        return ScoreText;
    }


}
