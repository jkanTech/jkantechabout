package com.jkantech.jkantechabout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=(findViewById(R.id.toolbar));
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("About jkanTech");


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    public void dev_mail_btn (View v){
        Intent intent = new Intent (Intent.ACTION_SENDTO, Uri.fromParts (
                "mailto", "jkantech@gmail.com", null));
        String subject = null;
        intent.putExtra (Intent.EXTRA_SUBJECT, subject);
        String message = null;
        intent.putExtra (Intent.EXTRA_TEXT, message);
        startActivity (Intent.createChooser (intent, ""));


    }
    public void dev_whatsapp_btn (View view) {
        Intent whatssap = new Intent ("android.intent.action.Main");
        whatssap.setComponent (new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
        StringBuilder stringBuilder = new StringBuilder ();
        stringBuilder.append (PhoneNumberUtils.stripSeparators ((String) "243892390948"));
        stringBuilder.append ("@s.whatsapp.net");
        whatssap.putExtra ("jid", stringBuilder.toString ());
        startActivity (whatssap);

        //AboutActivity.this.startActivity ();
    }

    public void noterapp(View v) {
        try {
            startActivity (new Intent (Intent.ACTION_VIEW,
                    Uri.parse ("market://details?id=" + getPackageName ())));
        } catch (ActivityNotFoundException e) {
            startActivity (new Intent (Intent.ACTION_VIEW,
                    Uri.parse ("http://play.google.com/store/apps/details?id=" + getPackageName ())));
        }

    }

    public void dev_fb_btn(View view) {

    startActivity(new Intent(Intent.ACTION_VIEW,
            Uri.parse("https://www.facebook.com/jkantech")));
    }

    public void gitub_btn(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://github.com/jkanTech")));

    }
    /*

    public void mecontacter_btn(View view) {
        String numero = "0972167764";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", numero, null));
        startActivity(intent);




    }

     */
}
