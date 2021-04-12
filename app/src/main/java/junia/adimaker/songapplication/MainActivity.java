package junia.adimaker.songapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


// JE teste un truc de debile car c'est drole


public class MainActivity extends AppCompatActivity {

    Context context;


    ArrayAdapter<String> SongAdapter ;

    String[] ListElements = new String[] { };
    List<String> ListElementsArrayList ;

    ListView lv_song;

    Button refresh_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_song = (ListView) findViewById(R.id.song_list);

        context = getApplicationContext();

        ListElementsArrayList = new ArrayList<>(Arrays.asList(ListElements));
        SongAdapter = new ArrayAdapter<String>
                (MainActivity.this, android.R.layout.simple_list_item_1, ListElementsArrayList);
        lv_song.setAdapter(SongAdapter);
        GetAllSongs();

        lv_song.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   Toast.makeText(MainActivity.this,parent.getAdapter().getItem(position).toString(),Toast.LENGTH_LONG).show();
            }
        });

    }


    public void GetAllSongs(){

        String path = Environment.getExternalStorageDirectory().toString()+"/Songs";
        Log.d("Files", "Path: " + path);
        File directory = new File(path);
        File[] files = directory.listFiles();
        Log.d("Files", "Size: "+ files.length);
        for (int i = 0; i < files.length; i++)
        {
            ListElementsArrayList.add(files[i].getName());
        }



    }


}