

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

    def exercise02 {
        abstract class UnitConversion(val factor: Double) {
            def convert(value: Double) = { value * factor }
            def apply(value: Double) = convert(value)
        }

        object inchesToCentimeters extends UnitConversion(2.54) {}
        object gallonsToLiters extends UnitConversion(3.785411784) {}
        object milesToKilometers extends UnitConversion(1.609344) {}

        assert(inchesToCentimeters.convert(1) == 2.45)
        assert(gallonsToLiters.convert(10) == 37.85411784)
        assert(milesToKilometers.convert(100) == 160.9344)
    }

    def exercise03 {
        object Origin extends java.awt.Point(1, 5) {}

        assert(Origin.getX == 1.0)
        assert(Origin.getY == 5.0)

        // This isn't a good idea because the coordinates for java.awt.Point can be changed
        // with the move() method

        Origin.move(-1, -5)

        assert(Origin.getX == -1.0)
        assert(Origin.getY == -5.0)
    }

    def exercise04 {}

    def exercise05 {}

    def exercise06 {}

    def exercise07 {}

    def exercise08 {}

    exercise01
}