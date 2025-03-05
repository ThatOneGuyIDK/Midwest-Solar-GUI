import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

    public class InputsPage extends Application {

        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("Midwest Solar Installation Estimator");
            // Create a VBox for checkboxes and align it to the right
            VBox checkBoxContainer = new VBox(10, checkBox("Squirrel Screen"), checkBox("Consider Weather"));
            checkBoxContainer.setStyle("-fx-padding: 5;");
            VBox inputs = new VBox(100, inputBox("System Rating (kW DC)", 50), inputBox("Drive Time", 50), inputBox("Number of staff on site", 50),inputBox("Interconnection Type", 50), createSlider("Roof Tilt", 10, 60, 300), createSlider("Number of solar panels", 1, 65, 300));
            inputs.setStyle("-fx-padding: 10; -fx-alignment: CENTER;");
            // Aligning checkboxes to the right
            HBox mainLayout = new HBox(5, inputs, checkBoxContainer);



            Scene scene = new Scene(mainLayout, 300, 200);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        public static HBox createSlider(String name, int min, int max, double width) {
            Slider slider = new Slider();
            slider.setStyle("-fx-tick-label-font: 20px \"Arial\";");
            slider.setMin(min);
            slider.setMax(max);
            slider.setValue((min + max) / 2); // Default value to midpoint
            slider.setShowTickLabels(true);
            slider.setShowTickMarks(true);
            slider.setMajorTickUnit((max - min) / 4.0);
            slider.setMinorTickCount(5);
            slider.setBlockIncrement(10);
            slider.setPrefWidth(width);

            Label nameLabel = new Label(name);
            nameLabel.setFont(new Font("Arial", 20));
            Label valueLabel = new Label("Value: " + (int) slider.getValue());

            slider.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    valueLabel.setText("Value: " + newValue.intValue());
                }
            });

            return new HBox(10, nameLabel, slider, valueLabel);
        }

        public static HBox inputBox(String name, double width) {
            Label label = new Label(name);
            label.setFont(new Font("Arial", 20));
            TextField textField = new TextField();
            textField.setPrefWidth(width);
            return new HBox(10, label, textField);
        }
        public static HBox checkBox(String name) {
            CheckBox checkBox = new CheckBox(name);
            checkBox.setFont(new Font("Arial", 20));
            return new HBox(10, checkBox);
        }
        public static void main(String[] args) {
            launch(args);
        }
    }