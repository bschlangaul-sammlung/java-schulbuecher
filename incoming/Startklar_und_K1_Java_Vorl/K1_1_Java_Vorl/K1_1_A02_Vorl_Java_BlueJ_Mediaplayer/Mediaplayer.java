import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import java.io.File;

/**
 * Klasse zur Beschreibung eines Mediaplayers
 */
public class Mediaplayer extends Application {
    //medium1 und medium 2 durch Warteschlange ersetzen
    private Medium medium, medium1, medium2;
    private Media media;
    private MediaPlayer mediaPlayer;
    private MediaView mediaView;

    /**
     * Überschreiben der Startmethode der Application
     * @param primaryStage erste Stage
     */
    @Override public void start(Stage primaryStage) {
        //Hier die Warteschlange befüllen
        medium1 = new Medium("video1.mp4");
        medium2 = new Medium("audio1.wav");

        //jetzt für das Anzeigen das erste Medium aus der Warteschlange holen
        medium = medium1;

        media = new Media(new File(medium.NameGeben()).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView = new MediaView(mediaPlayer);

        Button playButton = new Button(">");
        playButton.setOnAction(e -> 
            {
                if (playButton.getText().equals(">")) 
                {
                    mediaView.getMediaPlayer().play();
                    playButton.setText("nächstes");
                } 
                else 
                {
                    //Hier stattdesssen das nächste Medium aus der Warteschlange entfernen.
                    medium = medium2;
                    if (medium!= null)
                    {
                        media = new Media(new File(medium.NameGeben()).toURI().toString());
                        mediaPlayer = new MediaPlayer(media);
                        mediaView.setMediaPlayer(mediaPlayer);
                        playButton.setText(">");
                    }

                }
            });

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(playButton);

        BorderPane pane = new BorderPane();
        pane.setCenter(mediaView);
        pane.setBottom(hBox);

        // Aufbau der Scene und platzieren auf der Stage
        Scene scene = new Scene(pane, 650, 500);
        primaryStage.setTitle("Video- und Audioplayer"); 
        primaryStage.setScene(scene); 
        primaryStage.show();    
    }

    /**
     * main-Methode
     */
    public static void main(String[] args) {
        launch(args);
    }
}

