
package org.octaviocorzo.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.octaviocorzo.bean.Suma;
import org.octaviocorzo.bean.Resta;
import org.octaviocorzo.bean.Multiplicacion;
import org.octaviocorzo.bean.Division;
import org.octaviocorzo.bean.Porcentaje;
import org.octaviocorzo.bean.Reciproco;
import org.octaviocorzo.bean.RaizCuadrada;
import org.octaviocorzo.bean.CambiarSigno;
import org.octaviocorzo.bean.ElevarCuadrado;
import org.octaviocorzo.bean.Operacion;


/**
 *
 * @author Octavio Corzo
 * @date 21/03/2022
 * carné: 2021084
 * IN5BM
 * Grupo: 2 (Lunes)
 */
public class FXMLCalculadoraController implements Initializable {

    private float resultado;
    private float numero;
    private int contadorOperadores;
    private String operadorAnterior;
    private boolean ingresoNuevo = false;
    
    @FXML
    private Label lblPantalla;
    
    @FXML
    private Button btnPunto;
    
    @FXML
    private Button btnSuma;
    
    @FXML
    private Button btnResta;
    
    @FXML
    private Button btnMultiplicacion;
    
    @FXML
    private Button btnDivision;
    
    @FXML
    private Button btnPorcentaje;
    
    @FXML
    private Button btnLimpiar;
    
    @FXML
    private Button btnCambiarSigno;
    
    @FXML
    private Button btnIgual;
    
    @FXML
    private Button btnCero;
    
    @FXML
    private Button btnUno;
    
    @FXML
    private Button btnDos;
    
    @FXML 
    private Button btnTres;

    @FXML
    private Button btnCuatro;
    
    @FXML
    private Button btnCinco;
    
    @FXML
    private Button btnSeis;
    
    @FXML
    private Button btnSiete;
    
    @FXML
    private Button btnOcho;
    
    @FXML
    private Button btnNueve;
    
    @FXML
    private Button btnReciproco;
    
    @FXML 
    private Button btnRaizCuadrada;
    
    @FXML
    private Button btnDel;
    
    @FXML
    private Button btnElevarCuadrado;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void actualizarPantalla(String digito){
        lblPantalla.setText(lblPantalla.getText() + digito);
    }
    
    public void agregarPunto(){
        String cadena = lblPantalla.getText();
        
        if(cadena.length() <= 0){
            lblPantalla.setText("0.");
        }else if(!(lblPantalla.getText().contains("."))){
            actualizarPantalla(".");
        }
    }
    
    @FXML
    private void clicElevarCuadrado(){
       contadorOperadores++;
       resultado = 1;
       operadorAnterior = "x";
       operar("");
       ingresoNuevo = false;
       lblPantalla.setText(String.valueOf(resultado));
    }
    
    @FXML
    private void clicDel(){
        String cadena;
        cadena=lblPantalla.getText();

        if(cadena.length()>0){
            cadena=cadena.substring(0, cadena.length()-1);
            lblPantalla.setText(cadena);
        }
    }
    
    @FXML 
    private void clicPunto(){
        agregarPunto();
    }
    
    @FXML
    private void clicUno(){
        actualizarPantalla("1");
    }
    
    @FXML
    private void clicCero(){
        if(lblPantalla.getText().equals("")){
            actualizarPantalla("0");
        }else if(!(lblPantalla.getText().charAt(0) == '0')){
            actualizarPantalla("0");
        }
    }
    
    @FXML
    private void clicIgual(){
       operar(this.operadorAnterior); 
       lblPantalla.setText(String.valueOf(this.resultado)); 
       operadorAnterior = "";
    }
    
    @FXML
    private void clicDos(){
        actualizarPantalla("2");
    }
    
    @FXML
    private void clicTres(){
        actualizarPantalla("3");
    }
    
    @FXML
    private void clicCuatro(){
        actualizarPantalla("4");
    }
    
    @FXML
    private void clicCinco(){
        actualizarPantalla("5");
    }
    
    @FXML
    private void clicSeis(){
        actualizarPantalla("6");
    }
    
    @FXML
    private void clicSiete(){
        actualizarPantalla("7");
    }
    
    @FXML
    private void clicOcho(){
        actualizarPantalla("8");
    }
    
