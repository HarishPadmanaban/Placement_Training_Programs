package ConsoleApplication;

class Taxi{
    private int tno;
    private char currSpot;
    private int totalEarning;
    private int totalTavels;

    public Taxi(int tno) {
        this.tno = tno;
    }

    public int getTno() {
        return tno;
    }

    public char getCurrSpot() {
        return currSpot;
    }

    public int getTotalEarning() {
        return totalEarning;
    }

    public int getTotalTavels() {
        return totalTavels;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public void setCurrSpot(char currSpot) {
        this.currSpot = currSpot;
    }

    public void setTotalEarning(int totalEarning) {
        this.totalEarning = totalEarning;
    }

    public void setTotalTavels(int totalTavels) {
        this.totalTavels = totalTavels;
    }
}
public class TaxiBooking {
    public static void main(String[] args) {

    }
}
