package transforms;

import static transforms.Constants.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;

public class Controller {

    @FXML
    public Pane pane;

//    //--------------- Translation 1
//    @FXML
//    CheckBox cbt1;
//
    @FXML
    public Slider t1x;

    @FXML
    public Slider t1y;

    @FXML
    public TextField tf1x;

    @FXML
    public TextField tf1y;

    private Translate t1 = new Translate(0.0, 0.0);
    
    ChangeListener<Number> listener1 = new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            tf1x.setText(Double.toString(t1x.getValue()));
            tf1y.setText(Double.toString(t1y.getValue()));
            updateT1();
        }
    };

    
    private void updateT1() {
        t1.setX(t1x.getValue());
        t1.setY(t1y.getValue());
    }

    @FXML
    public void setT1X() {
    	t1x.setValue(Double.parseDouble(tf1x.getText()));
    }

    @FXML
    public void setT1Y() {
    	t1y.setValue(Double.parseDouble(tf1y.getText()));
    }

    @FXML
    public void setA() {
    }

    @FXML
    public void setT2X() {
    }

    @FXML
    public void setT2Y() {
    }

    public void initialize() {
    	Rectangle shape1 = new Rectangle (20,40,30,50);
    	shape1.setFill(Color.RED);
    	Rectangle shape2 = new Rectangle (20,40,30,50);
    	shape2.setFill(Color.BLUE);
        pane.getChildren().addAll(shape1, shape2);
        shape2.getTransforms().addAll(t1);

        t1x.valueProperty().addListener(listener1);
        t1y.valueProperty().addListener(listener1);
    }
}
