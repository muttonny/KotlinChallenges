
/*
*  1. Create your own Kotlin function from scratch that creates a sequenced list
*  of numbers from 0 to a maximum input value and input step. For example,
*  a maximum value of 8 and a step value of 2 should return an output of [2, 4, 6, 8].
* */
fun sequence() : List<Int>{

    val min = 1
    var results = mutableListOf<Int>()
    print("Enter maximum number: ")
    val inputMax = readLine()
    val max = try {
        inputMax!!.toInt()
    }catch (ex: Exception){
        println("Enter valid number")
        return emptyList()
    }

    if(max == min || max < min){
        println("Max value should be greater than Min value")
        return emptyList()
    }

    print("Enter step value: ")
    val inputMin = readLine()
    val step = try{
        inputMin!!.toInt()
    }catch (ex: Exception){
        println("Enter valid step number")
        return emptyList()
    }

    var nextNum = min
    val range = min..max

    range.forEach {
        if(nextNum < max){
            println(nextNum)
            results.add(nextNum)
        }
        nextNum += step
    }
    return results
}

/*
* 2. create a Fibonacci sequence generator. Remember that the following number of
* a Fibonacci sequence is the sum of the two preceding it: [1, 1, 2, 3, 5, 8, 13]
* */

fun fibonacciGenerator(): List<Int>{

    print("Enter Sequence size: ")
    var sequenceSize = try{
        val input = readLine()!!.toInt()
        if(input > 3){
            input
        }else{
            println("Size should greater than 3")
            return emptyList()
        }
    }catch (ex: Exception){
        println("Enter valid size")
        return emptyList()
    }

    var fibonacciList = mutableListOf(0, 1)

    sequenceSize -= fibonacciList.size

    for (i in 0..sequenceSize){
        val fn1 = fibonacciList[fibonacciList.size-1]
        val fn2 = fibonacciList[fibonacciList.size-2]
        val fn = fn1 + fn2
        fibonacciList.add(fn)
    }
    return fibonacciList
}

fun main(){
    //println("Results: ${sequence()}")
    println("Fibonacci sequence: ${fibonacciGenerator()}")
}



