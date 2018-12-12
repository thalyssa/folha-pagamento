import java.util.Scanner;

public class sell {
    private String date;
    private float value;
    private float commission;
    private int seller; //Código do empregado

    public float getCommission(){
        return commission;
    }

    public void setCommission(float commission){
        this.commission = commission;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public float getValue(){
        return value;
    }

    public void setValue(float value){
        this.value = value;
    }

    public int getSeller(){
        return seller;
    }

    public void setSeller(int seller){
        this.seller = seller;
    }

    public float calcCommission(float value){
        float commission;
        float percentage;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Digite a porcentagem da comissão: ");
        percentage = keyboard.nextFloat();

        percentage = percentage/100;

        commission = percentage*value;

        return commission;
    }

    public sell(String date, float value, int seller){
        this.date = date;
        this.value = value;
        this.commission = calcCommission(value);
        this.seller = seller;
    }

}
