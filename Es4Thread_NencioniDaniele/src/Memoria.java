import java.lang.*;
public class Memoria {
    private double capienza;
    private String nome;
    private double capLibera;

    public Memoria(double capienza, String nome) {
        this.capienza = capienza;
        this.nome = nome;
        this.capLibera = capienza;
    }

    public double getCapienza() {
        return this.capienza;
    }

    public void setCapienza(double capienza) {
        this.capienza = capienza;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCapLibera() {
        return this.capLibera;
    }

    public void setCapLibera(double capLibera) {
        this.capLibera = capLibera;
    }

    public synchronized void save(double spazio){
        //if(getCapLibera() > spazio){
            while(this.capLibera < spazio){
                System.out.println(Thread.currentThread().getName() + " Aspetta");
                try{
                    wait();
                }catch(InterruptedException e){}
            }
            this.capLibera -= spazio;
            System.out.print(Thread.currentThread().getName() + ": ");
            System.out.print("Salvataggio di " + spazio + " dati. ");
            System.out.println("Memoria disponibile: " + capLibera + "Mb");
        //}
    }

    public synchronized void delete(int spazio) {
        //if(getCapLibera() + spazio <= getCapienza()){
            this.capLibera += spazio;
            System.out.print(Thread.currentThread().getName() + ": ");
            System.out.print("Salvataggio di " + spazio + " dati. ");
            System.out.println("Memoria disponibile: " + capLibera + "Mb");
            notify();
        //}
    }

    public synchronized void formattazione(){
        this.capLibera = capienza;
    }

    @Override
    public String toString() {
        return "{" +
            " capienza='" + getCapienza() + "'" +
            ", nome='" + getNome() + "'" +
            ", capLibera='" + getCapLibera() + "'" +
            "}";
    }

}
