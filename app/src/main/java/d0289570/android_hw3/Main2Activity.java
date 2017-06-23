package d0289570.android_hw3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(greet);

    }

    private View.OnClickListener greet =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String input_str = editText.getText().toString();

            Intent intent = new Intent();
            intent.putExtra(MainActivity.NAME,input_str);
            setResult(RESULT_OK, intent);
            finish();
        }
    };
}
