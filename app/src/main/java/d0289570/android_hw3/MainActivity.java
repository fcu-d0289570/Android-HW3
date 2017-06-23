package d0289570.android_hw3;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    private static final int ACTIVITY_SETNAME = 1;
    protected static String NAME = "NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(greet);
    }

    public View.OnClickListener greet = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, Main2Activity.class);
            startActivityForResult(intent, ACTIVITY_SETNAME);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_web:
                Uri uri = Uri.parse("http://www.google.com.tw");
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);
                break;
        }
        return true;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        if(intent==null){
            return;
        }

        super.onActivityResult(requestCode,resultCode,intent);
        switch (requestCode){
            case ACTIVITY_SETNAME:
                String name = intent.getStringExtra(NAME);
                Toast.makeText(MainActivity.this, "Hello "+name, Toast.LENGTH_SHORT).show();
        }

    }
}
