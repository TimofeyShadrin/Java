package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    Label out;

    @FXML
    TextField outputTF;
    private static int number = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void onSubmit(ActionEvent event) {
        if(!outputTF.getText().isEmpty()) {
            try {
                number = Integer.parseInt(outputTF.getText());
                String temp = "\nTriangular number = " + String.valueOf(triangularNumber(number)) + "\n" +
                        "\nFactorial = " + String.valueOf(factorial(number)) +
                        "\n\nPrime numbers of " + number + " are:\n" + String.valueOf(primeNumbers(number));
                out.setText(String.valueOf(temp));
            }
            catch (Exception ex) {
                out.setText("Input is incorrect!");
            }
        }
    }

    public static int triangularNumber(int n) {
        int result = 0;
        result = n / 2 * (n + 1);
        return result;
    }

    public static float factorial(int n) {
        float result = 1f;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static ArrayList<Integer> primeNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            boolean test = true;
            for (int j = 2; j <= Math.floor(Math.sqrt(i)); j++) {
                if (i % j == 0) {
                    test = false;
                    break;
                }
            }
            if (test) {
                result.add(i);
            }
        }
        return result;
    }
}