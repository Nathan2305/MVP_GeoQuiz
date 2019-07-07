package pe.edu.cibertec.geoquiz.ui.main;

import android.content.Context;

import java.util.ArrayList;

import pe.edu.cibertec.geoquiz.model.Question;

public interface MainContract {

    interface MainView{
        void showActualQuestions(String q);
    }
    interface MainPresenter{
       void verifyResponse(Context context,boolean opt);
       int getPosition();
       ArrayList<Question> createArrayQuestions();
       void loadQuestions(Context context);
       void updatePosition();
    }
}
