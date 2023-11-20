package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    private int numSales;
    private List<Double> salesData = new ArrayList<>();
    private int forecastPeriod;

    @FXML
    private TextField numSalesInput;

    @FXML
    private TextField salesInput;

    @FXML
    private TextField forecastPeriodInput;

    @FXML
    private Label salesInputLabel;

    @FXML
    private Label forecastLabel;

    @FXML
    private Label predictedSalesLabel;

    @FXML
    protected void onNumSalesInput() {
        try {
            numSales = Integer.parseInt(numSalesInput.getText());
            salesInputLabel.setVisible(true);
            salesInput.setVisible(true);
        } catch (NumberFormatException e) {
            predictedSalesLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    @FXML
    protected void onSalesInput() {
        try {
            double sales = Double.parseDouble(salesInput.getText());
            salesData.add(sales);
            if (salesData.size() < numSales) {
                salesInput.clear();
            } else {
                forecastLabel.setVisible(true);
                forecastPeriodInput.setVisible(true);
            }
        } catch (NumberFormatException e) {
            predictedSalesLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    @FXML
    protected void onPredictButtonClick() {
        try {
            forecastPeriod = Integer.parseInt(forecastPeriodInput.getText());

            // Calculate average sales
            double totalSales = 0;
            for (double sales : salesData) {
                totalSales += sales;
            }
            double averageSales = totalSales / numSales;

            // Calculate forecasted sales
            double forecastedSales = averageSales * forecastPeriod;

            // Display the predicted sales
            predictedSalesLabel.setText("Predicted Sales: " + forecastedSales);
        } catch (NumberFormatException e) {
            predictedSalesLabel.setText("Invalid input. Please enter a valid number.");
        }
    }
}
