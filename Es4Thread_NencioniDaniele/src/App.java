public class App {
    public static void main(String[] args) throws Exception {
        Memoria USB = new Memoria(16384, "USB");
        Utente t1 = new Utente("Nencioni", USB);
        Utente t2 = new Utente("Funzu", USB);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
