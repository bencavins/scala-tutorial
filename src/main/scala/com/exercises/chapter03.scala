import scala.util.Random
import scala.collection.mutable.ArrayBuffer
import java.awt.datatransfer._
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable.Buffer

object chapter03 {
    
    // 1
    def mkRandArray(n: Int): Array[Int] = {
        val a = new Array[Int](n)
        for (i <- 0 until a.length)
            a(i) = Random.nextInt
        a
    }
    
    assert(mkRandArray(10).length == 10)

    // 2

    def swapAdjacent(a: Array[Int]) = {
        for (i <- 0 until a.length if i % 2 == 1) {
            val temp = a(i)            
            a(i) = a(i - 1)
            a(i - 1) = temp
        }
        a
    }

    assert(swapAdjacent(Array(1,2,3,4,5)) == Array(2,1,4,3,5))

    // 3

    def swapAdjacent2(a: Array[Int]) = {
        val res = for (i <- 0 until a.length) yield 
            if (i % 2 == 1 && i != a.length) a(i - 1)
            else if (i == a.length - 1) a(i)
            else a(i + 1)
        res.toArray
    }

    assert(swapAdjacent2(Array(1,2,3,4,5)) == Array(2,1,4,3,5))

    // 4

    def positiveFirst(a: Array[Int]) = {
        val positives = for (elem <- a if elem > 0) yield elem
        val negatives = for (elem <- a if elem <= 0) yield elem
        positives ++ negatives
    }

    assert(positiveFirst(Array(0,1,-2,-3,4,-5,6,7)) == Array(1,4,6,7,0,-2,-3,-5))

    // 5

    def average(a: Array[Double]) = {
        a.sum / a.length
    }

    assert(average(Array(1.0, 5.5, 2.0, -1.0)) == 1.875)

    // 6

    val a = Array(1,5,2,7,4)
    val b = ArrayBuffer(3,65,8,4,2)
    assert(a.sortWith(_ > _) == Array(1,2,4,5,7))
    assert(b.sortWith(_ > _) == ArrayBuffer(2,3,4,8,65))

    // 7

    assert(Array(1,1,2,3).distinct == Array(1,2,3))

    // 8

    def oneNeg(a: ArrayBuffer[Int]): ArrayBuffer[Int] = {
        val indexes = {
            for (i <- 0 until a.length if a(i) < 0) yield i
        }.reverse.dropRight(1)
        for (index <- indexes) a.remove(index)
        a
    }

    assert(oneNeg(ArrayBuffer(1, -2, 3, 4, -5, -6)) == ArrayBuffer(1, -2, 3, 4))
    assert(oneNeg(ArrayBuffer(1, 2, 3)) == ArrayBuffer(1, 2, 3))

    // 9

    java.util.TimeZone.getAvailableIDs.filter(
            _.startsWith("America/")
        ).map(
            _.drop("America/".length)
        ).sorted

    // 10

    val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
    val list = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
    val scalaBuffer: Buffer[String] = new ProcessBuilder(list).command
}