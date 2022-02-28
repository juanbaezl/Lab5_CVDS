package edu.eci.cvds.calculator;

import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "calculadoraBean")
@SessionScoped
public class CalculadoraBean {
    private String lista;
    private ArrayList<String> ingresados = new ArrayList<>();
    private ArrayList<Double> arreglo;
    private double media;
    private double moda;
    private double desviacionEstandar;
    private double varianza;

    public CalculadoraBean(){
        
    }

    public String getLista() {
        return lista;
    }

    public ArrayList<String> getIngresados() {
        return ingresados;
    }

    public double getMedia() {
        return media;
    }
    public double getDesviacionEstandar() {
        return desviacionEstandar;
    }
    public double getModa() {
        return moda;
    }
    public double getVarianza() {
        return varianza;
    }

    public ArrayList<Double> getArreglo() {
        return arreglo;
    }

    public void setIngresados(ArrayList<String> ingresados) {
        this.ingresados = ingresados;
    }

    public void setDesviacionEstandar(double desviacionEstandar) {
        this.desviacionEstandar = desviacionEstandar;
    }
    public void setLista(String lista){
        this.lista = lista;
    }
    public void setMedia(double media) {
        this.media = media;
    }
    public void setModa(double moda) {
        this.moda = moda;
    }
    public void setVarianza(double varianza) {
        this.varianza = varianza;
    }
    public void setArreglo(String lista) {
        ArrayList<Double>arreglo = new ArrayList<>();
        String[]spli=lista.split(";");
        for(String x : spli){
            arreglo.add(Double.valueOf(x));
        }
        this.arreglo = arreglo;
    }

    public double calculateMean(ArrayList<Double> lista){
        double res = 0;
        for(double x : lista){
            res += x;
        }
        return (res/lista.size());
    }

    public double calculateStandardDeviation(ArrayList<Double> lista){
        return Math.sqrt(calculateVariance(lista));
    }

   public double calculateVariance(ArrayList<Double> lista){
    double mean = calculateMean(lista);
    double res = 0;
    for(double x : lista){
        res += Math.pow(x-mean,2);
    }
    return(res/lista.size());
   } 

   public double calculateMode(ArrayList<Double>lista){
        int max= 0;
        double moda= 0;
        for(double i : lista){
            int repe= 0;
            for(double j : lista){
                if(i==j){
                    repe++;
                }
                if(repe>max){
                    moda= i;
                    max=repe;
                }
            }
        }
        return moda;
    }

    public void calculateXXX(){
        setArreglo((lista=="")?"0":lista);
        ingresados.add(lista);
        moda = calculateMode(arreglo);
        media = calculateMean(arreglo);
        varianza = calculateVariance(arreglo);
        desviacionEstandar = calculateStandardDeviation(arreglo);
    }

    public void restart(){
        lista = "";
        moda = 0;
        media = 0;
        varianza = 0;
        desviacionEstandar = 0;
    }

}
