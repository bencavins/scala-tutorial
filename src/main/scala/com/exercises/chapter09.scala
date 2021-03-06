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
    
    object exercise04 {
        val lines = Source.fromFile("./src/main/resources/numbers.txt").getLines.toArray
        val numbers = lines.map(line => line.toDouble)
        val sum = numbers.sum
        val average = numbers.sum / numbers.length // Let's hope there aren't zero numbers
        val max = numbers.reduceLeft((x, y) => if (x > y) x else y)
        val min = numbers.reduceLeft((x, y) => if (x < y) x else y)
    }
    
    object exercise05 {
        val out = new PrintWriter("/tmp/pow-o-two.txt")
        for (n <- 1 to 20) out.println(n + "\t" + scala.math.pow(2, n))
        out.close
    }
    
    object exercise06 {
        val source = Source.fromFile("./src/main/resources/HelloWorld.java").mkString
        val pattern = "\".*\"".r
        val occurrences = pattern.findAllIn(source).toArray
        val out = new PrintWriter("/tmp/quoted-strings.txt")
        for (occurrence <- occurrences) out.println(occurrence)
        out.close
    }
    
    object exercise07 {}
    
    object exercise08 {
        val source = """
        <html!>
        <img src="kitty.jpg"
        """
        val pattern = ".*<img.*\"(.*)\".*".r
        val pattern(src) = source
        println(src) 
    }
    
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