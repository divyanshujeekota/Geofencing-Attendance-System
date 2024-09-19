package com.example.vbob;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.core.models.Size;
import nl.dionsegijn.konfetti.xml.KonfettiView;

public class LocationReached extends AppCompatActivity {

    TextView date,time;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_location_reached);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            KonfettiView konfettiView=findViewById(R.id.konfettiView);
            EmitterConfig emitterConfig=new Emitter(100, TimeUnit.MILLISECONDS).max(100);
            konfettiView.start(
                    new PartyFactory(emitterConfig)
                            .shapes(Shape.Circle.INSTANCE,Shape.Square.INSTANCE)
                            .spread(360)
                            .position(0.5,0.3)
                            .sizes(new Size(8,100,10))
                            .colors(Arrays.asList(0xfce18a, 0xff726d, 0xf4306d, 0xb48def))
                            .setDamping(0.9F)
                            .setSpeed(0f)
                            .setSpeedBetween(0f,30f)
                            .timeToLive(3000)
                            .fadeOutEnabled(true)
                            .build()

            );
            date=findViewById(R.id.textView7);
            time=findViewById(R.id.textView4);


            LocalDateTime currentDateTime = LocalDateTime.now();

            // Format date
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String dateString = currentDateTime.format(dateFormatter);

            // Format time
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            String timeString = currentDateTime.format(timeFormatter);

            date.setText(dateString);
            time.setText(timeString);


            return insets;
        });
    }
}