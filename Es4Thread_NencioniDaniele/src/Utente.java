public class Utente extends Thread {
    private String nome;
    private Memoria memo;

    public Utente(String nome, Memoria memo) {
        this.nome = nome;
        this.memo = memo;
        this.setName(nome);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            int n = (int)(Math.random()*600);
            memo.save(n);
            int m = (int)(Math.random()*600);
            memo.delete(m);
        }
    }
}
