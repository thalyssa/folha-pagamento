/* TIPOS DE EMPREGADOS
1 - Hourly
2 - Salaried
3 - Commisioned */

import java.util.ArrayList;
import java.util.Scanner;

public class employee {
    private int code;
    private String name;
    private String adress;
    private int type;
    private ArrayList<card> timecards = new ArrayList<>();
    private ArrayList<sell> sells = new ArrayList<>();
    private float taxes;
    private boolean syndicate;
    private int syndiNumber;
    private float salary;

    public String getPayday() {
        return payday;
    }

    public void setPayday(String payday) {
        this.payday = payday;
    }

    private String payday;

    public int getCode(){
        return this.code;
    }

    public String getName(){
        return this.name;
    }

    public String getAdress(){
        return this.adress;
    }

    public int getType(){
        return this.type;
    }

    public boolean isSyndicate(){
        if(syndicate){
            return true;
        }

        return false;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setAdress(String newAdress){
        this.adress = newAdress;
    }

    public void setType(int newType){
        this.type = newType;
    }

    public void associate(){
        this.syndicate = true;
    }

    public void dissociate(){
        this.syndicate = false;
    }

    /*public card getTimecards(){
        for(int i=0;i<timecards.size();i++){
            card CARDS = this.timecards.get(i);
            return CARDS;
        }
    }*/

    public void addTimecard(){
        card newCard;
        String entry;
        String exit;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Digite o horário de entrada no formato HH:MM: ");
        entry = keyboard.nextLine();

        System.out.println("Digite o horário de entrada no formato HH:MM: ");
        exit = keyboard.nextLine();

        newCard = new card(entry, exit, this.code);

        float whours = newCard.getHours();

        System.out.println("Esse cartão registrou " + whours + " horas de trabalho");

        this.timecards.add(newCard);
    }

    public float getTaxes(){
        return this.taxes;
    }

    public void addTaxes(float value){
        this.taxes+=value;
    }

    public void addSell(){
        sell newSell;
        String date;
        float value;
        Scanner keyboard = new Scanner(System.in);

        System.out.printf("Digite a data da venda no formato DD/MM/AAAA: ");
        date = keyboard.nextLine();

        System.out.printf("Digite agora o valor da venda: ");
        value = keyboard.nextFloat();

        newSell = new sell(date, value, this.getCode());

        this.sells.add(newSell);
    }

    public employee(int code, String name, String adress, String payday, int type){
        this.code = code;
        this.name = name;
        this.adress = adress;
        this.payday = payday;
        this.type = type;
    }
}
