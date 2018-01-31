package com.hat.testndk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.facebook.soloader.SoLoader;

import java.nio.ByteBuffer;

import javax.xml.transform.SourceLocator;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    // Example of a call to a native method
    tv = (TextView) findViewById(R.id.sample_text);

    }

    public void onBtnClick(View view) {
//         msg("test");
//        tv.setText(stringFromJNI());

        //I run below code can on android 4.4, samsung galaxy s5, there is no error.
//        System.loadLibrary("/system/lib/libmedia.so");

        /**
         * I run below code SoLoader on android 7.0, HuaWei meta 8, it reports below error.
         * When I use SoLoader, the error still exists.
         */
        //region 错误日志
        /**
         *  Caused by: java.lang.UnsatisfiedLinkError: dlopen failed: library "/system/lib/libmedia.so" needed or dlopened by "/vendor/lib/libnativeloader.so" is not accessible for the namespace "classloader-namespace"
         at java.lang.Runtime.load0(Runtime.java:914)
         at java.lang.System.load(System.java:1508)
         at com.facebook.soloader.DirectorySoSource.loadLibraryFrom(DirectorySoSource.java:71)
         at com.facebook.soloader.DirectorySoSource.loadLibrary(DirectorySoSource.java:42)
         at com.facebook.soloader.SoLoader.loadLibraryBySoName(SoLoader.java:299)
         at com.facebook.soloader.SoLoader.loadLibrary(SoLoader.java:247)
         at com.hat.testndk.MainActivity.onBtnClick(MainActivity.java:32)
         at java.lang.reflect.Method.invoke(Native Method) 
         at android.support.v7.app.AppCompatViewInflater$DeclaredOnClickListener.onClick(AppCompatViewInflater.java:288) 
         at android.view.View.performClick(View.java:5646) 
         at android.view.View$PerformClick.run(View.java:22459) 
         at android.os.Handler.handleCallback(Handler.java:761) 
         at android.os.Handler.dispatchMessage(Handler.java:98) 
         at android.os.Looper.loop(Looper.java:156) 
         at android.app.ActivityThread.main(ActivityThread.java:6523) 
         at java.lang.reflect.Method.invoke(Native Method) 
         at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:942) 
         at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:832) 
         */
        //endregion
        SoLoader.loadLibrary("media");
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native void msg(String str);

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
