import java.util.*;
class Client {
	// vars to collect needed information from the clients.
	private String name;
	private int age;
	private double income;
	private int creditscore;
	private double loanAmount;

	public Client() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please type in the client's name : ");
		this.name = scanner.nextLine();
        System.out.print("Please type in the client's age : ");
        this.age = scanner.nextInt();
        System.out.print("Please type in the client's income : ");
        this.income = scanner.nextDouble();
        System.out.print("Please type in the client's credit score : ");  
        this.creditscore = scanner.nextInt();
        System.out.print("Please type in the client's desired loan amount : ");
        this.loanAmount = scanner.nextDouble();
    }
    
    public Client(String name, int age, double income, int creditscore, double loanAmount) {
        this.name = name;
        this.age = age;
        this.income = income;
        this.creditscore = creditscore;
        this.loanAmount = loanAmount;
    }
    
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getIncome() {
        return income;
    }
    public int getCreditscore() {
        return creditscore;
    }
    public double getLoanAmount() {
        return loanAmount;
    }
    public  void setName(String name) {
        this.name = name;
    }
    public  void setAge(int age) {
        this.age = age;
    }
    public  void setIncome(double income) {
        this.income = income;
    }
    public  void setCreditscore(int creditscore) {
        this.creditscore = creditscore;
    }
    public  void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }


}
