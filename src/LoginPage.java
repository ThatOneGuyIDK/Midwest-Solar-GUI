import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class LoginPage extends Application {

        private String adminUsername = "admin";
        private String adminPassword = "admin";

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
            //Creates the stage (window)
            //sets stage type (Decorated: title bar with x, minimize, etc.)
            primaryStage.initStyle(StageStyle.DECORATED);
            //sets title at top of window
            primaryStage.setTitle("Midwest Solar Installation Estimator");
            //Makes grid for placing the objects
            GridPane grid = new GridPane();
            //makes the grid visible
            grid.setGridLinesVisible(false);
            //sets the background as an image
            grid.setStyle("-fx-background-image: url('file:SolarpanelBackgroundPhoto.jpg'); " + "-fx-background-size: cover;");
            grid.setAlignment(Pos.CENTER);
            //sets the horizontal of the grid on the stage (moves objects accordingly)
            grid.setHgap(10);
            //sets vertical gaps between objects
            grid.setVgap(10);
            //sets distance between columns (top, right, bottom, left)
            grid.setPadding(new Insets(25, 25, 25, 25));

            //sets title text
            Text sceneTitle = new Text("Login");
            sceneTitle.setStyle("-fx-fill: #ffffff;");
            sceneTitle.setTextAlignment(TextAlignment.CENTER);
            //sets the font, type(Bold, thin, etc.), size
            sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
            //adds the Text to the stage .add(objName, ColumnsPosition, RowPosition, #OfColumnsSpan, #OfRowsSpan)
            grid.add(sceneTitle, 0, 0, 2, 1);




            //sets text above first input box
            Label userName = new Label("Email Id:");
            userName.setTextFill(javafx.scene.paint.Color.WHITE);
            //adds username text at column 1 row 2
            grid.add(userName, 0, 1);

            //the top user input box
            TextField userTextField = new TextField();
            userTextField.setStyle("-fx-background-color: #ffffff;");
            grid.add(userTextField, 1, 1);

            //text above second user input box
            Label pw = new Label("Password:");
            pw.setTextFill(javafx.scene.paint.Color.WHITE);
            grid.add(pw, 0, 2);

            //second text field
            PasswordField passwordBox = new PasswordField();
            passwordBox.setStyle("-fx-background-color: #ffffff;");
            grid.add(passwordBox, 1, 2);

            //sign in button
            //makes new button Button(String "buttonText", Node image)
            Button btn = new Button("Sign in");
            //sets button color
            btn.setStyle("-fx-fill-color: #ffffff;");

            //Makes horizontal box within the row the object is in (prevents overlap of children)
            HBox hbBtn = new HBox(1000);
            //sets the placement within row of the button
            hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
            //adds the button to the HBox
            hbBtn.getChildren().add(btn);
            //adds the button to the grid
            grid.add(hbBtn, 1, 4);


            final Text actiontarget = new Text();
            grid.add(actiontarget, 1, 6);


            //when button is clicked runs it runs action within method
            btn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                //runs the method on button click
                public void handle(ActionEvent e) {
                    //sets username to user input gathered from userTextField (first input box)
                    String username = userTextField.getText().toString();
                    //sets password to user input gathered from passowordBox (second input Box)
                    String password = passwordBox.getText().toString();

                    //alert if username is empty
                    if(userTextField.getText().isEmpty()) {
                        //runs showAlert method
                        showAlert(Alert.AlertType.ERROR, "Form Error!",
                                "Please enter your email id");
                        return;
                    }
                    //alert if password is empty
                    if(passwordBox.getText().isEmpty()) {
                        showAlert(Alert.AlertType.ERROR, "Form Error!",
                                "Please enter a password")


                        
                        return;
                    }

                    //checks if username and password are correct
                    if(adminUsername.equals(username) && adminPassword.equals(password)){
                        //runs infoBox method
                        infoBox("Login Successful!", null, "Success");
                    } else{
                        infoBox("Please enter correct Email and Password", null, "Failed");
                    }
                }
            });
            //makes the window (width, height)
            Scene scene = new Scene(grid, 300, 275);
            //sets the scene to be on the stage
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        private static void showAlert(Alert.AlertType alertType, String title, String message) {
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            //shows the alert but doesn't stop it from running in the background
            alert.show();
        }

        public static void infoBox(String infoMessage, String headerText, String title){
            //makes new alert pop up box with Alert type Confirmation (icon)
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            //sets text as parameter infoMessage
            alert.setContentText(infoMessage);
            alert.setTitle(title);
            alert.setHeaderText(headerText);
            //makes the alert show stops the program from continuing
            alert.showAndWait();
        }
    }

