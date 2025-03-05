import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TimeOutput extends Application {
    private Label timeLabel;

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(20);

        // Create the scene first
        Scene scene = new Scene(root, 600, 400);

        // Add the time estimate box
        root.getChildren().add(TimeOutput.createTimeEstimateBox("45", "55", 75, scene));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Midwest Solar Installation Estimator");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
        public static StackPane createTimeEstimateBox(String startTime, String endTime, int Confidence, Scene scene) {
            // Container for the label
            StackPane timeBox = new StackPane();
            timeBox.setStyle("-fx-background-color: #1E2A38; -fx-padding: 20px; -fx-background-radius: 10px;");

            // Label for the time estimate
            Label timeLabel = new Label(formatTimeText(startTime, endTime, Confidence));
            timeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            timeLabel.setTextFill(Color.web("#FFD700")); // Solar gold text

            // Add label to the box
            timeBox.getChildren().add(timeLabel);
            StackPane.setAlignment(timeLabel, Pos.CENTER);

            // Adjust text size dynamically when the window resizes
            scene.widthProperty().addListener((obs, oldVal, newVal) -> resizeText(timeLabel, newVal.doubleValue()));

            return timeBox;
        }

        // Formats the time estimate text
        private static String formatTimeText(String startTime, String endTime, int confidence) {
            return "Estimate: " + startTime + " - " + endTime + "  |  Confidence Level: " + confidence + "%";
        }

        // Adjusts text size based on window width
        private static void resizeText(Label label, double width) {
            double newSize = width / 20;
            label.setFont(Font.font("Arial", FontWeight.BOLD, Math.max(16, newSize)));
        }


}
