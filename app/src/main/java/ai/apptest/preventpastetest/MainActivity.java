package ai.apptest.preventpastetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2, editText3, editText4;
    NoMenuEditText editText5;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText)findViewById(R.id.editText1); // setCustomSelectionActionModeCallback
        editText1.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem item) {
                return false;
            }
            public void onDestroyActionMode(ActionMode actionMode) {
            }
        });

//        editText2 = (EditText)findViewById(R.id.editText2); // prevent fast input

//        editText3 = (EditText)findViewById(R.id.editText3); // disable onPaste Action

        editText4 = (EditText)findViewById(R.id.editText4); // Set Long Click False
        editText4.setLongClickable(false);

        editText5 = (NoMenuEditText)findViewById(R.id.editText5); // NoMenuEditText

        button = (Button)findViewById(R.id.webViewButton);
        button.setOnClickListener(handler);
    }

    // click event handler
    View.OnClickListener handler = new View.OnClickListener(){
        public void onClick(View v) {
            if(v==button){
                Intent intentApp = new Intent(MainActivity.this,
                    WebViewActivity.class);
                MainActivity.this.startActivity(intentApp);
            }
        }
    };

}
