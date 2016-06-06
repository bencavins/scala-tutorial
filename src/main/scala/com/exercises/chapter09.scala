import scala.io.Source
import scala.collection.mutable.ArrayBuffer

object chapter09 {
        
    object exercise01 {
        val lines = Source.fromFile("./src/main/resources/words.txt").getLines
        val arrayBuffer = new ArrayBuffer[String]()
        for (line <- lines) arrayBuffer.prepend(line)
        for (line <- arrayBuffer) println(line)
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