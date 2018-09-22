package ch.epfl.sweng.bootcamp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String BUNDLE_EXTRA_NAME = "BUNDLE_EXTRA_NAME";

    private Button button;

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.mainGoButton);
        EditText nameEdit = findViewById(R.id.mainName);

        button.setEnabled(false);

        nameEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                name = s.toString();
                button.setEnabled(count > 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent greetingActivity = new Intent(MainActivity.this, GreetingActivity.class);
                greetingActivity.putExtra(BUNDLE_EXTRA_NAME, name);
                startActivity(greetingActivity);
            }
        });
    }
}
