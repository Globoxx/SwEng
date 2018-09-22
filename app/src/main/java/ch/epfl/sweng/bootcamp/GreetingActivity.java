package ch.epfl.sweng.bootcamp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        TextView nameText = findViewById(R.id.greetingMessage);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString(MainActivity.BUNDLE_EXTRA_NAME, "???");
            String greetingMessage = "Hello " + name + "!";
            nameText.setText(greetingMessage);
        }
    }
}
