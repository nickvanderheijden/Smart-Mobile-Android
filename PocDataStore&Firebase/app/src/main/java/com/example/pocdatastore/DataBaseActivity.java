package com.example.pocdatastore;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class DataBaseActivity extends AppCompatActivity {

   /* private static final String TAG = "MainActivity";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");
*/
   GridView gv;
   ArrayAdapter<String>adapter;
   DatabaseReference db;
   FireBaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);

        gv = (GridView)findViewById(R.id.gv);

        db= FirebaseDatabase.getInstance().getReference();

        helper = new FireBaseHelper(db);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,helper.retrieve());

       gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
               Toast.makeText(DataBaseActivity.this, helper.retrieve().get(position),Toast.LENGTH_SHORT).show();

           }
       });



        /*  myRef.setValue("Top");*/

       /* myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG,"Value is:"+ value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG,"Failed to read value", databaseError.toException());


            }
        });
*/



    }





}
