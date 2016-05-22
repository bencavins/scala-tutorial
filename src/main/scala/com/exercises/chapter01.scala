object chapter01 {

// 1.

/*
!=   %   *   -   <    <=       ==   >=   >>>   asInstanceOf   getClass   isInstanceOf   toChar     toFloat   toLong    toString   unary_-   |   
##   &   +   /   <<   <init>   >    >>   ^     equals         hashCode   toByte         toDouble   toInt     toShort   unary_+    unary_~    
*/

// 2.

/*
scala> sqrt(3)
res30: Double = 1.7320508075688772

scala> sqrt(res30)
res31: Double = 1.3160740129524924
*/

// 3.

/*
res are vals

scala> res31 = 0
<console>:15: error: reassignment to val
       res31 = 0
*/

// 4.

/*
scala> "crazy"*3
res32: String = crazycrazycrazy

Can be found in the scala docs under StringOps value member *
*/


// 5.

/*
Returns the max of the two numbers

scala> 10 max 2
res33: Int = 10

Defined in the Int class
*/

// 6.

// scala> BigInt(2).pow(1024)

// 7.

/*
scala> import BigInt.probablePrime
import BigInt.probablePrime

scala> import util.Random
import util.Random

scala> probablePrime(100, Random)
res37: scala.math.BigInt = 1016384592853288851065190027367
*/

// 8.

/*
scala> probablePrime(100, Random).toString(36)
res38: String = 2bs90whczfeme2p35ezv
*/

val string = "hello"
var firstChar = string(0)
var lastChar = string(string.length - 1)
firstChar = string.head
lastChar = string.last

// 9.

val s = "hello"

// returns the first 3 characters
s.take(3) // hel

// returns everything except the first 3 characters
s.drop(3) // lo

// returns the first 3 characters, starting from the end of the string
s.takeRight(3) // llo

// returns everything except the first 3 characters, starting from the end of the string
s.dropRight(3) // he

/*
These simplify the substring method since these requre less arguments. In particular, using the
takeRight and dropRight methods, you don't have to calculate the length of the string in order
to get the substring
*/

}