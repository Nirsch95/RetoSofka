/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VO;

/**
 *
 * @author felix
 */
public class NaveVO {
    
    /*Todo los atributos*/
    int idnave;
    String nombre;
    double altura;
    double peso;
    String tipo;
    double fini;
    String ffin;
    private byte[] foto;
    
public NaveVO(){}

/*Todo los codigos get*/
    public int getIdnave(){
        return idnave;
    }
    public String getNombre(){
        return nombre;
    }
    public double getAltura(){
        return altura;
    }
    public double getPeso(){
        return peso;
    }
    public String getTipo(){
        return tipo;
    }
    public double getFini(){
        return fini;
    }
    public String getFfin(){
        return ffin;
    }
    
/*Todo los codigos set*/
    public void setIdnave(int idnave){
        this.idnave = idnave;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }    
    public void setAltura(double altura){
        this.altura = altura;
    }
    public void setPeso(double peso){
        this.peso = peso;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setFini(double fini){
        this.fini = fini;
    }
    public void setFfin(String ffin){
        this.ffin = ffin;
    }  
    
        /**
     * @return the foto
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
}
