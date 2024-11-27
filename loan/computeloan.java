<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Loan Payment Results</title>
</head>
<body>
    <h1>Loan Payment Results</h1>
    
    <%
        // Get form parameters
        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
        double annualInterestRate = Double.parseDouble(request.getParameter("interestRate"));
        int years = Integer.parseInt(request.getParameter("years"));
        
        // Calculate monthly interest rate and number of payments
        double monthlyInterestRate = (annualInterestRate / 100) / 12;
        int numberOfPayments = years * 12;
        
        // Calculate monthly payment using the formula
        double monthlyPayment = (loanAmount * monthlyInterestRate) / 
            (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
        
        // Calculate total payment
        double totalPayment = monthlyPayment * numberOfPayments;
        
        // Format the results
        DecimalFormat df = new DecimalFormat("#.##");
    %>
    
    <p>Loan Amount: <%= df.format(loanAmount) %></p>
    <p>Annual Interest Rate: <%= df.format(annualInterestRate) %>%</p>
    <p>Term: <%= years %> years</p>
    <p>Monthly Payment: $<%= df.format(monthlyPayment) %></p>
    <p>Total Payments: $<%= df.format(totalPayment) %></p>
    
    <a href="loan.html">Go back</a>
</body>
</html>
