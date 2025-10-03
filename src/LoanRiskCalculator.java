class LoanRiskCalculator {
    public boolean isEligible(Client client){//Checking for some factors about the client to determine if they are eligible for a loan.
        double risk = assesRisk(client); 
        if(client.getAge()<18){
         System.out.println("Client is not eligible due to being underage.");
            return false;
        }
        if(client.getCreditscore()<600){
         System.out.println("Client is not eligible due to low credit score.");
            return false;
        }
        if(client.getLoanAmount()>client.getIncome()*5){
         System.out.println("Client is not eligible due to high loan amount relative to income.");
            return false;
        }
        if(risk>40.0){
         System.out.println("Client is not eligible due to high risk factor.");
            return false;
        }
        else if (risk > 20.0 && risk<=40.0){
         System.out.println("Client is eligible but with a high risk factor.");
            return true;
        }
        else if (risk>10.0 && risk<=20.0){
         System.out.println("Client is eligible but with a moderate risk factor.");
            return true;
        }
        else if (risk<=10.0){
        System.out.println("Client is eligible for the loan.");
        return true;
        }
        return false;
    }

    public double assesRisk (Client client){
        double risk = 0.0; // Base risk score
        if(client.getCreditscore()<700){
            risk += 20.0; // Increase risk for lower credit scores
        }
        if(client.getCreditscore()>700 && client.getCreditscore()<=750){
            risk += 10.0; // Moderate risk for fair credit scores
        }
        if(client.getCreditscore() > 750){
        risk -= 10.0; // Decrease risk for excellent credit scores
        }
        if(client.getIncome()<30000){
            risk += 15.0; // Increase risk for lower income
        }
        if(client.getIncome()>=30000 && client.getIncome()<=60000){
            risk += 5.0; // Moderate risk for moderate income
        }
        if(client.getIncome()>60000 && client.getIncome()<=100000){
            risk -= 5.0; // Decrease risk for good income
        }
        if(client.getLoanAmount()>client.getIncome()*3){
            risk += 25.0; // Increase risk for high loan amounts relative to income
        }
        if(client.getLoanAmount()<=client.getIncome()*3 && client.getLoanAmount()>client.getIncome()){
            risk += 10.0; // Moderate risk for moderate loan amounts relative to income
        }
        if(client.getLoanAmount()<=client.getIncome()){
            risk -= 10.0; // Decrease risk for low loan amounts relative to income
        }
        if(client.getAge()<25){
            risk += 10.0; // Increase risk for younger clients
        }
        if(client.getAge()>60){
            risk += 10.0; // Increase risk for older clients
        }
        if(client.getIncome() > 100000){
        risk -= 10.0; // Decrease risk for high income
        }
        return risk;
}

public void printClientReport(Client client){
    System.out.println("Client Report:");
    System.out.println("Name: " + client.getName());
    System.out.println("Age: " + client.getAge());
    System.out.println("Income: $" + client.getIncome());
    System.out.println("Credit Score: " + client.getCreditscore());
    System.out.println("Desired Loan Amount: $" + client.getLoanAmount());
    double risk = assesRisk(client);
    System.out.println("Assessed Risk Factor: " + risk);
    isEligible(client);
}

}