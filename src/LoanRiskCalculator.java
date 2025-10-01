class LoanRiskCalculator extends Client {
    public boolean isEligible(Client client){ //Checking for some factors about the client to determine if they are eligible for a loan.
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
        System.out.println("Client is eligible for the loan.");
        return true;
    }
    public double assesRisk (Client client){
        double risk = 0.0; // Base risk score
        if(client.getCreditscore()<700){
            risk += 20.0; // Increase risk for lower credit scores
        }
        if(client.getIncome()<30000){
            risk += 15.0; // Increase risk for lower income
        }
        if(client.getLoanAmount()>client.getIncome()*3){
            risk += 25.0; // Increase risk for high loan amounts relative to income
        }
        return risk;
    }
    
}