package threads;

public class Counter {
    private  int c;
    public Counter(){
        this.c=0;
    }

    public int getc() {
        return c;
    }

    public void setc(int c) {
        this.c = c;
    }
    public void incr(){
        c++;
    }
    public void decr(){
        c--;
    }
}
