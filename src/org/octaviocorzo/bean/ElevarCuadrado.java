
package org.octaviocorzo.bean;

/**
 *
 * @author Octavio Corzo
 * @date 21/03/2022
 * carné: 2021084
 * IN5BM
 * Grupo: 2 (Lunes)
 */
public class ElevarCuadrado extends Operacion {
            
    
    @Override
    public float operar(float numero1, float numero2){
        setNumero1(numero1);
        setNumero2(numero2);
        setOperador('x');
        setResultado((float) Math.pow(numero1, numero2));
        return getResultado();    
    }
    
    @Override
    public float operar(){
        setOperador('x');
        setResultado((float) Math.sqrt(getNumero2()));
        return getResultado();       
    }

}
