

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

        assert(inchesToCentimeters.convert(1) == 2.54)
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

    def exercise04 {
        class Point(val x: Double, val y: Double) {}
        object Point {
            def apply(x: Double, y: Double) = new Point(x, y)
        }

        val p = Point(1, 5)
        assert(p.x == 1.0)
        assert(p.y == 5.0)
    }

    def exercise05 {
        // See chapter06-05.scala
    }

    def exercise06 {
        object Suit extends Enumeration {
            type Suit = Value

            val Heart   = Value("♥")
            val Club    = Value("♣")
            val Spade   = Value("♠")
            val Diamond = Value("♦")
        }

        assert(Suit.Heart.toString   == "♥")
        assert(Suit.Club.toString    == "♣")
        assert(Suit.Spade.toString   == "♠")
        assert(Suit.Diamond.toString == "♦")
    }

    def exercise07 {
        object Suit extends Enumeration {
            type Suit = Value

            val Heart   = Value("♥")
            val Club    = Value("♣")
            val Spade   = Value("♠")
            val Diamond = Value("♦")
        }

        import Suit._

        def isRed(suit: Suit) = {suit == Suit.Heart || suit == Suit.Diamond}

        assert(isRed(Suit.Heart))
        assert(isRed(Suit.Diamond))
        assert(!isRed(Suit.Spade))
        assert(!isRed(Suit.Club))
    }

    def exercise08 {
        object Color extends Enumeration {
            type Color = Value

            val Red = Value(0xff0000, "Red")
            val Green = Value(0x00ff00, "Green")
            val Blue = Value(0x0000ff, "Blue")
            val Yellow = Value(0xffff00, "Yellow")
            val Cyan = Value(0x00ffff, "Cyan")
            val Magenta = Value(0xff00ff, "Magenta")
            val White = Value(0xffffff, "White")
            val Black = Value(0x000000, "Black")
        }
    }

    exercise01
    exercise02
    exercise03
    exercise04
    exercise05
    exercise06
    exercise07
    exercise08
}