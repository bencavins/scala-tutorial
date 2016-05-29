
object chapter05 {

    def exercise01 {
        class Counter {
            private var value = 0
            def increment() { 
                if (value != Int.MaxValue) value += 1 
            }
            def current = value
        }

        val counter = new Counter
        for (i <- 0 to Int.MaxValue - 1) counter.increment() // seqs cannot contain more that Int.MaxValue elements
        assert(counter.current == Int.MaxValue)
        counter.increment
        assert(counter.current == Int.MaxValue)
    }

    def exercise02 {
        class BankAccount {
            private var _balance = 0

            def balance = _balance

            def deposit(amount: Int) { _balance += amount }
            def withdraw(amount: Int) { _balance -= amount }
        }

        val b = new BankAccount
        assert(b.balance == 0)
        b.deposit(100)
        assert(b.balance == 100)
        b.withdraw(150)
        assert(b.balance == -50)
    }

    def exercise03 {
        class Time(private val hours: Int = 0, private val minutes: Int = 0) {
            def before(other: Time) = {
                hours < other.hours || (hours == other.hours && minutes < other.minutes)
            }
        }

        val t0 = new Time()
        val t1 = new Time(5)
        val t2 = new Time(5, 30)

        assert( t0.before(t1))
        assert(!t1.before(t0))
        assert( t1.before(t2))
        assert(!t2.before(t1))
    }

    def exercise04 {}

    def exercise05 {}

    def exercise06 {}

    def exercise07 {}

    def exercise08 {}

    def exercise09 {}

    def exercise10 {}

    def main(args: Array[String]) {
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

}