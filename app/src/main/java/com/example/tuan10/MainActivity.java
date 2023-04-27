package com.example.tuan10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tuan10.databinding.ActivityMainBinding;
import android.os.Bundle;
import android.util.Log;

import java.util.List;
import retrofit2.Response;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSeasons();

    }

    private void getSeasons(){
        Call<List<Season>> callSeason = APIClient.getInstance().getMyApi().getSeasons();
        callSeason.enqueue(new Callback<List<Season>>(){
            @Override
             public void onResponse(@NonNull Call<List<Season>> call, @NonNull Response<List<Season>> response){
                 List<Season> seasonList = response.body();
                // xuất ra màn hình để test hoặc chỉ dùng list để hiển thị lên Recyclerview
            if (seasonList != null ){
                StringBuilder dataString = new StringBuilder();
                for (Season season: seasonList){
                    dataString.append(season.toString());
                    dataString.append("\n");

                }
                    binding.tvMsg.setText(dataString);
            }

            }
            @Override
            public void onFailure(@NonNull Call<List<Season>> call, @NonNull Throwable t){
                Log.e(TAG, t.getMessage());
            }
        });
    }
}