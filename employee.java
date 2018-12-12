/* TIPOS DE EMPREGADOS
1 - Hourly
2 - Salaried
3 - Commisioned

MÉTODOS DE PAGAMENTO
1 - Cheque pelos Correios
2 - Cheque em mãos
3 - Depósito em conta*/

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
    private float hSalary;
    private float monSalary;
    private float commission;
    private String payday;
    private int payMethod;
    private String paymentAgenda;
    private float totalSalary;

    public String getPayday() {
        return payday;
    }

    public void setPayday(String payday) {
        this.payday = payday;
    }

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

    public float gethSalary() {
        return hSalary;
    }

    public void sethSalary(float hSalary) {
        this.hSalary = hSalary;
    }

    public float getMonSalary() {
        return monSalary;
    }

    public void setMonSalary(float monSalary) {
        this.monSalary = monSalary;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public int getSyndiNumber() {
        return syndiNumber;
    }

    public void setSyndiNumber(int syndiNumber) {
        this.syndiNumber = syndiNumber;
    }

    public boolean isSyndicate(){
        if(syndicate){
            return true;
        }

        return false;
    }

    public int getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(int payMethod) {
        this.payMethod = payMethod;
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

    public void addTaxes(){

        Scanner keyboard = new Scanner(System.in);
        float value;

        System.out.printf("Digite o valor da taxa a ser adicionada: ");
        value = keyboard.nextFloat();

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

    public float calcCommission(float value){
        float valCommission;
        float percentage = this.commission;
        Scanner keyboard = new Scanner(System.in);

        percentage = percentage/100;

        valCommission = percentage*value;

        return valCommission;
    }

    public String getPaymentAgenda() {
        return paymentAgenda;
    }

    public void setPaymentAgenda() {
        String newPaymentAgenda;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Digite a nova agenda de pagamento: ");
        newPaymentAgenda = keyboard.nextLine();
        keyboard.nextLine();

        this.paymentAgenda = newPaymentAgenda;
    }

    public void paymentRoutine(){
        float whours = 0, bonus = 0;

        switch(this.type){
            case 1: //Horistas
                for(int i=0;i<timecards.size();i++){
                    whours += timecards.get(i).getHours();
                }

                if(whours>8){
                    bonus = hSalary*(whours - 8)*(15/10);
                }
                this.totalSalary = bonus + this.gethSalary();
                break;
            case 2: //Mensalistas
                this.totalSalary = monSalary;
                break;
            case 3: //Comissionados
                for(int i=0;i<sells.size();i++){
                    bonus += calcCommission(sells.get(i).getValue());
                }
                this.totalSalary = ((monSalary/30)*14) + bonus;
                break;
        }
    }

    public employee(int code, String name, String adress, String payday, int payMethod, float hSalary, float monSalary, float commission, int type, String paymentAgenda){
        this.code = code;
        this.name = name;
        this.adress = adress;
        this.payday = payday;
        this.payMethod = payMethod;
        this.hSalary = hSalary;
        this.monSalary = monSalary;
        this.commission = commission;
        this.type = type;
        this.paymentAgenda = paymentAgenda;
    }
}