    @FXML
    private void clicNueve(){
        actualizarPantalla("9");
    }
    
    @FXML
    private void clicSuma(){
        operar("+");
    }
    
    @FXML
    private void clicResta(){
        operar("-");
    }
    
    @FXML
    private void clicMultiplicacion(){
        operar("*");
    }
    
    @FXML
    private void clicDivision(){
        operar("/");
    }
    
    @FXML
    private void clicPorcentaje(){
        operar("%");
    }
    
    @FXML 
    private void clicReciproco(){
        contadorOperadores++;
        resultado = 1;
        operadorAnterior="1/x";
        operar("1/x");
        lblPantalla.setText(String.valueOf(resultado));
    }
    
    @FXML 
    private void clicRaizCuadrada(){
       contadorOperadores++;
       resultado = 1;
       operadorAnterior = "√";
       operar("");
       ingresoNuevo = false;
       lblPantalla.setText(String.valueOf(resultado));
    }
    
    @FXML
    private void clicCambiarSigno(){
        contadorOperadores++;
        resultado = 1;
        operadorAnterior = "+/-";
        operar("");
        ingresoNuevo= false;
        lblPantalla.setText(String.valueOf(resultado));
    }
    

    private void operar(String operador){            
            Operacion calc = null;
            
            System.out.println("\ncalcular()");
            System.out.println("Operador actual: " + operador);
            System.out.println("lblPantalla.getText()" + lblPantalla.getText());
            
            if(!(lblPantalla.getText().equals(""))){
                
            System.out.println("Dentro del primer if");            
            String strPantalla = lblPantalla.getText();            
            System.out.println("Nuevo valor: "+ingresoNuevo); 
 
            if(ingresoNuevo == false){ 
               System.out.println("Dentro del segundo if");
                
               this.numero = Float.parseFloat(strPantalla); 
               System.out.println("numero: "+numero); 
               contadorOperadores++; 
               System.out.println("contadorOperadores: "+contadorOperadores); 
                
            if (contadorOperadores == 1){ 
                this.resultado=numero; 
            }else if(contadorOperadores >= 2){
                System.out.println("IF del Swtich");
                
                switch (operadorAnterior){
                case "+":
                    calc = new Suma();
                    
                    resultado = calc.operar(resultado, numero);
                              
                    /*Suma suma = new Suma();
                    suma.setNumero1(resultado);
                    suma.setNumero2(numero);
                    resultado = suma.operar();
                    System.out.println("Resultado: " + resultado); */
                    break;
                case "-":
                    
                    calc = new Resta();
                    resultado = calc.operar(resultado, numero);
                    
                    
                    /*Resta resta = new Resta();
                    resta.setNumero1(resultado);
                    resta.setNumero2(numero);
                    resultado = resta.operar();
                    System.out.println("Resultado: " + resultado);*/
                    break;
                case "*":                   
                    calc = new Multiplicacion();
                    resultado = calc.operar(resultado, numero);
                    break;
                case "/":
                    calc = new Division();
                    resultado = calc.operar(resultado, numero);                   
                    break;     
                case "%":
                    calc  = new Porcentaje(); 
                    resultado = calc.operar(resultado, numero);
                    break;
                case "1/x":
                    calc = new Reciproco();
                    resultado = calc.operar(1, numero);
                    break;
                case "√":
                    calc = new RaizCuadrada();
                    // resultado = calc.operar(1, numero);
                    resultado = calc.operar(numero, 0.5f);
                    break;
                case "+/-":
                    calc = new CambiarSigno();
                    resultado = calc.operar(numero,-1);
                    break;
                case "x":
                    calc = new ElevarCuadrado();
                    resultado = calc.operar(numero, 2);
                }
                System.out.println("Resultado: " + this.resultado);
                lblPantalla.setText(String.valueOf(this.resultado));
            }       
        }
        
        lblPantalla.setText("");
        operadorAnterior = operador;
    } 
    }
    
            
    
    private void limpiar(){
        lblPantalla.setText("");
        resultado = 0;
        numero = 0;
        contadorOperadores = 0;
        operadorAnterior = "";
    }
    
    @FXML
    private void clicLimpiar(){
        limpiar();
    }
}


