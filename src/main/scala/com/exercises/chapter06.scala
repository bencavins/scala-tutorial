

object chapter06 extends App {
    

    def exercise01 {
        object Conversions {
            def inchesToCentimeters(inches: Double) = {
                inches * 2.54
            }
            def gallonsToLiters(gallons: Double) = {
                gallons * 3.785411784
            }
            def milesToKilometers(miles: Double) = {
                miles * 1.609344
            }
        }

        assert(Conversions.inchesToCentimeters(1) == 2.54)
        assert(Conversions.gallonsToLiters(10) == 37.85411784)
        assert(Conversions.milesToKilometers(100) == 160.9344)
    }

    def exercise02 {}

    def exercise03 {}

    def exercise04 {}

    def exercise05 {}

    def exercise06 {}

    def exercise07 {}

    def exercise08 {}

    exercise01
}