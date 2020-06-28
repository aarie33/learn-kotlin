package arie.pojointent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnObjIntent, btnMoveResult;
    private TextView tvResult;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnObjIntent = findViewById(R.id.btnObjIntent);
        btnObjIntent.setOnClickListener(this);
        btnMoveResult = findViewById(R.id.btn_move_for_result);
        btnMoveResult.setOnClickListener(this);
        tvResult = findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnObjIntent:
                Person mPerson = new Person();
                mPerson.setName("DicodingAcademy");
                mPerson.setAge(5);
                mPerson.setEmail("arie@dafidea.com");
                mPerson.setCity("Jember");
                Intent moveObject = new Intent(MainActivity.this, MoveWithObjectAct.class);
                moveObject.putExtra(MoveWithObjectAct.EXTRA_PERSON, mPerson);
                startActivity(moveObject);
                break;
            case R.id.btn_move_for_result:
                Intent moveResult = new Intent(MainActivity.this, MoveForResultAct.class);
                startActivityForResult(moveResult, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultAct.RESULT_CODE) {
                int selectedValue = data.getIntExtra(MoveForResultAct.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText("Hasil : "+selectedValue);
            }
        }
    }
}
