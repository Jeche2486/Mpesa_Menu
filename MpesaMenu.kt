fun main() {
    // Step 1: Create variables
    val userPin = "1234" // Example user PIN
    var balance = 1000.0  // Example balance
    var phoneNo: String

    // Input phone number
    print("Please enter your phone number: ")
    phoneNo = readLine() ?: ""

    // Step 2: Create a loop for login
    val maxAttempts = 3
    var attempts = 0
    var isAuthenticated = false

    while (attempts < maxAttempts && !isAuthenticated) {
        print("Enter your PIN: ")
        val inputPin = readLine() ?: ""

        if (inputPin == userPin) {
            println("PIN verified successfully.")
            isAuthenticated = true
        } else {
            attempts++
            println("Invalid PIN. Attempts left: ${maxAttempts - attempts}")
        }
    }

    if (!isAuthenticated) {
        println("Too many failed attempts. Access denied.")
        return
    }

    // Step 3: After successful login, show options
    while (true) {
        println("\n--- M-Pesa Toolkit Menu ---")
        println("1. Send Money")
        println("2. Withdraw Cash")
        println("3. Buy Airtime")
        println("4. Loans and Savings")
        println("5. Lipa na M-Pesa")
        println("6. My Account")
        println("7. Exit")
        print("Choose an operation: ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                // Send Money
                print("Enter the recipient's phone number: ")
                val recipientPhone = readLine() ?: ""
                print("Enter the amount to send: ")
                val amount = readLine()?.toDoubleOrNull() ?: 0.0

                print("Confirm your PIN: ")
                val confirmPin = readLine() ?: ""

                if (confirmPin == userPin) {
                    if (amount > 0 && amount <= balance) {
                        balance -= amount
                        println("Transaction successful! You have sent Ksh $amount to $recipientPhone.")
                    } else {
                        println("Insufficient balance or invalid amount.")
                    }
                } else {
                    println("PIN confirmation failed.")
                }
            }
            2 -> {
                // Withdraw Cash
                print("Enter amount to withdraw: ")
                val amount = readLine()?.toDoubleOrNull() ?: 0.0

                if (amount > 0 && amount <= balance) {
                    balance -= amount
                    println("Ksh $amount withdrawn successfully. New balance is: Ksh $balance")
                } else {
                    println("Invalid amount. Please check your balance.")
                }
            }
            3 -> {
                // Buy Airtime
                print("Enter amount for airtime: ")
                val amount = readLine()?.toDoubleOrNull() ?: 0.0

                if (amount > 0 && amount <= balance) {
                    balance -= amount
                    println("Ksh $amount airtime purchased successfully. New balance is: Ksh $balance")
                } else {
                    println("Invalid amount. Please check your balance.")
                }
            }
            4 -> {
                // Loans and Savings
                println("Currently, this feature is under development.")
            }
            5 -> {
                // Lipa na M-Pesa
                print("Enter the merchant phone number: ")
                val merchantNumber = readLine() ?: ""
                print("Enter amount to pay: ")
                val amount = readLine()?.toDoubleOrNull() ?: 0.0

                if (amount > 0 && amount <= balance) {
                    balance -= amount
                    println("Ksh $amount paid to $merchantNumber. New balance is: Ksh $balance")
                } else {
                    println("Invalid amount. Please check your balance.")
                }
            }
            6 -> {
                // My Account
                println("Your current balance is: Ksh $balance")
                println("Your registered phone number is: $phoneNo")
            }
            7 -> {
                // Exit
                println("Exiting the program. Thank you!")
                return
            }
            else -> {
                // Invalid option
                println("Invalid choice. Please try again.")
            }
        }
    }
}


