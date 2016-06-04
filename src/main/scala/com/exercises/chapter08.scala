package com.bencavins.scalaforimpatient

object chapter08 extends App {
    
    object exercise01 {
        class BankAccount(initalBalance: Double) {
            private var balance = initalBalance
            def currentBalance = balance
            def deposit(amount: Double) = { balance += amount; balance }
            def withdraw(amount: Double) = { balance -= amount; balance }
        }

        class CheckingAccount(initalBalance: Double) extends BankAccount(initalBalance) {
            override def deposit(amount: Double) = { 
                super.withdraw(1.0)
                super.deposit(amount) 
            }
            override def withdraw(amount: Double) = {
                super.withdraw(1.0)
                super.withdraw(amount)
            }
        }

        val account = new CheckingAccount(100.00)
        assert(account.currentBalance == 100.00)
        account.deposit(50.00)
        assert(account.currentBalance == 149.00)
        account.withdraw(100.00)
        assert(account.currentBalance == 48.00)
    }

    object exercise02 {
        class BankAccount(initalBalance: Double) {
            private var balance = initalBalance
            def currentBalance = balance
            def deposit(amount: Double) = { balance += amount; balance }
            def withdraw(amount: Double) = { balance -= amount; balance }
        }

        class SavingsAccount(initalBalance: Double) extends BankAccount(initalBalance) {
            private var transactions = 0
            override def deposit(amount: Double) = {
                transactions += 1
                if (transactions > 3) super.withdraw(1.0)
                super.deposit(amount)
            }
            override def withdraw(amount: Double) = {
                transactions += 1
                if (transactions > 3) super.withdraw(1.0)
                super.withdraw(amount)
            }
            def earnMonthyInterest(multiplier: Double) = {
                transactions = 0
                super.deposit(super.currentBalance * multiplier)
            }
        }

        val account = new SavingsAccount(100.00)
        assert(account.currentBalance == 100.00)
        account.deposit(50.00) // transaction 1
        assert(account.currentBalance == 150.00)
        account.withdraw(20.00) // transaction 2
        assert(account.currentBalance == 130.00)
        account.deposit(100.00) // transaction 3
        assert(account.currentBalance == 230.00)
        account.withdraw(29.00) // transaction 4
        assert(account.currentBalance == 200.00) // one extra dollar removed
        account.earnMonthyInterest(0.10) // I wish I had this interest rate!
        assert(account.currentBalance == 220.00)
        account.withdraw(200.00) // transaction count reset to 1
        assert(account.currentBalance == 20.00)
    }
    
    object exercise03 {}

    object exercise04 {}
    
    object exercise05 {}
    
    object exercise06 {}
    
    object exercise07 {}
    
    object exercise08 {}
    
    object exercise09 {}
    
    object exercise10 {}

    exercise01
    exercise02
    exercise03
    exercise04
    exercise05
    exercise06
    exercise07
    exercise08
    exercise09
    exercise10
}