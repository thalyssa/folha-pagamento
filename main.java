import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.exit;

public class main {

    public static int countEmployees = 0;

    public static ArrayList<employee> EMPLOYEES = new ArrayList<>();

    public static void addEmployee(){
        employee newEmployee;
        String name, adress, payday;
        float hSalary, monSalary, commission;
        int type, payMethod;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("---CADASTRO DE FUNCIONÁRIO---\n");
        System.out.println("Nome: ");
        name = keyboard.nextLine();

        System.out.println("Endereço: ");
        adress = keyboard.nextLine();

        System.out.println("Tipo de salário:\n1 - Horista\n2 - Mensalista\n3 - Comissionado");
        type = keyboard.nextInt();

        switch (type){
            case 1:
                System.out.println("Salário por hora: ");
                hSalary = keyboard.nextFloat();
                monSalary = 0;
                commission = 0;
                break;
            case 2:
                System.out.println("Salário Mensal: ");
                monSalary = keyboard.nextFloat();
                hSalary = 0;
                commission = 0;
                break;
            case 3:
                System.out.println("Salário Mensal: ");
                monSalary = keyboard.nextFloat();

                System.out.println("Comissão: ");
                commission = keyboard.nextFloat();
                hSalary = 0;
                break;
            default:
                System.out.println("TIPO DE SALÁRIO INVÁLIDO. Por favor, tente novamente");
                break;
        }

        System.out.println("Dia de pagamento no formato DD: ");
        payday = keyboard.nextLine();

        System.out.println("Método de pagamento\n1 - Cheque pelos Correios\n2 - Cheque em mãos\n3 - Depósito em conta");
        payMethod = keyboard.nextInt();

        keyboard.nextLine();

        newEmployee = new employee(countEmployees, name, adress, payday, payMethod, hSalary, monSalary, commission, type);

        EMPLOYEES.add(newEmployee);

        countEmployees++;
    }

    public static void deleteEmployee(int code){
        if(countEmployees<=0){
            System.out.println("Sem empregados na base de dados!");
        }else {
            for (int i = 0; i < countEmployees; i++) {
                if (EMPLOYEES.get(i).getCode() == code) {
                    EMPLOYEES.remove(EMPLOYEES.get(i));
                }
            }//For
        }//Else
    }

    public static int getEmployeeID(String name){
        for(int i=0;i<countEmployees;i++){
            if(name.equals(EMPLOYEES.get(i).getName()) && EMPLOYEES.get(i).getCode()!=-1) {
                return EMPLOYEES.get(i).getCode();
            }
        }//Fim for
        return -1;
    }

    public static void payroll(){
        Scanner keyboard = new Scanner(System.in);
        String date;

        System.out.println("Digite o dia de pagamento no formato DD: ");
        date = keyboard.nextLine();

        for(int i=0;i<countEmployees;i++){
            if(EMPLOYEES.get(i).getPayday().equals(date)){
                //Rotina de pagamento aqui
            }
        }
    }

