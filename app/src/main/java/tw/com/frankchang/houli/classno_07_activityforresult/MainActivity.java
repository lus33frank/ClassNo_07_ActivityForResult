package tw.com.frankchang.houli.classno_07_activityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvShow;
    Button btnLogin;

    final int RQ = 1000;
    final String ACCOUNT = "root";
    final String PASSWORD = "1234";
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewer();
    }

    void findViewer(){
        tvShow = (TextView) findViewById(R.id.textView);
        btnLogin = (Button) findViewById(R.id.button);
        btnLogin.setOnClickListener(btnOnClick);
    }

    View.OnClickListener btnOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(MainActivity.this, LoginActivity.class);
            //startActivity(it);
            startActivityForResult(it, RQ);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RQ){
            if (resultCode == RESULT_OK){
                if (data.getStringExtra("UserName").equals(ACCOUNT) && data.getStringExtra("PassWord").equals(PASSWORD)){
                    Toast.makeText(this, getResources().getString(R.string.Login_OK), Toast.LENGTH_LONG).show();
                    tvShow.setText(R.string.Login_OK);
                    count = 0;
                }
                else{
                    count++;
                    Toast.makeText(this, "登入驗證失敗：" + count + "次", Toast.LENGTH_LONG).show();
                    tvShow.setText(R.string.Login_failure);
                    if (count == 3){
                        Toast.makeText(this, getResources().getString(R.string.APP_Close), Toast.LENGTH_LONG).show();
                        this.finish();
                    }
                }
            }
            else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this, getResources().getString(R.string.Login_CANCELED), Toast.LENGTH_LONG).show();
            }
        }
    }
}
