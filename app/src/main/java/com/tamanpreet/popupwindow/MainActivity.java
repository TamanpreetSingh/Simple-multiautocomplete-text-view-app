package com.tamanpreet.popupwindow;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

    ListView l1;
    Button b;
    MultiAutoCompleteTextView t;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> tasks;
    Context context;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b=(Button) findViewById(R.id.button);
        b.setOnClickListener(this);
        l1=(ListView) findViewById(R.id.listView2);
        context=this;
        tasks = new ArrayList<String>();

        arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, tasks);

        l1.setAdapter(arrayAdapter);
        String[] s=new String[]{"@name1","@name2","@name3","@name4"};
        t=(MultiAutoCompleteTextView)findViewById(R.id.autocomplete);

        ArrayAdapter<String> s1=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,s);
        t.setAdapter(s1);
        t.setTokenizer(new SpaceTokenizer());


    }

   /* private final TextWatcher tagwatcher=new TextWatcher(){

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {


            String b=e1.getText().toString();

            if(b.matches("[@]")){
                tag();
            }



        }

        @Override
        public void afterTextChanged(Editable s) {
       //     String b=e1.getText().toString();

         //   if(b.matches("[@]") && s.length()>0){
           //     Log.e("textWatcher","hh");
            //tag();

            }
        //}


    };

    private void tag() {
        Intent i=new Intent(this,Pop.class);
        startActivity(i);

    }*/


    @Override
    public void onClick(View v) {
        //e1.setVisibility(1);
        //InputMethodManager imm=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //imm.showSoftInput(e1,0);

        String c = t.getText().toString();


        if (null != c && c.length() > 0) {
            tasks.add(c);
            arrayAdapter.notifyDataSetChanged();


        }
        t.setText("");

    }
   }
