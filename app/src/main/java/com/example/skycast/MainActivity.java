package com.example.skycast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.skycast.data.model.WeatherResponse;
import com.example.skycast.data.remote.ApiClient;
import com.example.skycast.data.remote.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText etCity;
    private Button btnSearch;
    private ProgressBar progress;
    private ImageView imgIcon;
    private TextView tvCity, tvTemp, tvDescription, tvExtra;

    private WeatherService weatherService;
    private final String API_KEY = "1abe763d6413b23a104322a3e8c9e0a8";

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

        weatherService = ApiClient.getClient().create(WeatherService.class);

        btnSearch.setOnClickListener(v -> {
            String city = etCity.getText().toString().trim();

            if (city.isEmpty()) {
                etCity.setError("Enter a city");
            } else {
                loadWeather(city);
            }
        });
    }

    private void loadWeather(String cityName) {

        if (API_KEY.equals("YOUR_API_KEY_HERE")) {
            Toast.makeText(this, "Please set your OpenWeather API key in MainActivity", Toast.LENGTH_LONG).show();
            return;
        }

        progress.setVisibility(View.VISIBLE);

        Call<WeatherResponse> call =
                weatherService.getCurrentWeather(cityName, API_KEY, "metric");

        // Enqueue means: execute in background thread, and call back on main thread
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call,
                                   Response<WeatherResponse> response) {

                progress.setVisibility(View.GONE);

                if (response.isSuccessful() && response.body() != null) {
                    bindData(response.body());
                } else {
                    Toast.makeText(MainActivity.this,
                            "City not found",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                progress.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this,
                        "Error: " + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void bindData(WeatherResponse data) {

        // City + country
        String cityAndCountry = data.getName();
        if (data.getSys() != null && data.getSys().getCountry() != null) {
            cityAndCountry += ", " + data.getSys().getCountry();
        }
        tvCity.setText(cityAndCountry);

        // Temperature
        double temp = data.getMain().getTemp();
        tvTemp.setText(Math.round(temp) + "°C");

        // Description and icon
        if (data.getWeather() != null && !data.getWeather().isEmpty()) {
            String desc = data.getWeather().get(0).getDescription();
            tvDescription.setText(desc);

            String iconCode = data.getWeather().get(0).getIcon();
            String iconUrl = "https://openweathermap.org/img/wn/" + iconCode + "@4x.png";
            Glide.with(this).load(iconUrl).into(imgIcon);
        }

        // Extra info
        String extra = "Feels like: " + Math.round(data.getMain().getFeels_like()) + "°C\n"
                + "Humidity: " + data.getMain().getHumidity() + "%\n"
                + "Wind: " + data.getWind().getSpeed() + " m/s";

        tvExtra.setText(extra);
    }

}