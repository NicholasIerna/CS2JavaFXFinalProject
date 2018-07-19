import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.*;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

class ButtonDemo1 extends Application {
  protected Text text = new Text("Nicholas Ierna");
  
  protected BorderPane getPane() {
    HBox paneForButtons = new HBox(20);
    Button btLeft = new Button("^ Up");
    Button btRight = new Button("v Down"); 
    paneForButtons.getChildren().addAll(btLeft, btRight);
    paneForButtons.setAlignment(Pos.CENTER);

  //Creating the buttons and panes for the up/down section

    BorderPane pane = new BorderPane();
    
    Pane paneForText = new Pane();
    paneForText.getChildren().add(text);
   
    BorderPane paneForCenter = new BorderPane();
    paneForCenter.setLeft(paneForText);
  
    btLeft.setOnAction(e -> text.setY(text.getY() - 5));
    btRight.setOnAction(e -> text.setY(text.getY() + 5));
    

    pane.setCenter(paneForCenter);
    
    paneForCenter.setBottom(paneForButtons);

    return pane;
  }
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a scene and place it in the stage
    Scene scene = new Scene(getPane(), 800,650);
    primaryStage.setTitle("Assignment 7"); // Set Stage Title
    primaryStage.setScene(scene); // Scene into Stage
    primaryStage.show(); // Show stage
  }
}

class CheckBoxDemo1 extends ButtonDemo1 {
  @Override // Override the getPane() method in the super class
  protected BorderPane getPane() {
    BorderPane pane = super.getPane();

  //Creating the font, Helvetica instead of Times New Roman

    Font fontBoldItalic = Font.font("Helvetica",       FontWeight.BOLD, FontPosture.ITALIC, 32);
    Font fontBold = Font.font("Helvetica",       FontWeight.BOLD, FontPosture.REGULAR, 32);
    Font fontItalic = Font.font("Helvetica",       FontWeight.NORMAL, FontPosture.ITALIC, 32);
    Font fontNormal = Font.font("Helvetica",       FontWeight.NORMAL, FontPosture.REGULAR, 32);
    
    text.setFont(fontNormal);
    
    VBox paneForCheckBoxes = new VBox(20);
    paneForCheckBoxes.setPadding(new Insets(5, 5, 5, 5)); 
    paneForCheckBoxes.setStyle("-fx-border-color: black");
    paneForCheckBoxes.setStyle
      ("-fx-border-width: 2px; -fx-border-color: black");  //Set borders of box to black
    CheckBox chkBold = new CheckBox("Bold");
    CheckBox chkItalic = new CheckBox("Italic");
    paneForCheckBoxes.getChildren().addAll(chkBold, chkItalic);
    pane.setLeft(paneForCheckBoxes);

    EventHandler<ActionEvent> handler = e -> { 
      if (chkBold.isSelected() && chkItalic.isSelected()) {
        text.setFont(fontBoldItalic); // Both check boxes checked
      }
      else if (chkBold.isSelected()) {
        text.setFont(fontBold); // The Bold check box checked
      }
      else if (chkItalic.isSelected()) {
        text.setFont(fontItalic); // The Italic check box checked
      }      
      else {
        text.setFont(fontNormal); // Both check boxes unchecked
      }
    };
    
    chkBold.setOnAction(handler);
    chkItalic.setOnAction(handler);
    
    
    return pane; // Return a new pane
  }
}

class RadioButton1 extends CheckBoxDemo1 {
  @Override // Override the getPane() method in the super class
  protected BorderPane getPane() {
    BorderPane pane = super.getPane();

    VBox paneForRadioButtons = new VBox(20);
    paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5)); 
    paneForRadioButtons.setStyle("-fx-border-color: black");
    paneForRadioButtons.setStyle
      ("-fx-border-width: 2px; -fx-border-color: black");  //Set borders of box to black
    RadioButton rbRed = new RadioButton("Magenta");
    RadioButton rbGreen = new RadioButton("Yellow");
    RadioButton rbBlue = new RadioButton("Cyan");
    paneForRadioButtons.getChildren().addAll(rbRed, rbGreen, rbBlue);
    pane.setRight(paneForRadioButtons);

    ToggleGroup group = new ToggleGroup();
    rbRed.setToggleGroup(group);
    rbGreen.setToggleGroup(group);
    rbBlue.setToggleGroup(group);
    
    //Seeing which button is pushed
    
    rbRed.setOnAction(e -> {
      if (rbRed.isSelected()) {
        text.setFill(Color.MAGENTA);
      }
    });
    
    rbGreen.setOnAction(e -> {
      if (rbGreen.isSelected()) {
        text.setFill(Color.YELLOW);
      }
    });

    rbBlue.setOnAction(e -> {
      if (rbBlue.isSelected()) {
        text.setFill(Color.CYAN);
      }
    });
    
    return pane;
  }
}

