package com.example.skycast;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etCity;
    private Button btnSearch;
    private ProgressBar progress;
    private ImageView imgIcon;
    private TextView tvCity, tvTemp, tvDescription, tvExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etCity = findViewById(R.id.etCity);
        btnSearch = findViewById(R.id.btnSearch);
        progress = findViewById(R.id.progress);
        imgIcon = findViewById(R.id.imgIcon);
        tvCity = findViewById(R.id.tvCity);
        tvTemp = findViewById(R.id.tvTemp);
        tvDescription = findViewById(R.id.tvDescription);
        tvExtra = findViewById(R.id.tvExtra);

        btnSearch.setOnClickListener(v -> {
            String city = etCity.getText().toString().trim();
            if (city.isEmpty())
                etCity.setError("Enter a city");
            else {
                Toast.makeText(MainActivity.this, "You searched: " + city, Toast.LENGTH_SHORT).show();
            }
        });
    }
}