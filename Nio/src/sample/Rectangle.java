package sample;

/* import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;

public class Rectangle extends Node {
    Rectangle rectParallel = new Rectangle(10,200,50, 50);
rectParallel.setArcHeight(15);
rectParallel.setArcWidth(15);
rectParallel.setFill(Color.DARKBLUE);
rectParallel.setTranslateX(50);
rectParallel.setTranslateY(75);
...
    FadeTransition fadeTransition =
            new FadeTransition(Duration.millis(3000), rectParallel);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.3f);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);
    TranslateTransition translateTransition =
            new TranslateTransition(Duration.millis(2000), rectParallel);
        translateTransition.setFromX(50);
        translateTransition.setToX(350);
        translateTransition.setCycleCount(2);
        translateTransition.setAutoReverse(true);
    RotateTransition rotateTransition =
            new RotateTransition(Duration.millis(3000), rectParallel);
        rotateTransition.setByAngle(180f);
        rotateTransition.setCycleCount(4);
        rotateTransition.setAutoReverse(true);
    ScaleTransition scaleTransition =
            new ScaleTransition(Duration.millis(2000), rectParallel);
        scaleTransition.setToX(2f);
        scaleTransition.setToY(2f);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);

    parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
            fadeTransition,
            translateTransition,
            rotateTransition,
            scaleTransition
            );
        parallelTransition.setCycleCount(Timeline.INDEFINITE);
        parallelTransition.play();
}
*/