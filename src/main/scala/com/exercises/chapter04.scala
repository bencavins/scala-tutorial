import scala.io.Source

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
    
    val in = new Scanner(new File("/home/ben/dev/scala/scala-impatient/src/main/resources/words.txt"))
    val m = new scala.collection.mutable.HashMap[String, Int]
    while (in.hasNext) {
        val word = in.next
        if (m.contains(word)) m(word) += 1
        else m(word) = 1
    }
}