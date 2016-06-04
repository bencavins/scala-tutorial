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

    object exercise02 {}
    
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