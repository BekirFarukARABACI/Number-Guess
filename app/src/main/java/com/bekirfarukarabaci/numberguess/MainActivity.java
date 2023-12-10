package com.bekirfarukarabaci.numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView txtKalanHak , txtSonuc;
    private EditText editTextSayi;
    private String gelenDeger;
    private Button button;
    private int kalanHak = 3, randomSayi;
    private Random rndNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtKalanHak = (TextView) findViewById(R.id.txtViewKalanHak);
        txtSonuc = (TextView) findViewById(R.id.txtViewSonuc);
        editTextSayi =(EditText) findViewById(R.id.editTxtSayi);
        button = (Button) findViewById(R.id.btnTahminEt);

        Intent intent = getIntent();

        rndNumber = new Random();
        randomSayi = rndNumber.nextInt(5);
        System.out.println("Random sayı : " + randomSayi);
    }

    public void btnTahminEt(View view){
        gelenDeger = editTextSayi.getText().toString();

        if (!TextUtils.isEmpty(gelenDeger)){
            if (kalanHak > 0){
                if (gelenDeger.equals(String.valueOf(randomSayi))){
                    sonucGoster("Tebrikler doğru tahmin ettiniz...");
                }
                else {
                    txtSonuc.setText("Yanlış tahminde bulundunuz...");
                    editTextSayi.setText("");
                }

                kalanHak--;
                txtKalanHak.setText("Kalan hak : " + kalanHak);
                if (kalanHak == 0 && !gelenDeger.equals(String.valueOf(randomSayi))){
                    sonucGoster("Tahmin hakkınız bitti");
                    button.setEnabled(false);
                }
            }
            else {
                txtSonuc.setText("Oyun bitti");
                button.setEnabled(false);
            }
        }
        else {
            txtSonuc.setText("Girilen Değer Boş Olamaz");
        }
    }

    private void sonucGoster(String mesaj) {
        editTextSayi.setEnabled(false);
        txtSonuc.setText(mesaj);

    }
    public void restart(View view){
        finish();
        startActivity(getIntent());
    }

    public void quit(View View){
        finish();
    }
}