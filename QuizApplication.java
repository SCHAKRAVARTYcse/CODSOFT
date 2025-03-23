import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private JFrame frame;
    private JLabel questionLabel, timerLabel, scoreLabel;
    private JRadioButton[] options;
    private ButtonGroup group;
    private JButton nextButton;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private Timer timer;
    private int timeLeft = 10; // 10 seconds per question

    // List of questions
    private List<Question> questions;

    public QuizApplication() {
        frame = new JFrame("Quiz Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new GridLayout(6, 1));

        questionLabel = new JLabel();
        timerLabel = new JLabel("Time left: 10s");
        scoreLabel = new JLabel("Score: 0");

        options = new JRadioButton[4];
        group = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            group.add(options[i]);
        }

        nextButton = new JButton("Next");
        nextButton.addActionListener(new NextButtonListener());

        frame.add(questionLabel);
        frame.add(timerLabel);
        for (JRadioButton option : options) {
            frame.add(option);
        }
        frame.add(nextButton);
        frame.add(scoreLabel);

        loadQuestions();
        displayQuestion();

        frame.setVisible(true);
    }

    
    private void loadQuestions() {
        questions = new ArrayList<>();
        questions.add(new Question("What is the capital of Odisha?", new String[]{"Ranchi", "Madrid", "Bhubaneswar", "Mumbai"}, 2));
        questions.add(new Question("2 x 100 equals?", new String[]{"3", "200", "523", "6"}, 1));
        questions.add(new Question("Who is the founder of Amazon?", new String[]{"Jeff Bezos", "Bill Gates", "Jack Ma", "Jensen Huang"}, 0));
    }

    
    private void displayQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question q = questions.get(currentQuestionIndex);
            questionLabel.setText(q.getQuestion());
            for (int i = 0; i < 4; i++) {
                options[i].setText(q.getOptions()[i]);
                options[i].setSelected(false);
            }
            startTimer();
        } else {
            showResults();
        }
    }

    // Start the timer
    private void startTimer() {
        if (timer != null) {
            timer.cancel();
        }
        timeLeft = 10;
        timerLabel.setText("Time left: " + timeLeft + "s");

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeLeft--;
                timerLabel.setText("Time left: " + timeLeft + "s");
                if (timeLeft == 0) {
                    timer.cancel();
                    checkAnswer(-1); // No answer selected
                }
            }
        }, 1000, 1000);
    }

    // Check answer and move to next question
    private void checkAnswer(int selectedOption) {
        timer.cancel();
        if (selectedOption == questions.get(currentQuestionIndex).getCorrectAnswer()) {
            score++;
            scoreLabel.setText("Score: " + score);
        }
        currentQuestionIndex++;
        displayQuestion();
    }

    // Show final results
    private void showResults() {
        JOptionPane.showMessageDialog(frame, "Quiz Over! Your Score: " + score + "/" + questions.size());
        frame.dispose();
    }

    // Button Click Listener
    private class NextButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 4; i++) {
                if (options[i].isSelected()) {
                    checkAnswer(i);
                    return;
                }
            }
            checkAnswer(-1); // If no answer is selected
        }
    }

    // Question Class
    private static class Question {
        private String question;
        private String[] options;
        private int correctAnswer;

        public Question(String question, String[] options, int correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        public String getQuestion() {
            return question;
        }

        public String[] getOptions() {
            return options;
        }

        public int getCorrectAnswer() {
            return correctAnswer;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuizApplication::new);
    }
}
