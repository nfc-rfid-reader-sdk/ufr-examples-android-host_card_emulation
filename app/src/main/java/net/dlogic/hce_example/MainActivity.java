package net.dlogic.hce_example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.text.Html;
import android.text.method.LinkMovementMethod;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView link = findViewById(R.id.textView);
        String linkText = "<a href='http://www.d-logic.com/nfc-rfid-reader-sdk'>http://www.d-logic.com/nfc-rfid-reader-sdk</a>";
        link.setLinkTextColor(0xD88DC34E);
        link.setText(Html.fromHtml(linkText));
        link.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
