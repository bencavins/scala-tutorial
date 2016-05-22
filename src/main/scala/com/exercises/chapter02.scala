

object chapter02 {
	
	// 1.

	def signum(n: Int) = {
		if (n > 0) 1
		else if (n < 0) -1
		else 0
	}

	assert(signum(2)  ==  1)
	assert(signum(-5) == -1)
	assert(signum(0)  ==  0)

	// 2.

	val nothing = {}

	/*
	The value of {} is () and the type is Unit
	*/

	// 3.

	/*
	If x is meant to contain a prodecure, this statment makes sense
	*/

	var x: Unit = {} // procedure with type Unit
	var y: Int = 0
	x = y = 1

	// 4.

	for (i <- 10 to (0, -1)) println(i)

	// 5.

	def countdown(n: Int) {
		for (i <- n to (0, -1))
			print(i + " ")
	}

	// 6.

	var product = 1L
	for (c <- "Hello") product *= c
	assert(product == 9415087488L)

	// 7.

	product = "Hello".foldLeft(1L)((a, b) => a * b)
	assert(product == 9415087488L)

	// 8.

	def product(s: String) = {
		s.foldLeft(1L)((a, b) => a * b)
	}

	assert(product("Hello") == 9415087488L)

	// 9.

	def recProduct(s: String): Long = {
		if (s.length == 0) 1L
		else s.head.toLong * recProduct(s.tail)
	}

	assert(recProduct("Hello") == 9415087488L)

	// 10.

	def xton(x: Int, n: Int): Double = {
		if (n == 0) 1.0
		else if (n % 2 == 0 && n > 0) scala.math.pow(xton(x, n / 2), 2)
		else if (n % 2 == 1 && n > 0) x * xton(x, n - 1)
		else /* n is negative */ 1 / xton(x, -n)
	}

	assert(xton(2,  2)  == 4.0)
	assert(xton(3,  3)  == 27.0)
	assert(xton(15, 0) == 1.0)
	assert(xton(2, -1) == 0.5)
}