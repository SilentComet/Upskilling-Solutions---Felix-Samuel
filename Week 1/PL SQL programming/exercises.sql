-- Mandatory PL/SQL Exercises

-- 1. Control Structures
DECLARE
    CURSOR c_loans IS SELECT LoanID, InterestRate FROM Loans;
    v_loanID Loans.LoanID%TYPE;
    v_rate Loans.InterestRate%TYPE;
BEGIN
    OPEN c_loans;
    LOOP
        FETCH c_loans INTO v_loanID, v_rate;
        EXIT WHEN c_loans%NOTFOUND;
        UPDATE Loans SET InterestRate = InterestRate * 0.99 WHERE LoanID = v_loanID;
    END LOOP;
    CLOSE c_loans;
    COMMIT;
END;
/

-- 2. Stored Procedures
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';
    COMMIT;
END ProcessMonthlyInterest;
/\n