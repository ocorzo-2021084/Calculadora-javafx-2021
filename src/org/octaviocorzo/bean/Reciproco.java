
package org.octaviocorzo.bean;

/**
 *
 * @author Octavio Corzo
 * @date 21/03/2022
 * carné: 2021084
 * IN5BM
 * Grupo: 2 (Lunes)
 */
public class Reciproco extends Operacion {
    
    @Override
    public float operar(){
        setResultado(getNumero1()/ getNumero2());
        return getResultado();
    }
    
    @Override 
    public float operar(float uno, float x){
        this.setNumero1(uno);
        this.setNumero2(x);
        this.setResultado(getNumero1()/ getNumero2());
        return this.getResultado();
    }
}
