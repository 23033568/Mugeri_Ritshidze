
package budget_plan_system;
import java.util.Scanner;
public class Budget_Plan_System {

        public static void main(String[] args) {
        Scanner Amount = new Scanner(System.in);
        System.out.print("ENTER YOUR GROSS MONTHLY INCOME(before deductions): ");
         double grossIncome = Amount.nextDouble();
         
        System.out.print("ENTER YOUR ESTIMATED TAX(PERCENTAGE): ");
        double taxDeducted = Amount.nextDouble();
        
        System.out.print("ENTER YOUR MONTHLY GROCERY EXPENSE: ");
        double groceries = Amount.nextDouble();
        
        System.out.print("Enter your estimated monthly expenses on water and lights: ");
        double water_And_Lights =Amount.nextDouble();
        
        System.out.print("Enter your estimated monthly travel costs (including petrol): ");
        double travel_Costs =Amount.nextDouble();
        
        System.out.print("Enter your estimated monthly expsenses on cell phone and telephone: ");
        double cellPhone = Amount.nextDouble();
        
        System.out.print("Enter your estimated other monthly expenses : ");
        double other =Amount.nextDouble();
        
        // Calculating the total expenditure
        double total_Expenditures = groceries + water_And_Lights + travel_Costs + cellPhone +other ;

         /*choices of Accommodation. we decided to choose String Buffers to cover 
        every requirement of java OOP FOR A FUNTIONAL code */
        System.out.print("Is your choice to rent accommodation or buy a property? (rent/buy): ");
        String accommodationChoice = Amount.next();

        double accommodationCost ;
        int repaymentMonths;

        if (accommodationChoice.equals("rent")) {
            System.out.print("Enter your monthly rental amount: ");
            accommodationCost = Amount.nextDouble();
        } else if (accommodationChoice.equals("buy")) {
            System.out.print("Enter the purchase price of the property: ");
            double purchasePrice = Amount.nextDouble();

            System.out.print("Enter the total deposit: ");
            double deposit = Amount.nextDouble();

            System.out.print("Enter the interest rate (percentage): ");
            double interestRate = Amount.nextDouble();
                
            System.out.print("Enter the number of months to repay (between 240 and 360): ");
            repaymentMonths = Amount.nextInt();
            
            
            // Validate the number of months
            if (repaymentMonths < 240 || repaymentMonths > 360) {
                System.out.println("INVALID CHOICE.");
                return;
            }
            //CALCULATIONS FOR TAX
           
            
            // Calculating monthly home loan repayment
            double loanAmount = purchasePrice - deposit;
            double monthlyInterestRate = interestRate / 100 / 12;
            double monthlyRepayment = (loanAmount * monthlyInterestRate) / 
                (1 - Math.pow(1 + monthlyInterestRate, -repaymentMonths));

           accommodationCost = monthlyRepayment;
            
        } 
        else { 
            System.out.println("valid choice. .");
            return;
        }
            double tax;
            tax=grossIncome*15/100;
         taxDeducted=grossIncome-tax; 
        // Calculating the net monthly income
        double netMonthlyIncome = grossIncome - tax - total_Expenditures - accommodationCost;

        // Below lies the results  that must be desplayed to the user
        
        System.out.println("Gross Monthly Income: " + grossIncome);
        System.out.println("Estimated Monthly Tax Deducted: " + tax);
        System.out.println("Total Monthly Expenditures: " + total_Expenditures);
        System.out.println("Accommodation Cost: " + accommodationCost);
        System.out.println("Net Monthly Income: " + netMonthlyIncome);
       
        // Below lies the code for part two that asks further about getting a car
        Amount.nextLine();
        System.out.println("Would you like to buy a car? yes or no");
        String responce= Amount.nextLine();
         double totalMonthlyCost = 0;
        if(responce.equalsIgnoreCase("yes")){
            System.out.print("Enter your gross monthly income (before deductions): ");
         double model = Amount.nextDouble();
         
        System.out.print("Enter your purchase price: ");
        double purchasePrice = Amount.nextDouble();
        
        System.out.print("Enter your Total deposit: ");
        double Totaldeposit = Amount.nextDouble();
        
        System.out.print("Enter your estimated monthly interestrate: ");
        double interrestrate=Amount.nextDouble();
        
        System.out.print("Enter your estimated insurance price: ");
        double EInsurance=Amount.nextDouble();
        
         totalMonthlyCost =  calculateVehicleLoan(purchasePrice,Totaldeposit,interrestrate)+EInsurance;

        }
        else{
            System.out.println("you selected the option of not buying a car");
    }    
         
        double Arr []={ netMonthlyIncome, totalMonthlyCost};
        double totalExpenses = calculateExpenses(Arr);
        double remainingIncome = netMonthlyIncome - totalExpenses;

        // Step 5: Validate Expenses
        if (totalExpenses > 0.75 * netMonthlyIncome) {
            System.out.println("Warning: Your expenses exceed 75% of your income.");
        }

        /* Below lies the Output  results that are going to be deplayed to the user to 
        give the user a summary of the totals from the Gross income*/
        System.out.println("Your net monthly income after tax:"+netMonthlyIncome );
        System.out.println("Your total monthly expenses:"+ totalExpenses);
        System.out.println("Remaining monthly income:"+ remainingIncome);
        
    if(remainingIncome<0){
        System.out.println("You are now running an overdraft");}   
    else if(remainingIncome>0){
        System.out.println("You can now consider buying a car");} 
    
    }
        //the following are our methods to calculate the vehicle expenses and also the net expenses 
        
    public static double calculateVehicleLoan(double purchasePrice, double Totaldeposit, double interestrate) {
        double loanAmount = purchasePrice - Totaldeposit;
        double monthlyInterestRate = interestrate / 100 / 12;
        int loanTermMonths = 5 * 12; // 5 years

        double monthlyLoanRepayment = (loanAmount * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -loanTermMonths));

        return monthlyLoanRepayment;

    }
     public static double calculateExpenses( double Arr[]) {
        double total = 0;
        for (double expense : Arr) {
            total += expense;
        }
        return total;
    }
    
}
