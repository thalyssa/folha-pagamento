import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.exit;

public class main {

    public static int countEmployees = 0;

    public static ArrayList<employee> EMPLOYEES = new ArrayList<>();

    public static void addEmployee(){
        employee newEmployee;
        String name, adress;
        int type;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("---CADASTRO DE FUNCIONÁRIO---\n");
        System.out.println("Nome: ");
        name = keyboard.nextLine();

        System.out.println("Endereço: ");
        adress = keyboard.nextLine();

        System.out.println("Tipo de salário:\n1 - Horista\n2 - Mensalista\n3 - Comissionado");
        type = keyboard.nextInt();

        if(type<1 || type>3){
            System.out.println("TIPO DE SALÁRIO INVÁLIDO. Por favor, tente novamente");
            exit(0);
        }

        newEmployee = new employee(countEmployees, name, adress, type);

        EMPLOYEES.add(newEmployee);

        countEmployees++;
    }

    public static void deleteEmployee(int code){
        for(int i=0;i<countEmployees;i++){
            if(EMPLOYEES.get(i).getCode().equals(code)){
                EMPLOYEES.remove(EMPLOYEES.get(i));
            }
        }

    }

    public static void update(int code){
        String name, adress;
        int type, option;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("---MUDANÇA DE REGISTRO---\n");
        System.out.println("Diga o que deseja alterar:\n1 - Nome\n2 - Endereço\n3 - Tipo de salário");

        option = keyboard.nextInt();

        switch (option){
            case 1:
                System.out.println("Digite o novo nome: ");
                name = keyboard.nextLine();
                EMPLOYEES.get(code).setName(name);
                break;
            case 2:
                System.out.println("Digite o novo endereço: ");
                adress = keyboard.nextLine();
                EMPLOYEES.get(code).setAdreess(adress);
                break;

            case 3:
                System.out.println("Digite o novo tipo de salário:\n1 - Horista\n2 - Mensalista\n3 - Comissionado");
                type = keyboard.nextInt();

                if(type<1 || type>3){
                    System.out.println("TIPO DE SALÁRIO INVÁLIDO. Por favor, tente novamente");
                    exit(0);
                }
                EMPLOYEES.get(code).setType(code);
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }//End switch


    }

    public static void main(String args[]){

    }
}
