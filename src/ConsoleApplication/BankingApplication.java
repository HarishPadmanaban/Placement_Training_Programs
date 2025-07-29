package ConsoleApplication;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

class InsufficientAmountException extends Exception{

    InsufficientAmountException (String str)
    {
        super(str);
    }
}


class Customer
{
    private long customerId;
    private long accNo;
    private String name;
    private double balance;
    private String password;

    //List<Customer> customerList = new ArrayList<>();

    public Customer(long customerId, long accNo, String name, double balance, String password) {
        this.customerId = customerId;
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
        this.password = password;
    }
    public Customer(long customerId, long accNo,String name, String password) {
        this.customerId = customerId;
        this.accNo = accNo;
        this.name = name;
        this.balance = 1000;
        this.password = password;
    }
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public void setAccNo(long accNo) {
        this.accNo = accNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getCustomerId() {
        return customerId;
    }

    public long getAccNo() {
        return accNo;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return customerId+" "+accNo+" "+name+" "+balance+" "+password;
    }
}
public class BankingApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Customer> customerList = new ArrayList<>();
        HashMap<Long,Integer> mapToIndex = new HashMap<>();
        HashMap<Long,Integer> findByAccountNumber = new HashMap<>();
   //     mapToIndex.
//        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\karth\\Desktop\\New folder\\customer_db.txt",true));
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\karth\\Desktop\\New folder\\customer_db.txt"));
            //Scanner sc = new Scanner(System.in);
            String line;
            while((line = br.readLine())!=null)
            {
                String[] arr = line.split(" ");
                Customer obj = new Customer(
                        Integer.parseInt(arr[0]),
                        Long.parseLong(arr[1]),
                        arr[2],
                        Double.parseDouble(arr[3]),
                        arr[4]
                );
                customerList.add(obj);
                mapToIndex.put(obj.getCustomerId(),customerList.size()-1);
                findByAccountNumber.put(obj.getAccNo(),customerList.size()-1);
            }
            //System.out.println(customerList.get(0).getName());
        }catch (Exception e)
        {
            System.out.println("File not available");
        }
        //BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\karth\\Desktop\\New folder\\customer_db.txt",true));
        int ch;
        do{
            System.out.println("----------------Banking System----------------");
            System.out.println("1.Add Customer\n2.Transaction\n3.Quit");
            ch = sc.nextInt();
            sc.nextLine();
            switch(ch)
            {
                case 1:
                    addCustomer(sc,customerList,mapToIndex,findByAccountNumber);
                    break;
                case 2:
                    transcation(sc,customerList,mapToIndex,findByAccountNumber);
                    break;
                case 3:
                    break;
                default:
                    //System.out.println("Case not matched");
                    break;
            }

        }while(ch<2 && ch>=1);
        //System.out.println(customerList.get(customerList.size()-1).getPassword());
    }

    private static void addCustomer(Scanner sc , ArrayList<Customer> customerList,HashMap<Long,Integer> mapToIndex,HashMap<Long,Integer> findByAccountNumber)
    {
        System.out.println("------------------Add Customer Section------------------");
        System.out.println("Enter Customer Name:");
        String name = sc.nextLine();
        String password1;
        String password2;
        do{
            System.out.println("Enter Password:");
            password1 = sc.nextLine();
            System.out.println("Re-enter Password:");
            password2 = sc.nextLine();
        }while(!(password1.equals(password2)));
        long id = customerList.get(customerList.size()-1).getCustomerId()+11;
        long ano = Long.parseLong(id+"0"+id);
        Customer obj = new Customer(id,ano,name,encryption(password1));
        customerList.add(obj);
        mapToIndex.put(obj.getCustomerId(),customerList.size()-1);
        findByAccountNumber.put(obj.getAccNo(),customerList.size()-1);
        //System.out.println(obj.toString());
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\karth\\Desktop\\New folder\\customer_db.txt",true));
            bw.newLine();
            bw.write(obj.toString());
            bw.close();
            System.out.println("Stored on the external storage");
        }catch(Exception e)
        {
            System.out.println("File not available");
        }
    }

    private static void transcation(Scanner sc, ArrayList<Customer> customerList,HashMap<Long,Integer> mapToIndex,HashMap<Long,Integer> findByAccountNumber)
    {
        int i;
        long cusId;
        String password;
        do{
            System.out.println("1.ATM withdraw\n2.Cash deposit\n3.Account Transfer");
            i = sc.nextInt();
            sc.nextLine();
            boolean isAuth = false;
            System.out.println("Authentication Required:");
            do
            {
                System.out.println("Enter Customer Id: ");
                cusId = sc.nextLong();
                sc.nextLine();
                System.out.println("Enter Password ");
                password = sc.nextLine();
                isAuth = authentication(cusId,password,mapToIndex,customerList);
            }while(!isAuth);
            switch(i)
            {
                case 1:
                    try{
                        withdraw(cusId,sc,customerList,mapToIndex);
                    }catch (InsufficientAmountException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    cashDeposit(cusId,sc,customerList,mapToIndex);
                    break;
                case 3:
                    try{
                        accountTransfer(cusId,sc,customerList,mapToIndex,findByAccountNumber);
                    }catch (InsufficientAmountException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    i=4;
                    break;
            }
        }while(i!=4);
    }
    private static void withdraw(long cusId,Scanner sc,ArrayList<Customer> customerList,HashMap<Long,Integer> mapToIndex) throws InsufficientAmountException
    {
        System.out.println("Enter the amount: ");
        double amount = sc.nextDouble();
        Customer obj = customerList.get(mapToIndex.get(cusId));
        if(obj.getBalance()-amount < 1000)
        {
            throw new InsufficientAmountException("Amount Insufficient");
        }
        else{
            obj.setBalance(obj.getBalance()-amount);
            System.out.println("Amount Debited:"+amount);
            System.out.println("Updated Balance: "+obj.getBalance());
        }
    }
    private static void cashDeposit(long cusId,Scanner sc,ArrayList<Customer> customerList,HashMap<Long,Integer> mapToIndex)
    {
        System.out.println("Enter the amount: ");
        double amount = sc.nextDouble();
        Customer obj = customerList.get(mapToIndex.get(cusId));
        obj.setBalance(obj.getBalance()+amount);
    }
    private static void accountTransfer(long cusId,Scanner sc,ArrayList<Customer> customerList,HashMap<Long,Integer> mapToIndex,HashMap<Long,Integer> findByAccountNumber) throws InsufficientAmountException
    {
        System.out.println("Enter the receiver's Account number:");
        long receiver = sc.nextLong();
        System.out.println("Enter the amount to send : ");
        double amount = sc.nextDouble();
        try{
            Customer sendobj = customerList.get(mapToIndex.get(cusId));
            Customer recobj = customerList.get(findByAccountNumber.get(receiver));
            if(sendobj.getBalance()-amount < 1000)
            {
                throw new InsufficientAmountException("Amount Insufficient");
            }
            else{
                sendobj.setBalance(sendobj.getBalance()-amount);
                recobj.setBalance(recobj.getBalance()+amount);
                System.out.println("Transaction Done");
                System.out.println(sendobj.getBalance()+" "+recobj.getBalance());
            }
        }catch(Exception e)
        {
            System.out.println("Account Number invalid");
        }
    }
    private static String encryption(String s)
    {
        StringBuilder str = new StringBuilder();
        for(char c : s.toCharArray())
        {
            if(c=='9')
            {
                str.append('0');
                continue;
            }
            if(c=='z')
            {
                str.append('a');
                continue;
            }
            if(c=='Z')
            {
                str.append('A');
                continue;
            }
            int val = c;
            val++;
            str.append((char)val);
        }
        return str.toString();
    }

    private static String decryption(String s)
    {
        StringBuilder str = new StringBuilder();
        for(char c : s.toCharArray())
        {
            if(c=='0')
            {
                str.append('9');
                continue;
            }
            if(c=='a')
            {
                str.append('z');
                continue;
            }
            if(c=='A')
            {
                str.append('Z');
                continue;
            }
            int val = c;
            val--;
            str.append((char)val);
        }
        return str.toString();
    }

    private static boolean authentication(long cusId,String pass ,HashMap<Long,Integer> mapToIndex,ArrayList<Customer> customerList)
    {
        boolean isAuth = false;
        while(!isAuth)
        {
            if(mapToIndex.containsKey(cusId))
            {
                String deccryptedPassword = decryption(customerList.get((mapToIndex.get(cusId))).getPassword());
                if(pass.equals(deccryptedPassword))
                {
                    isAuth = true;
                }
                else{
                    System.out.println("Please Enter valid Credentials");
                    return false;
                }
            }
            else{
                System.out.println("Please Enter valid Credentials");
                return false;
            }
        }
        return isAuth;
    }
}
