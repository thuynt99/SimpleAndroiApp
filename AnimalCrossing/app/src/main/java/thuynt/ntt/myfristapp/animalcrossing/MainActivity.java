package thuynt.ntt.myfristapp.animalcrossing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    TextView txtDiem;
    CheckBox cb1,cb2,cb3;
    SeekBar sk1,sk2,sk3;
    Button btnPlay;
    int DiemSo = 10 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
//
//        sk1.setEnabled(false);
//        sk2.setEnabled(false);
//        sk3.setEnabled(false);
        final CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long l) {

                //set vantoc
                int number = 8;
                Random rd = new Random();
                int one = rd.nextInt(number)+1 ;
                int two = rd.nextInt(number)+1;
                int three = rd.nextInt(number)+1;
                sk1.setProgress(sk1.getProgress() +one);
                sk2.setProgress(sk2.getProgress() +two);
                sk3.setProgress(sk3.getProgress() +three);


                // kiem tra win
                if(sk1.getProgress() >= sk1.getMax()){
                    this.cancel();
                    btnPlay.setVisibility(View.VISIBLE);
                    EnableCheckBox();
                    Toast.makeText(MainActivity.this, "1 win", Toast.LENGTH_SHORT).show();

                    // Tinh diem
                    if(cb1.isChecked()){
                        DiemSo += 10;
                        Toast.makeText(MainActivity.this, "Bạn đã đoán đúng", Toast.LENGTH_SHORT).show();
                    }else {
                        DiemSo -=5;
                        Toast.makeText(MainActivity.this, "Bạn đã chọn sai", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(DiemSo + "");
                }
                if(sk2.getProgress() >= sk2.getMax()){
                    this.cancel();
                    btnPlay.setVisibility(View.VISIBLE);
                    EnableCheckBox();
                    Toast.makeText(MainActivity.this, "2 win", Toast.LENGTH_SHORT).show();

                    if(cb2.isChecked()){
                        DiemSo += 10;
                        Toast.makeText(MainActivity.this, "Bạn đã đoán đúng", Toast.LENGTH_SHORT).show();
                    }else {
                        DiemSo -=5;
                        Toast.makeText(MainActivity.this, "Bạn đã chọn sai", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(DiemSo + "");
                }
                if(sk3.getProgress() >= sk3.getMax()){
                    this.cancel();
                    btnPlay.setVisibility(View.VISIBLE);
                    EnableCheckBox();
                    Toast.makeText(MainActivity.this, "3 win", Toast.LENGTH_SHORT).show();

                    if(cb3.isChecked()){
                        DiemSo += 10;
                        Toast.makeText(MainActivity.this, "Bạn đã đoán đúng", Toast.LENGTH_SHORT).show();
                    }else {
                        DiemSo -=5;
                        Toast.makeText(MainActivity.this, "Bạn đã chọn sai", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(DiemSo + "");
                }

            }

            @Override
            public void onFinish() {
            }
        };


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(cb1.isChecked() || cb2.isChecked() || cb3.isChecked()){
                        countDownTimer.start();
                        btnPlay.setVisibility(View.INVISIBLE);
                        sk1.setProgress(0);
                        sk2.setProgress(0);
                        sk3.setProgress(0);
                        DisableCheckBox();

                    } else {
                        Toast.makeText(MainActivity.this, "Bạn chưa đặt cược", Toast.LENGTH_SHORT).show();
                    }

            }
        });

        // set checkbox
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                }
            }

        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cb1.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });

        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cb1.setChecked(false);
                    cb2.setChecked(false);
                }
            }
        });


    }


    private void EnableCheckBox(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
    }

    private void DisableCheckBox() {
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }
    private  void AnhXa(){
        txtDiem = (TextView) findViewById(R.id.diemSo);
        btnPlay = (Button) findViewById(R.id.buttonPlay);
        cb1 = (CheckBox) findViewById(R.id.checkbox1);
        cb2 = (CheckBox) findViewById(R.id.checkbox2);
        cb3 = (CheckBox) findViewById(R.id.checkbox3);
        sk1 = (SeekBar) findViewById(R.id.seekbar1);
        sk2 = (SeekBar) findViewById(R.id.seekbar2);
        sk3 = (SeekBar) findViewById(R.id.seekbar3);
    }
}
