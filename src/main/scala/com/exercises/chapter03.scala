import scala.util.Random

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
}