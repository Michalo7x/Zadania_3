package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Label label;
    @FXML
    private TextField field;
    @FXML
    private RadioButton input_c;
    @FXML
    private RadioButton input_f;
    @FXML
    private RadioButton input_k;
    @FXML
    private RadioButton output_c;
    @FXML
    private RadioButton output_f;
    @FXML
    private RadioButton output_k;

    public void licz() {
        String wej = field.getText();
        if (isNumeric(wej) == true) {
            Double x = Double.parseDouble(wej);
            if (input_c.isSelected() == true) {
                if (output_c.isSelected() == true)
                    show(x);
                if (output_k.isSelected() == true) {
                    x = x + 273.15;
                    show(x);
                }
                if (output_f.isSelected() == true) {
                    x = 1.8 * x + 32;
                    show(x);
                }
            }
            if (input_f.isSelected() == true) {
                if (output_f.isSelected() == true)
                    show(x);
                if (output_c.isSelected() == true) {
                    x = (x - 32) * 5 / 9;
                    show(x);
                }
                if (output_k.isSelected() == true) {
                    x = (x + 459.67) * 5 / 9;
                    show(x);
                }
            }
            if (input_k.isSelected() == true) {
                if (output_k.isSelected() == true)
                    show(x);
                if (output_c.isSelected() == true) {
                    x = x - 273.15;
                    show(x);
                }
                if (output_f.isSelected() == true) {
                    x = x * 9 / 5 - 459.67;
                    show(x);
                }
            }
        }
        else{
            label.setText("Podana wartość nie jest liczbą!");
        }
    }

    public void show(double wyj){
        wyj = wyj*100;
        wyj = Math.round(wyj);
        wyj = wyj/100;
        String wyswietl = Double.toString(wyj);
        label.setText(wyswietl);
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

}
