package pe.edu.cibertec.geoquiz.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pe.edu.cibertec.geoquiz.R;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    Button btYes, btNo, btNext, btPrevious;
    TextView tvQuestion;
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setListeners();
        configureMvp();
    }

    private void configureMvp() {
        this.presenter = new MainPresenter(this);
        MainActivity.this.presenter.getPosition();
        MainActivity.this.presenter.createArrayQuestions();
        MainActivity.this.presenter.loadQuestions(MainActivity.this);
        MainActivity.this.presenter.showQuestions();
    }

    private void setListeners() {
        btYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.verifyResponse(MainActivity.this, true);
            }
        });
        btNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.verifyResponse(MainActivity.this, false);
            }
        });
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.presenter.updatePosition();
               // showActualQuestion();
            }
        });
    }

    private void initViews() {
        btYes = findViewById(R.id.btYes);
        btNo = findViewById(R.id.btNo);
        btNext = findViewById(R.id.btNext);
        btPrevious = findViewById(R.id.btPrevious);
        tvQuestion = findViewById(R.id.tvQuestion);
    }

    @Override
    public void showActualQuestions(String question) {
        tvQuestion.setText(question);
    }
}
