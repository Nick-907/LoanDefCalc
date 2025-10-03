import java.util.*;
class Main {
    public static void main (String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("How many clients do you want to evaluate?");
        int numClients = scanner.nextInt();
        ArrayList <Client> clients = new ArrayList<>();
        for(int i = 0; i < numClients ; i++){ // creates the clients based on user input.
            System.out.println("\nEnter details for client " + (i+1) + ":");

            System.out.print("Name: ");
            scanner.nextLine(); // consume leftover newline
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();

            System.out.print("Income: ");
            double income = scanner.nextDouble();

            System.out.print("Credit Score: ");
            int creditScore = scanner.nextInt();

            System.out.print("Desired Loan Amount: ");
            double loanAmount = scanner.nextDouble();

            Client client = new Client(name, age, income, creditScore, loanAmount);
            clients.add(client);
        }

        LoanRiskCalculator calculator = new LoanRiskCalculator();
        for( Client client : clients){ // prints the report for each client.
            calculator.printClientReport(client);
            System.out.println("--------------------------");
        }
    }
}
}