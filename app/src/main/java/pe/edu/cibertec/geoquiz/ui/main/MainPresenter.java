package pe.edu.cibertec.geoquiz.ui.main;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

import pe.edu.cibertec.geoquiz.R;
import pe.edu.cibertec.geoquiz.model.Question;

public class MainPresenter implements MainContract.MainPresenter {
    MainContract.MainView mainView;
    int actualPosition = 0;
    ArrayList<Question> questions;

    public MainPresenter(MainContract.MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void verifyResponse(Context context, boolean option) {
        Question actualQuestion = questions.get(actualPosition);
        if (option == actualQuestion.isResponse()) {
            showToast(context, context.getString(R.string.answer_correct));
        } else {
            showToast(context, context.getString(R.string.answer_incorrect));
        }
    }

    @Override
    public int getPosition() {
        return actualPosition;
    }

    @Override
    public ArrayList<Question> createArrayQuestions() {
        questions = new ArrayList<>();
        return questions;
    }

    @Override
    public void loadQuestions(Context context) {
        Question questionPeru =
                new Question(context.getString(R.string.peru_question), true);
        questions.add(questionPeru);
        Question questionChile =
                new Question(context.getString(R.string.chile_question), false);
        questions.add(questionChile);
        Question questionColombia =
                new Question(context.getString(R.string.colombia_question), true);
        questions.add(questionColombia);
    }

    @Override
    public void updatePosition() {
        actualPosition += 1;
        if (actualPosition == questions.size()) {
            actualPosition = 0;
        }
        showQuestions();
    }


    public void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public void showQuestions() {
        MainPresenter.this.mainView.showActualQuestions(questions.get(actualPosition).getName());
    }
}
