package ru.verkhoumov.androidportfolio;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FeedbackFragment extends Fragment {
    public String to = "verkhoumov@yandex.ru";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);

        Button button = (Button) view.findViewById(R.id.buttonSendMessage);

        final EditText name = (EditText) view.findViewById(R.id.feedbackFormName);
        final EditText email = (EditText) view.findViewById(R.id.feedbackFormEmail);
        final EditText message = (EditText) view.findViewById(R.id.feedbackFormMessage);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                String _name = name.getText().toString();
                String _email = email.getText().toString();
                String _message = message.getText().toString();

                //
                String errors = getFormErrors(_name, _email, _message);

                //
                if (errors.length() == 0) {
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);

                    emailIntent.setType("text/plain");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {to});
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Обращение через форму обратной связи (Android)");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, _message);

                    startActivity(Intent.createChooser(emailIntent, "Выберите способ отправки:"));
                } else {
                    Toast
                            .makeText(getContext(), errors, Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

        return view;
    }

    public String getFormErrors(String name, String email, String message) {
        String errors = "";

        if (name.length() < 2 || name.length() > 30) {
            errors += "Длина имени может быть от 2 до 30 символов! ";
        }

        if (email.length() < 7 || name.length() > 60) {
            errors += "Длина электронный почты может быть от 7 до 60 символов! ";
        }

        if (message.length() < 10 || message.length() > 500) {
            errors += "Длина сообщения может быть от 10 до 500 символов!";
        }

        errors = errors.trim();

        return errors;
    }
}
