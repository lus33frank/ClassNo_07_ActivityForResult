package tw.com.frankchang.houli.classno_07_activityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText etUserName, etPassWord;
    Button btnClose, btnOK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewer();
    }

    void findViewer(){
        etUserName = (EditText) findViewById(R.id.editText);
        etPassWord = (EditText) findViewById(R.id.editText2);

        btnClose = (Button) findViewById(R.id.button2);
        btnClose.setOnClickListener(btnOnClick);

        btnOK = (Button) findViewById(R.id.button3);
        btnOK.setOnClickListener(btnOnClick);
    }

    View.OnClickListener btnOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.button3){
                Intent it = new Intent();
                it.putExtra("UserName", etUserName.getText().toString());
                it.putExtra("PassWord", etPassWord.getText().toString());
                setResult(RESULT_OK, it);
            }
            else{
                setResult(RESULT_CANCELED);
            }
            LoginActivity.this.finish();
        }
    };
}
