package example.simplediallerapplication;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
//import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DaillerActivity extends Activity {
	EditText etNumber;
	Button btnCall;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dailler_layout);
		etNumber = (EditText) findViewById(R.id.etNumber);
		btnCall = (Button) findViewById(R.id.btnCall);
	}

	public void tapToDail(View view) {
		try {
			if (etNumber != null
					&& (etNumber.getText().length() == 10 || etNumber.getText()
							.length() == 11)) {
				Intent dailIntent = new Intent(Intent.ACTION_CALL,
						Uri.parse(" " + etNumber.getText()));
				startActivity(dailIntent);
			} else if (etNumber.getText().length() == 0) {
				Toast toast = Toast.makeText(getApplicationContext(),
						"You missed to type the number!", Toast.LENGTH_SHORT);
				toast.show();
			} else if (etNumber.getText().length() < 11 || etNumber.getText().length() >11) {
				Toast toast = Toast.makeText(getApplicationContext(),
						"Enter The Correct number!", Toast.LENGTH_SHORT);
				toast.show();
			}
		} catch (Exception e) {
			Log.e("DialerAppActivity", "error: " +
					e.getMessage(),e);
		}
	}
}