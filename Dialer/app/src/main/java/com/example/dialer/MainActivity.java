package com.example.dialer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.dialer.extra.MESSAGE";
    private EditText mMessageEditText;
    public static final int TEXT_REQUEST = 1;

    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonFour;
    Button buttonFive;
    Button buttonSix;
    Button buttonSeven;
    Button buttonEight;
    Button buttonNine;
    Button buttonStar;
    Button buttonZero;
    Button buttonHash;
    Button buttonCall;
    Button buttonDelete;

    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOne = findViewById(R.id.buttonOne);
        buttonTwo = findViewById(R.id.buttonTwo);
        buttonThree = findViewById(R.id.buttonThree);
        buttonFour = findViewById(R.id.buttonFour);
        buttonFive = findViewById(R.id.buttonFive);
        buttonSix = findViewById(R.id.buttonSix);
        buttonSeven = findViewById(R.id.buttonSeven);
        buttonEight = findViewById(R.id.buttonEight);
        buttonNine = findViewById(R.id.buttonNine);
        buttonStar = findViewById(R.id.buttonStar);
        buttonZero = findViewById(R.id.buttonZero);
        buttonHash = findViewById(R.id.buttonHash);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonCall = findViewById(R.id.buttonCall);

        input = findViewById(R.id.editText);
        mMessageEditText = findViewById(R.id.editText);
    }

    public void one(View view) {
        onClickButton(buttonOne, input, "1");
    }

    public void two(View view) {
        onClickButton(buttonTwo, input, "2");
    }

    public void three(View view) {
        onClickButton(buttonThree, input, "3");
    }

    public void four(View view) {
        onClickButton(buttonFour, input, "4");
    }

    public void five(View view) {
        onClickButton(buttonFive, input, "5");
    }

    public void six(View view) {
        onClickButton(buttonSix, input, "6");
    }

    public void seven(View view) {
        onClickButton(buttonSeven, input, "7");
    }

    public void eight(View view) {
        onClickButton(buttonEight, input, "8");
    }

    public void nine(View view) {
        onClickButton(buttonNine, input, "9");
    }

    public void star(View view) {
        onClickButton(buttonStar, input, "*");
    }

    public void zero(View view) {
        onClickButton(buttonZero, input, "0");
    }

    public void hash(View view) {
        onClickButton(buttonHash, input, "#");
    }

    public void onDelete(View view) {
        input.setText("");
    }

    public void onCall(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL);

        String hash = input.getText().toString();

        if(hash.contains("$")) {
            hash.replace("$", "%23");
        }
        intent.setData(Uri.parse("tel:" + hash));
        startActivity(intent);
    }

    public void onClickButton(Button button, EditText inputNumber, String number) {         //Um método para usar todos os onClicks ao invés de repetir código e usar um para cada um
        String text = input.getText().toString();                                           //text convertido para string
        inputNumber.setText(text + number);                                                 //?
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);

        String message = mMessageEditText.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void launchThirdActivity(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);

        String message = mMessageEditText.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void launchFourthActivity(View view) {
        Intent intent = new Intent(this, FourthActivity.class);

        String message = mMessageEditText.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }
}