package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loadingFormController implements Initializable {
    public ImageView imageView;
    public ImageView btnCloase;
    public ImageView btnClose;
    public VBox V_Box;
    public JFXButton btnSignIn;
    public AnchorPane LodingForm;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imageView.setCache(true);

        Timeline timeline = new Timeline();
        KeyFrame keyFrame1 = new KeyFrame(Duration.millis(5000), actionEvent -> {
            System.out.println("Initializing Application....");
            System.out.println("Welcome to System v1.0.0");
        });

        timeline.getKeyFrames().addAll(keyFrame1);
        timeline.playFromStart();

        timeline.setOnFinished(actionEvent -> {
            try {
                LodingForm.getScene().getWindow().hide();

                Parent root = FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}




