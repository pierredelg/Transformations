package transforms;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
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
    public Slider t2x;

    @FXML
    public Slider t2y;
    
    @FXML 
    public Slider t3;
    
    @FXML 
    public Slider r;

    @FXML
    public TextField tf1x;

    @FXML
    public TextField tf1y;
    
    @FXML
    public TextField tf2x;

    @FXML
    public TextField tf2y;
    
    @FXML 
    public TextField tf3;
    
    @FXML 
    public TextField rf;
    

    private Translate t1 = new Translate(0.0, 0.0);
    
    private Translate t2 = new Translate(0.0, 0.0);
    
    private Rotate r1 = new Rotate(0.0);
    
    private Scale s1 = new Scale(1,1,0,0);
    
    
    ChangeListener<Number> listener1 = new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            tf1x.setText(Double.toString(t1x.getValue()));
            tf1y.setText(Double.toString(t1y.getValue()));
            updateT1();
        }
    };
    

    /**
     *@author Pierre Delgrange
     */
    ChangeListener<Number> listener2 = new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            tf2x.setText(Double.toString(t2x.getValue()));
            tf2y.setText(Double.toString(t2y.getValue()));
            updateT2();
        }
    };

    ChangeListener<Number> listener3 = new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            tf3.setText(Double.toString(t3.getValue()));
            updateT3();
        }
    };
    
    ChangeListener<Number> listener4 = new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            rf.setText(Double.toString(r.getValue()));
            updateT4();
        }
    };

    /**
     *@author PIERRE OU LUDO ?
     */
    private void updateT1() {
        t1.setX(t1x.getValue());
        t1.setY(t1y.getValue());
        
    }
    

    /**
     *@author PIERRE OU LUDO ?
     */
    private void updateT2() {
        t2.setX(t2x.getValue());
        t2.setY(t2y.getValue());
    }
    

    private void updateT3() {
    	
    	s1.setX(t3.getValue());
    	s1.setY(t3.getValue());
  
    }
    
    private void updateT4() {
    	
    	r1.setAngle(r.getValue());
    	
    }
    
  
    @FXML
    /**
     *@author Ismerie PERROT
     */
    public void setT1X() {
    	t1x.setValue(Double.parseDouble(tf1x.getText()));
    }

    @FXML
    /**
     *@author Ismerie PERROT
     */
    public void setT1Y() {
    	t1y.setValue(Double.parseDouble(tf1y.getText()));
    }
    
    @FXML
    /**
     *@author Ismerie PERROT
     */
    public void setA() {
    	r1.setAngle(Double.parseDouble(rf.getText()));
    }
    
    public void setT3() {
    	t3.setValue(Double.parseDouble(tf3.getText()));
    }


    @FXML
    public void setT2X() {
    	t2x.setValue(Double.parseDouble(tf2x.getText()));
    }

    @FXML
    public void setT2Y() {
    	t2y.setValue(Double.parseDouble(tf2y.getText()));
    }



    public void initializeLine() {
    	
    	for(int i = 20; i <= Constants.MAX_Y; i+=30) {
    		
    		Line ligneH = new Line(0.0, i, 400.0, i);
    		Line ligneV = new Line(i,0.0, i, 400.0);
    		if(i == 200) {
    			ligneH.setStrokeWidth(1.2);
    			ligneV.setStrokeWidth(1.2);
    		}else {
    			ligneH.setStrokeWidth(0.5);
    			ligneV.setStrokeWidth(0.5);
    		}
    		pane.getChildren().addAll(ligneH,ligneV);
    	}	

    }

    
    public void initialize() {
    	Polyline polygon = new Polyline(200.0,200.0,200.0,140.0,230.0,110.0,260.0,140.0,260.0,200.0,245.0,200.0,245.0,155.0,230.0,155.0,230.0,200.0,200.0,200.0,260.0,200.0,260.0,140.0,200.0,140.0);
    	Polyline polygon2 = new Polyline(200.0,200.0,200.0,140.0,230.0,110.0,260.0,140.0,260.0,200.0,245.0,200.0,245.0,155.0,230.0,155.0,230.0,200.0,200.0,200.0,260.0,200.0,260.0,140.0,200.0,140.0);
    	polygon.setStroke(Color.BLUE);
    	polygon.setStrokeWidth(1.4);
    	polygon2.setStroke(Color.RED);
    	polygon2.setStrokeWidth(1.4);
    	
    	initializeLine();


        pane.getChildren().addAll(polygon,polygon2);
        polygon.getTransforms().addAll(t1,s1,r1);
		polygon2.getTransforms().addAll(t2);

        t1x.valueProperty().addListener(listener1);
        t1y.valueProperty().addListener(listener1);
        t2x.valueProperty().addListener(listener2);
        t2y.valueProperty().addListener(listener2);
        r.valueProperty().addListener(listener4);
        
        t3.valueProperty().addListener(listener3);
    }
}
