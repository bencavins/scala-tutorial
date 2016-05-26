import scala.io.Source
import scala.collection.SortedMap
import scala.collection.immutable.TreeMap
import scala.collection.mutable.LinkedHashMap
import scala.collection.JavaConversions
import scala.collection.JavaConversions.propertiesAsScalaMap

import java.io.InputStream
import java.util.Scanner
import java.io.File

object chapter04 {
    
    // 1

    val gizmos = Map("book" -> 10.0, "tv" -> 299.99, "sneakers" -> 79.99)
    val tenPercentOff = for ((gizmo, price) <- gizmos) yield (gizmo, price*0.9)

    assert(tenPercentOff("book") == gizmos("book") * 0.9)
    assert(tenPercentOff("tv") == gizmos("tv") * 0.9)
    assert(tenPercentOff("sneakers") == gizmos("sneakers") * 0.9)

    // 2
    
    var in = new Scanner(new File("/home/ben/dev/scala/scala-impatient/src/main/resources/words.txt"))
    val m = new scala.collection.mutable.HashMap[String, Int]
    while (in.hasNext) {
        val word = in.next
        if (m.contains(word)) m(word) += 1
        else m(word) = 1
    }

    // 3
    def countWords(filename: String) = {
        val in = new Scanner(new File(filename))
        var map: Map[String, Int] = Map()
        while (in.hasNext) {
            val word = in.next
            val value = map.getOrElse(word, 0) + 1
            map = map ++ Map(word -> value)
        }
        map
    }

    assert(countWords("/home/ben/dev/scala/scala-impatient/src/main/resources/words.txt") == 
         Map("your" -> 1, "are" -> 2, "am" -> 1, "world" -> 1, "You" -> 1, "a" -> 1, "I?" -> 1, "who" -> 2, 
            "father" -> 1, "lot" -> 1, "hello" -> 1, "you?" -> 1, "becoming" -> 1, "like" -> 1))

    // 4

    def countWordsSorted(filename: String) = {
        val in = new Scanner(new File(filename))
        var map = SortedMap[String, Int]()
        while (in.hasNext) {
            val word = in.next
            val value = map.getOrElse(word, 0) + 1
            map = map ++ SortedMap[String, Int](word -> value)
        }
        map
    }

    // 5

    def countWordsTree(filename: String) = {
        val in = new Scanner(new File(filename))
        var map = TreeMap[String, Int]()
        while (in.hasNext) {
            val word = in.next
            val value = map.getOrElse(word, 0) + 1
            map = map ++ TreeMap[String, Int](word -> value)
        }
        map
    }

    // 6

    def buildDays(): LinkedHashMap[String, Int] = {
        LinkedHashMap[String, Int](
            "Monday" -> java.util.Calendar.MONDAY,
            "Tuesday" -> java.util.Calendar.TUESDAY,
            "Wednesday" -> java.util.Calendar.WEDNESDAY,
            "Thursday" -> java.util.Calendar.THURSDAY,
            "Friday" -> java.util.Calendar.FRIDAY,
            "Saturday" -> java.util.Calendar.SATURDAY,
            "Sunday" -> java.util.Calendar.SUNDAY)
    }

    for ((k, v) <- buildDays()) println(k + ": " + v)

    // 7

    def printProperties() {
        val properties: scala.collection.Map[String, String] = System.getProperties()
        val largestKey = properties.keysIterator.reduceLeft((x, y) => if (x.length > y.length) x else y)
        for ((property, value) <- properties) {
            val padding = " " * (largestKey.length - property.length + 1)
            println(property + padding + "| " + value)
        }
    }

}