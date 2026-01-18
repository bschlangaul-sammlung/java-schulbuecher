package schulbuecher.cornelsen.informatik_6.kapitel_01.thema_01.aufgabe_02.mediaplayer;
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
 * Klasse zur Verwaltung eines Mediaplayers
 */
public class Mediaplayer extends Application
{
    /**
     * Warteschlange des Players */
    private Warteschlange warteschlange;
    /**
     * Medium-Objekt */
    private Medium medium;
    /**
     * JavaFX-Media */
    private Media media;
    /**
     * JavaFX-Mediaplayer */
    private MediaPlayer mediaPlayer;
    /**
     * JavaFX-Mediaview */
    private MediaView mediaView;

    /**
     * Überschreiben der Startmethode der Application
     */
    @Override public void start(Stage primaryStage)
    {
        warteschlange = new Warteschlange();
        warteschlange.Einfügen(new Medium("video1.mp4"));
        warteschlange.Einfügen(new Medium("audio1.wav"));
        warteschlange.Einfügen(new Medium("audio2.wav"));
        warteschlange.Einfügen(new Medium("video2.mp4"));

        medium = warteschlange.Entfernen();

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
                medium = warteschlange.Entfernen();
                if (medium != null)
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