    public static void update(){

        System.out.println("---MUDANÇA DE REGISTRO---\n");

        Scanner keyboard = new Scanner(System.in);

        String name, parameter, adress;
        int type, option, code, payMethod;
        float commission, hSalary, monSalary;

        System.out.println("Digite o nome do empregado a ter o registro alterado: ");
        parameter = keyboard.nextLine();

        keyboard.nextLine();

        code = getEmployeeID(parameter);

        System.out.println("Diga o que deseja alterar: ");
        System.out.println("1 - Nome");
        System.out.println("2 - Endereço");
        System.out.println("3 - Tipo salarial");
        System.out.println("4 - Método de pagamento");
        System.out.println("5 - Afiliar-se ao sindicato");
        System.out.println("6 - Desafiliar-se do sindicato");
        System.out.println("7 - Mudar identificação sindical");
        System.out.println("8 - Adicionar taxa sindical");

        option = keyboard.nextInt();

        switch (option){
            case 1:
                System.out.println("Digite o novo nome: ");
                name = keyboard.nextLine();
                keyboard.nextLine();
                EMPLOYEES.get(code).setName(name);
                break;
            case 2:
                System.out.println("Digite o novo endereço: ");
                adress = keyboard.next();
                keyboard.nextLine();
                EMPLOYEES.get(code).setAdress(adress);
                break;
            case 3:
                System.out.println("Digite o novo tipo de salário:\n1 - Horista\n2 - Mensalista\n3 - Comissionado");
                type = keyboard.nextInt();
                keyboard.nextLine();

                EMPLOYEES.get(code).setType(type);

                switch(type){
                    case 1:
                        System.out.println("Salário por hora: ");
                        hSalary = keyboard.nextFloat();

                        EMPLOYEES.get(code).sethSalary(hSalary);
                        break;
                    case 2:
                        System.out.println("Salário Mensal: ");
                        monSalary = keyboard.nextFloat();

                        EMPLOYEES.get(code).setMonSalary(monSalary);
                        break;
                    case 3:
                        System.out.println("Salário Mensal: ");
                        monSalary = keyboard.nextFloat();

                        System.out.println("Comissão: ");
                        commission = keyboard.nextFloat();

                        EMPLOYEES.get(code).setMonSalary(monSalary);
                        EMPLOYEES.get(code).setCommission(commission);
                        break;
                    default:
                        System.out.println("TIPO DE SALÁRIO INVÁLIDO. Por favor, tente novamente");
                        break;
                }//Fim switch type

                break;
            case 4:
                System.out.println("Escolha o novo método de pagamento\n1 - Cheque pelos Correios\n2 - Cheque em mãos\n3 - Depósito em conta");
                payMethod = keyboard.nextInt();
                keyboard.nextLine();
                EMPLOYEES.get(code).setPayMethod(payMethod);
                break;
            case 5:
                EMPLOYEES.get(code).associate();
                break;
            case 6:
                EMPLOYEES.get(code).dissociate();
                break;
            case 7:
                if(EMPLOYEES.get(code).isSyndicate()){
                    int syndiNumber;
                    System.out.println("Digite a nova identificação sindical: ");
                    syndiNumber = keyboard.nextInt();

                    EMPLOYEES.get(code).setSyndiNumber(syndiNumber);
                }else{
                    System.out.println("O empregado não está associado ao sindicato");
                }
                break;
            case 8:
                if(EMPLOYEES.get(code).isSyndicate()){
                    EMPLOYEES.get(code).addTaxes();
                }else{
                    System.out.println("O empregado não está associado ao sindicato");
                }
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }//End switch
    }

    public static void searchEmployee() {
        String nome;
        Scanner keyboard = new Scanner(System.in);
        boolean flag = false;
        System.out.println("--PESQUISA DE FUNCIONÁRIO--");
        System.out.println("Digite o nome do funcionário: ");
        nome = keyboard.nextLine();

        int code = getEmployeeID(nome);

        for (int i = 0; i < countEmployees; i++) {
            if ((EMPLOYEES.get(i).getCode()) == code) {
                flag = true;
                System.out.println("Matrícula: " + EMPLOYEES.get(i).getCode());
                System.out.println("Nome: " + EMPLOYEES.get(i).getName());
                System.out.println("Endereço: " + EMPLOYEES.get(i).getAdress());
                System.out.println("Tipo de salário: " + EMPLOYEES.get(i).getType());
                System.out.println("\n");
            }//End if
        }//End for

        if(flag == false){
            System.out.println("--FUNCIONÁRIO NÃO ENCONTRADO--");
        }

    }//End searchEmployee