class RectanglePane1 extends Pane { // Borderpane makes the panes stack?
  public final double radius = 20;
  private double x = radius, y = radius;
  private double dx = 1, dy = 1;
  private Rectangle shape = new Rectangle(50, 30, 100, 50);

  private Timeline animation;

  public RectanglePane1() {
    shape.setFill(Color.RED); // Set Rectangle color
    getChildren().add(shape); // Place a Rectangle

    // Create an animation for moving the Rectangle
    animation = new Timeline(
      new KeyFrame(Duration.millis(16), e -> moveRectangle()));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation
  }

  public void play() {
    animation.play();
  }

  public void pause() {
    animation.pause();
  }

  public void increaseSpeed() {
    animation.setRate(animation.getRate() + 0.1);
  }

  public void decreaseSpeed() {
    animation.setRate(
      animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
  }

  public DoubleProperty rateProperty() {
    return animation.rateProperty();
  }
  
  protected void moveRectangle() {
    // Check boundaries
    if (x <1|| x > 600 ) {
      dx *= -1; // Change direction
    }
    if (y < 1 || y > 50 ) {
      dy *= -1; // Change direction
    }

    // Adjust position
    x += dx;
    y += dy;
    shape.setX(x);
    shape.setY(y);
  }
}

 class Bounce1 extends RadioButton1 {
  @Override // Override the start method in the Application class
  
      protected BorderPane getPane() {
    BorderPane pane = super.getPane();

      //Creating the bouncing rectangle and speed slider
    
     VBox paneForBouncingRectangle = new VBox(25);
      paneForBouncingRectangle.setMaxWidth(650);
      paneForBouncingRectangle.setMaxHeight(150);  
      paneForBouncingRectangle.setMinWidth(750);
      paneForBouncingRectangle.setMinHeight(150);     
    paneForBouncingRectangle.setPadding(new Insets(10,10,50,10)); 
      RectanglePane1 RectanglePane2 = new RectanglePane1();
       Slider slSpeed = new Slider();
       slSpeed.setMax(15);
       RectanglePane2.rateProperty().bind(slSpeed.valueProperty());
    paneForBouncingRectangle.getChildren().addAll(RectanglePane2, slSpeed);
      ListView list = new ListView();
    pane.setTop(paneForBouncingRectangle);

  return pane;
  }
}


public class n00965583 extends Bounce1 {
  private static final String MEDIA_URL = /*"http://cs.armstrong.edu/liang/common/sample.mp4"*/"http://www.unf.edu/~n00965583/CompSciVid.mp4";

  @Override // Override the start method in the Application class
  //public void start(Stage primaryStage) {
      protected BorderPane getPane() {
       BorderPane pane = super.getPane();
   
    Media media = new Media(MEDIA_URL);  //Creating the media player
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    MediaView mediaView = new MediaView(mediaPlayer);

  //Creating all the buttons

    Button playButton = new Button(">");
    playButton.setOnAction(e -> {
      if (playButton.getText().equals(">")) {
        mediaPlayer.play();
        playButton.setText("||");
      } else {
        mediaPlayer.pause();
        playButton.setText(">");
      }
    });

    Button rewindButton = new Button("<<");
    rewindButton.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));
    
      //Creating the volume slider
    
    Slider slVolume = new Slider();
    slVolume.setPrefWidth(150);
    slVolume.setMaxWidth(Region.USE_PREF_SIZE);
    slVolume.setMinWidth(30);
    slVolume.setValue(50);
    mediaPlayer.volumeProperty().bind(
      slVolume.valueProperty().divide(100));

    HBox hBox = new HBox(10);
    hBox.setAlignment(Pos.CENTER);
    hBox.getChildren().addAll(playButton, rewindButton,
      new Label("Volume"), slVolume);

BorderPane paneforvid = new BorderPane();
pane.setBottom(paneforvid);

    paneforvid.setCenter(mediaView);
    paneforvid.setBottom(hBox);

  return pane;
  }
  
  public static void main(String[] args) {
    launch(args);
  }
}