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
import java.io.FileWriter;
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

        lv_song = findViewById(R.id.song_list);

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
        File folder=new File(Environment.getExternalStorageDirectory()+"/songs");
        String path = folder.toString();
        boolean success = true;
        if (!folder.exists()) {
            Toast.makeText(MainActivity.this, "Directory Does Not Exist, Create It", Toast.LENGTH_SHORT).show();
            success = folder.mkdir();
        }
        if (success) {
            Toast.makeText(MainActivity.this, "Directory Created", Toast.LENGTH_SHORT).show();
            File demofile = new File(folder, "demo.xml");
            try{
                FileWriter writer = new FileWriter(demofile,true);
                writer.append("sample song");
                writer.flush();
                writer.close();
            }catch(Exception e) {
                e.printStackTrace();
            }

        } else {
            Toast.makeText(MainActivity.this, "Failed - Error", Toast.LENGTH_SHORT).show();
        }
       Log.d("Files", "Path: " + path);
        File directory = new File(path);
        File[] files = directory.listFiles();
        if (files.length>0) {
            Log.d("Files", "Size: " + files.length);
            for (int i = 0; i < files.length; i++) {
                ListElementsArrayList.add(files[i].getName());
            }
        }

    }


}