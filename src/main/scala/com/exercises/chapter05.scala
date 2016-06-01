import scala.beans.BeanProperty

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

    def exercise04 {
        class Time(hours: Int = 0, minutes: Int = 0) {
            private val timestamp = (hours * 60) + minutes - 1

            def before(other: Time) = {
                timestamp < other.timestamp
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

    def exercise05 {
        class Student(@BeanProperty var name: String, @BeanProperty var id: Long) {}

        val s = new Student("Ben", 1234)
        assert(s.getName == "Ben")
        assert(s.getId == 1234)
        s.setName("Jesse")
        s.setId(456789)
        assert(s.getName == "Jesse")
        assert(s.getId == 456789)

        /*
        public class Student implements scala.ScalaObject {
          public java.lang.String name();
          public void name_$eq(java.lang.String);
          public void setName(java.lang.String);
          public long id();
          public void id_$eq(long);
          public void setId(long);
          public long getId();
          public java.lang.String getName();
          public Student(java.lang.String, long);
        }
        */
    }

    def exercise06 {
        class Person(var name: String, var age: Int) {
            if (age < 0) age = 0
        }

        assert(new Person("Ben", 25).age == 25)
        assert(new Person("Jesse", -1).age == 0)
    }

    def exercise07 {
        class Person(name: String) {
            val firstName = name.split(" ").head
            val lastName = name.split(" ").last
        }

        assert(new Person("Ben Cavins").firstName == "Ben")
        assert(new Person("Ben Cavins").lastName == "Cavins")
    }

    def exercise08 {
        class Car(val manufacturer: String, 
            val modelName: String, 
            val modelYear: Int = -1, 
            val licensePlate: String = "") {}

        val c0 = new Car("Ford", "F-150")
        assert(c0.manufacturer == "Ford")
        assert(c0.modelName == "F-150")
        assert(c0.modelYear == -1)
        assert(c0.licensePlate == "")

        val c1 = new Car("Toyota", "Camery", 2001)
        assert(c1.manufacturer == "Toyota")
        assert(c1.modelName == "Camery")
        assert(c1.modelYear == 2001)
        assert(c1.licensePlate == "")

        val c2 = new Car("Oldsmobile", "Alero", 1999, "9PQ-LOL")
        assert(c2.manufacturer == "Oldsmobile")
        assert(c2.modelName == "Alero")
        assert(c2.modelYear == 1999)
        assert(c2.licensePlate == "9PQ-LOL")
    }

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