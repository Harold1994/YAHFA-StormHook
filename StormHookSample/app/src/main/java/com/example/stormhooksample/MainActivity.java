package com.example.stormhooksample;

import android.app.Activity;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private LocationManager locationManager;
    private String locationProvider;
    private static final String TAG = "storm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button1);
        //Button button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Log.e() should be hooked
                Log.e("origin", "call Log.e()");
                // String.startsWith() should be hooked
                Log.w("origin", "foo startsWith f is " + "foo".startsWith("f"));
                // ClassWithVirtualMethod.tac() should be hooked
                Log.w("origin", "virtual tac a,b,c,d, got " +
                        new ClassWithVirtualMethod().tac("a", "hook代码", "c", "d"));
                // ClassWithStaticMethod.tac() should be hooked
                Log.w("origin", "static tac a,b,c,d, got " +
                        ClassWithStaticMethod.tac("a", "b", "c", "d"));
            }
        });

    }
}
