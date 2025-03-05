import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

    public class InputChecks extends Application {

        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("Midwest Solar Installation Estimator");

            // First column of checkboxes (Left side)
            VBox column1 = new VBox(1);
            column1.getChildren().addAll(
                    checkBox("System rating (kW DC)"),
                    checkBox("Drive Time"),
                    checkBox("Number of staff on site")
            );

            // Second column of checkboxes (Right side)
            VBox column2 = new VBox(1);
            column2.setAlignment(Pos.CENTER_LEFT);
            column2.getChildren().addAll(
                    checkBox("Number of Solar Panels"),
                    checkBox("Roof Tile"),
                    checkBox("Interconnection Type")
            );

            // Make columns responsive
            column1.setFillWidth(true);
            column2.setFillWidth(true);

            // Wrap both columns in an HBox (side by side)
            HBox layout = new HBox(0, column1, column2);
            layout.setAlignment(Pos.CENTER_LEFT);
            layout.setStyle("-fx-padding: 5; -fx-alignment: center;");
            HBox.setHgrow(column1, Priority.ALWAYS);
            HBox.setHgrow(column2, Priority.ALWAYS);

            // Use a BorderPane to make the layout dynamically adjust
            BorderPane root = new BorderPane();
            root.setCenter(layout);

            Scene scene = new Scene(root, 600, 100);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        // Method to create a CheckBox with a given label
        private CheckBox checkBox(String name) {
            CheckBox checkBox = new CheckBox(name);
            checkBox.setStyle("-fx-font-size: 16px;"); // Increase font size
            return checkBox;
        }

        public static void main(String[] args) {
            launch(args);
        }
    }

