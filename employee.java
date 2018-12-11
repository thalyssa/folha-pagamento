/* TIPOS DE EMPREGADOS
1 - Hourly
2 - Salaried
3 - Commisioned */

import java.util.ArrayList;

public class employee {
    private int code;
    private String name;
    private String adress;
    private int type;
    private ArrayList<card> timecards = new ArrayList<>();
    //ADD VENDAS
    private float taxes;
    private boolean syndicate;
    private int syndiNumber;

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

    public card getTimecards(){
        for(int i=0;i<timecards.size();i++){
            return timecards.get(i);
        }
    }

    public void addTimecard(card newCard){
        this.timecards.add(newCard);
    }

    public float getTaxes(){
        return this.taxes;
    }

    public void addTaxes(float value){
        this.taxes+=value;
    }

    public employee(int code, String name, String adress, int type){
        this.code = code;
        this.name = name;
        this.adress = adress;
        this.type = type;
    }
}
