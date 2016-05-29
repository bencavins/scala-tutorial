
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

    def exercise02 {}

    def exercise03 {}

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