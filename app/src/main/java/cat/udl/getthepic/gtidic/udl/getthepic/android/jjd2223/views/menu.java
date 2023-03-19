package cat.udl.getthepic.gtidic.udl.getthepic.android.jjd2223.views;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


import com.example.getthepic.gtidic.udl.getthepic.getthepic.jjd2223.R;


import cat.udl.getthepic.gtidic.udl.getthepic.android.jjd2223.DB.DatabaseGetThePic;
import cat.udl.getthepic.gtidic.udl.getthepic.android.jjd2223.Models.Player.IAPlayer;

public class menu extends AppCompatActivity {
    Button about,start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        about = findViewById(R.id.button2);
        start = findViewById(R.id.buttonstart);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( menu.this , About.class);
                startActivity(intent);

            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(menu.this, GameActivity.class);
                startActivity(intent);

            }
        });
        findViewById(R.id.laiajuga).setOnClickListener((view) -> jugalaia(view));
        findViewById(R.id.borrarDB).setOnClickListener(view -> clearDB());
        findViewById(R.id.veureDB).setOnClickListener(view -> getPoints());

    }

    private void clearDB() {
        String dbName = "GTP.db";
        DatabaseGetThePic dbRoom = Room.databaseBuilder(this.getApplicationContext(), DatabaseGetThePic.class, dbName).allowMainThreadQueries().build();
        dbRoom.gameDAO().deleteAll();
        dbRoom.close();
    }

    private void getPoints() {
        String dbName = "GTP.db";
        DatabaseGetThePic dbRoom = Room.databaseBuilder(this.getApplicationContext(), DatabaseGetThePic.class, dbName).allowMainThreadQueries().build();
        int lastPoints = dbRoom.gameDAO().getLastGamePoints();
        int maxPoints = dbRoom.gameDAO().getMaxPoints();
        String missatge = String.format("Max punts: %d. Ultims punts: %d", maxPoints, lastPoints );
        System.out.println(missatge);
        dbRoom.close();
    }




    private void jugalaia(View view)
    {
       IAPlayer iaPlayer = new IAPlayer();
       iaPlayer.init();
       iaPlayer.jugar();
    }
}