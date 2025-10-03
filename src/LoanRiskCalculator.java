import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
class LoanRiskCalculator {
    public boolean isEligible(Client client){//Checking for some factors about the client to determine if they are eligible for a loan.
        double risk = assesRisk(client);

    if (client.getAge() < 18) return false;
    if (client.getCreditscore() < 600) return false;
    if (client.getLoanAmount() > client.getIncome() * 5) return false;
    if (risk > 40.0) return false;

    // Eligible otherwise (risk <= 40)
    return true;
    }

    public String EligibilityMessage (Client client){
        double risk = assesRisk(client);
        if(client.getAge()<18){
        return "Client is not eligible due to being underage.";
    }
    if(client.getCreditscore()<600){
        return "Client is not eligible due to low credit score.";
    }
    if(client.getLoanAmount()>client.getIncome()*5){
        return "Client is not eligible due to high loan amount relative to income.";
    }
    if(risk>40.0){
        return "Client is not eligible due to high risk factor.";
    }
    else if (risk>20.0){
        return "Client is eligible but with a high risk factor.";
    }
    else if (risk>10.0){
        return "Client is eligible but with a moderate risk factor.";
    }
    else {
        return "Client is eligible for the loan.";
    }
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

public String printClientReport(Client client){
    StringBuilder sb = new StringBuilder();
    sb.append("Client Report:\n");
    sb.append("Name: ").append(client.getName()).append("\n");
    sb.append("Age: ").append(client.getAge()).append("\n");
    sb.append("Income: $").append(client.getIncome()).append("\n");
    sb.append("Credit Score: ").append(client.getCreditscore()).append("\n");
    sb.append("Desired Loan Amount: $").append(client.getLoanAmount()).append("\n");
    double risk = assesRisk(client);
    sb.append("Assessed Risk Factor: ").append(risk).append("\n");
    sb.append(EligibilityMessage(client)).append("\n");
    return sb.toString();
}
public void saveClientInfo(Client client){
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Data/clients.csv",true));
        writer.write(printClientReport(client));
        writer.close();

    }
    catch (IOException e){
        e.printStackTrace();
    }
        }

}