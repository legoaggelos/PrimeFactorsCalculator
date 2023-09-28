package com.legoaggelos.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static com.legoaggelos.app.PrimeFactorCalculator.calculatePrimeFactors;

public class App extends Application {
    @Override
    public void start(Stage primaryStage){
        VBox components = new VBox();

        Label promptText = new Label("Enter number to calculate prime factors for(goes up to 2100000000):");

        TextArea numberInput = new TextArea("");
        numberInput.setPrefSize(26, 62);

        TextArea primeFactors = new TextArea("");

        primeFactors.setEditable(false);

        Button showDigits = new Button("Calculate");
        showDigits.setOnAction(event -> {
            try {
                int number = Integer.parseInt(numberInput.getText().trim());
                if (number < 1) {
                    primeFactors.setText("Number must be positive!");
                    return;
                }
                if (number <= 2100000000) {
                    primeFactors.setText("Calculating...");
                    primeFactors.setText(calculatePrimeFactors(number));
                }
            } catch (NumberFormatException e) {
                primeFactors.setText("That wasn't an acceptable number!");
            }
        });

        components.getChildren().addAll(promptText, numberInput, showDigits, primeFactors);
        Scene scene = new Scene(components, 600, 300);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("PrimeFactorsCalculator");
        primaryStage.show();
    }
}
