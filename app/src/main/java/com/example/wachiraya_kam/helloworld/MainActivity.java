package com.example.wachiraya_kam.helloworld;

import android.content.Intent;
import android.graphics.Point;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import mehdi.sakout.fancybuttons.FancyButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

/*    TextView tvHello;
    EditText editTextHello;
    Button btnCopy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {
        tvHello = (TextView) findViewById(R.id.tvHello);
        //Link to URL
        tvHello.setMovementMethod(LinkMovementMethod.getInstance());
        tvHello.setText("Test");

        editTextHello = (EditText) findViewById(R.id.editTextHello);
        editTextHello.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    //Copy text in EditText to TextView
                    tvHello.setText(editTextHello.getText());
                    return true;
                }
                return false;
            }
        });

        btnCopy = (Button) findViewById(R.id.btnCopy);
        btnCopy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnCopy){
            tvHello.setText(editTextHello.getText());
        }
    }*/

    ///////////////////Calculate////////////////////

    int x, y, z; // Save/Restore in Activity's instance state

    private EditText editText1;
    private EditText editText2;
    private TextView tvResult;
    private Button btnResult;
    private RadioGroup rgOperator;
    private RadioButton rbPlus;
    private RadioButton rbMinus;
    private RadioButton rbMultiply;
    private RadioButton rbDevide;
    private boolean checked = true;
    private CustomViewGroup viewGroup1;
    private CustomViewGroup viewGroup2;
    CustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnResult = (Button) findViewById(R.id.btnCalculate);
        btnResult.setOnClickListener(this);
        rgOperator = (RadioGroup) findViewById(R.id.rgOperator);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        Toast.makeText(MainActivity.this,"Width ="+ width +", Height = "+height, Toast.LENGTH_SHORT).show();

        viewGroup1 = (CustomViewGroup) findViewById(R.id.viewGroup1);
        viewGroup2 = (CustomViewGroup) findViewById(R.id.viewGroup2);
        viewGroup1.setButtonText("Hello");
        viewGroup2.setButtonText("World");


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Save thing(s) here

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //Restore thing(s) here

    }

    @Override
    public void onClick(View v) {
        if (v == btnResult) {
            int num1 = 0;
            int num2 = 0;
            int result = 0;
            try {
                num1 = Integer.parseInt(editText1.getText().toString());
            } catch (NumberFormatException e) {
            }
            try {
                num2 = Integer.parseInt(editText2.getText().toString());
            } catch (NumberFormatException e) {
            }


            switch (rgOperator.getCheckedRadioButtonId()) {
                case R.id.rbPlus:
                    result = num1 + num2;
                    break;
                case R.id.rbMinus:
                    result = num1 - num2;
                    break;
                case R.id.rbMultiply:
                    result = num1 * num2;
                    break;
                case R.id.rbDivide:
                    result = num1 / num2;
                    break;
            }
            tvResult.setText(String.valueOf(result));
            Log.d("Calculation", "Result = "+ result);
            Toast toast1 = Toast.makeText(MainActivity.this, "Result = " + result, Toast.LENGTH_SHORT);
            toast1.show();

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("result", result); // send Extra to another Activity

            //Playground
            Coordinate c1 = new Coordinate();
            c1.x = 5;
            c1.y = 10;
            c1.z = 20;
            Bundle bundle = new Bundle();
            bundle.putInt("x", c1.x);
            bundle.putInt("y", c1.y);
            bundle.putInt("z", c1.z);
            intent.putExtra("cBundle", bundle);

            //Serializable Lab
            CoordinateSerializable c2 = new CoordinateSerializable();
            c2.x = 5;
            c2.y = 10;
            c2.z = 20;
            intent.putExtra("cSerializable", c2);

            CoordinateParcelable c3 = new CoordinateParcelable();
            c3.x = 5;
            c3.y = 10;
            c3.z = 20;
            intent.putExtra("cParcelable", c3);


            //startActivity(intent);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_settings){
            // Do what you want
            Toast.makeText(MainActivity.this, "Strings Clicked", Toast.LENGTH_SHORT).show();
            //Handle
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