    public static void init(int flag){
        if(flag==1) {

            Scanner keyboard = new Scanner(System.in);
            int option;

            System.out.println("Bem vindo ao sistema de Folha de Pagamento\nO que deseja fazer?");
            System.out.println("1 - Adicionar um empregado");
            System.out.println("2 - Remover um empregado");
            System.out.println("3 - Adicionar um cartão de ponto");
            System.out.println("4 - Adicionar uma venda");
            System.out.println("5 - Adicionar taxa de serviço");
            System.out.println("6 - Alterar dados de um empregado");
            System.out.println("7 - Rodar folha de pagamento");
            System.out.println("8 - Desfazer/refazer última alteração");
            System.out.println("9 - Escolher Agenda de Pagamento");
            System.out.println("10 - Criar nova Agenda de Pagamento");

            option = keyboard.nextInt();

            switch(option){
                case 1: //Add um funcionário
                    addEmployee();

                    System.out.println("Deseja continuar?\n 1 - SIM || 2 - NÃO");
                    flag = keyboard.nextInt();
                    init(flag);
                    break;

                case 2: //Remover um funcionário
                    System.out.println("Digite o nome do funcionário: ");
                    String name = keyboard.next();
                    keyboard.nextLine();


                    int code = getEmployeeID(name);

                    deleteEmployee(code);

                    System.out.println("Deseja continuar?\n 1 - SIM || 2 - NÃO");
                    flag = keyboard.nextInt();
                    init(flag);
                    break;

                case 3: //Add cartão de ponto
                    System.out.println("Digite o nome do funcionário: ");
                    name = keyboard.nextLine();
                    keyboard.nextLine();

                    code = getEmployeeID(name);

                    EMPLOYEES.get(code).addTimecard();

                    System.out.println("Deseja continuar?\n 1 - SIM || 2 - NÃO");
                    flag = keyboard.nextInt();
                    init(flag);
                    break;
                case 4: //Add venda
                    System.out.println("Digite o nome do funcionário: ");
                    name = keyboard.nextLine();
                    keyboard.nextLine();

                    code = getEmployeeID(name);

                    EMPLOYEES.get(code).addSell();

                    System.out.println("Deseja continuar?\n 1 - SIM || 2 - NÃO");
                    flag = keyboard.nextInt();
                    init(flag);
                    break;
                case 5: //Add taxa de serviço
                    System.out.println("Digite o nome do funcionário: ");
                    String name = keyboard.next();
                    keyboard.nextLine();

                    int code = getEmployeeID(name);

                    EMPLOYEES.get(code).addTaxes();

                    System.out.println("Deseja continuar?\n 1 - SIM || 2 - NÃO");
                    flag = keyboard.nextInt();
                    init(flag);
                    break;
                case 6: //Alterar dados do funcionário
                    update();

                    System.out.println("Deseja continuar?\n 1 - SIM || 2 - NÃO");
                    flag = keyboard.nextInt();
                    init(flag);
                    break;

                case 7: //Rodar folha de pagamento
                    payroll();

                    System.out.println("Deseja continuar?\n 1 - SIM || 2 - NÃO");
                    flag = keyboard.nextInt();
                    init(flag);
                    break;

                case 8: //Undo/Redo

                    System.out.println("Deseja continuar?\n 1 - SIM || 2 - NÃO");
                    flag = keyboard.nextInt();
                    init(flag);
                    break;
                case 9: //Escolher agenda de pagamento

                    System.out.println("Deseja continuar?\n 1 - SIM || 2 - NÃO");
                    flag = keyboard.nextInt();
                    init(flag);
                    break;
                case 10: //Criar nova agenda de pagamento

                    System.out.println("Deseja continuar?\n 1 - SIM || 2 - NÃO");
                    flag = keyboard.nextInt();
                    init(flag);
                    break;
                default:
                    System.out.println("Opção inválida!");

                    System.out.println("Deseja continuar?\n 1 - SIM || 2 - NÃO");
                    flag = keyboard.nextInt();
                    init(flag);
                    break;

            }//Fim switch
        }//Fim if

    }

    public static void getEmployeeList(){
        System.out.println("--LISTA DE EMPREGADOS--");
        for(int i=0;i<EMPLOYEES.size();i++) {
            System.out.println(EMPLOYEES.get(i).getName());
        }//Fim do for
    }

    public static void main(String args[]){

        init(1);

        getEmployeeList();

    }
}
