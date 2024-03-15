package com.example.quizzz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class q {

    @FXML
    private Button answerBtn;

    @FXML
    private ToggleGroup answers;

    @FXML
    private Button exit_btn;

    @FXML
    private Text question_text;

    @FXML
    private RadioButton radio_btn_1;

    @FXML
    private RadioButton radio_btn_2;

    @FXML
    private RadioButton radio_btn_3;

    @FXML
    private RadioButton radio_btn_4;

    private Questions[] questions = new Questions[] {
            new Questions("Which of the options presents the correct format for displaying information on the screen?", new String[] {"Console.Write()", "console.log()", "print()", "System.out.println()"}),
            new Questions("What data type is responsible for integers?", new String[] {"String", "Float", "Boolean", "Integer"}),
            new Questions("Where is the new value correctly assigned to a multidimensional array?", new String[] {"a(0)(0) = 1;", " a[0 0] = 1;", " a{0}{0} = 1;", "a[0][0] = 1;"}),
            new Questions("Which method allows you to run a Java program?", new String[] {"There is no main method", "From the class that was written first and from the methods that are inside it", "Any, it can be set in the project settings", "From the main method in any of the classes"}),
            new Questions("Each file should be called...", new String[] {"by the name of the first library in it", "by the name of the package name", "whatever you want", "by the name of the class in it"}),
            new Questions("How many parameters can a function take?", new String[] {"5", "10", "20", "unlimited number"})
    };

    private int nowQuestion = 0, correctAnswers;
    private String nowCorrectAnswer;

    @FXML
    public void initialize() {
        nowCorrectAnswer = questions[nowQuestion].correctAnswer(); // We get correct answer from question

        answerBtn.setOnAction(e -> {
            // Get selected radio button from user
            RadioButton selectedRadioButton = (RadioButton) answers.getSelectedToggle();
            if(selectedRadioButton != null) {
                // Get text from selected radio button
                String toogleGroupValue = selectedRadioButton.getText();

                // Check if user selected correct answer
                if(toogleGroupValue.equals(nowCorrectAnswer)) {
                    System.out.println("Correct Answer");
                    correctAnswers++;
                } else {
                    System.out.println("Answer isn't correct");
                }

                // if it was last question, we hide all elements and show result
                if(nowQuestion + 1 == questions.length) {
                    radio_btn_1.setVisible(false);
                    radio_btn_2.setVisible(false);
                    radio_btn_3.setVisible(false);
                    radio_btn_4.setVisible(false);
                    answerBtn.setVisible(false);

                    question_text.setText("You gave correct answers on " + correctAnswers + " from " + questions.length + " questions");
                } else {
                    // if it wasn't last question, we show next question
                    nowQuestion++;
                    nowCorrectAnswer = questions[nowQuestion].correctAnswer();

                    question_text.setText(questions[nowQuestion].getQuestion());
                    String[] answers = questions[nowQuestion].getAnswers();

                    // we make list from array and shuffle it
                    List<String> intList = Arrays.asList(answers);

                    Collections.shuffle(intList);

                    // we set text to radio buttons
                    radio_btn_1.setText(intList.get(0));
                    radio_btn_2.setText(intList.get(1));
                    radio_btn_3.setText(intList.get(2));
                    radio_btn_4.setText(intList.get(3));

                    // we unselect radio button
                    selectedRadioButton.setSelected(false);
                }

            }
        });

        exit_btn.setOnAction(e -> {
            System.exit(0);
        });
    }

}
