import scala.io.Source
import scala.collection.mutable.ArrayBuffer

import java.io.PrintWriter

object chapter09 {
        
    object exercise01 {
        val lines = Source.fromFile("./src/main/resources/words.txt").getLines
        val arrayBuffer = new ArrayBuffer[String]()
        for (line <- lines) arrayBuffer.prepend(line)
        for (line <- arrayBuffer) println(line)
    }

    object exercise02 {
        val n = 4
        val contents = Source.fromFile("./src/main/resources/tabs.txt").mkString
        val newContents = contents.replace("\t", (" " * n))
        val out = new PrintWriter("./src/main/resources/tabs.txt")
        for (c <- newContents) out.print(c)
        out.close
    }
    
    object exercise03 {
        for (word <- Source.fromFile("./src/main/resources/big-words.txt").mkString.split("\\s+") if word.length >= 12) println(word)
    }
    
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