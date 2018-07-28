package classes;

public class TransType {
    private int count_trans;
    private int sum_trans;

    public TransType(int count_trans, int sum_trans){
        this.count_trans = count_trans;
        this.sum_trans = sum_trans;
    }

    public int getCount_trans() {
        return count_trans;
    }

    public void setCount_trans(int count_trans) {
        this.count_trans = count_trans;
    }

    public int getSum_trans() {
        return sum_trans;
    }

    public void setSum_trans(int sum_trans) {
        this.sum_trans = sum_trans;
    }
}
