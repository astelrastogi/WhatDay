package androidsamples.java.whatday;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private EditText editDate;
  private EditText editMonth;
  private EditText editYear;
  private Button btnCheck;
  private TextView txtOutput;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    editDate = findViewById(R.id.editDate);
    editMonth = findViewById(R.id.editMonth);
    editYear = findViewById(R.id.editYear);
    btnCheck = findViewById(R.id.btn_check);
    txtOutput = findViewById(R.id.txt_display);

    btnCheck.setOnClickListener(v -> {

      String date = (editDate.getText().toString());
      String month = (editMonth.getText().toString());
      String year = (editYear.getText().toString());

      DateModel.initialize(year, month, date);
      String output = DateModel.getMessage();
      txtOutput.setText(output);

    });
  }
}