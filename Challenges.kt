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

/*
* 3. An important part of data preparation is to ensure that data strings are uniformly
* formatted and capitalized. For a given input string, create a function that accepts a string input as well as
* an argument string that’s either “upper” or “lower.”

If “upper,” then the function should convert everything in the string to upper case,
* while the “lower” argument should return the string with every character in lowercase.

To give yourself an added challenge, add the arguments “snake” and “camel”
* that convert a string of words separated by spaces into snake case or camel case.
* */

fun formatString(format: String) : String?{

    print("Enter string to format: ")
    val inputString = try {
        readLine()!!
    }catch (ex: Exception){
        ""
    }

    when(format){
        "upper" -> return inputString.uppercase()
        "lower" -> return inputString.lowercase()
    }
    return null
}

/*
* 4. For a given input string of words, create a function that returns the longest
*   word in the string. For example, for the input phrase “I love Codecademy,” the output should be “Codecademy.”

    For an added challenge, you can create an output that lists the longest word along with the number
*  of characters in the word. So, for the string “I love Codecademy,” the output would look something like,
* “word: Codecademy count: 10.”
* */
fun getLongestWord() : String {

    print("Enter a sentence: ")
    val inputString = try {
        readLine()!!
    }catch (ex: Exception){
        ""
    }
    val splitList = inputString.split(" ")

    var longestWord = ""
    if (splitList.isNotEmpty()){
        longestWord = splitList[0]
    }

    splitList.forEach { item ->
        if(longestWord.length < item.length){
            longestWord = item
        }
    }
    return "Word: $longestWord, Count: ${longestWord.length}";
}

/*
* In cryptography, a Caesar cipher is a simple encryption technique that shifts every letter in a message
* by a certain number of letters. The number of letters to shift is known as the key or shift parameter. For example,
* if the key is 1, then the message:

“Codecademy is awesome!”
becomes:
“Dpefdbefnz jt bxftpnf!”
*
* Note how every letter in the encrypted message is one letter after each letter in the original message.

Create a Caesar cipher function that accepts an integer key and a message string as inputs. If the encrypted
* letter goes beyond the letter z, it should wrap around to the beginning of the alphabet.
*
* */

fun encryptCaesar(key: Int, message: String) : String{

    val alphabetLower = ('a'..'z').toMutableList()
    val alphabetUpper = ('A'..'Z').toMutableList()

    var encryptedText = ""
    var newText = ""

    loop@ for (i in message){

        var index = alphabetLower.indexOf(i)

        newText = when (index) {
            -1 -> {
                if(i.toString() != " "){
                    index = alphabetUpper.indexOf(i)
                    index += 1
                    if(index == alphabetUpper.size){
                        index = 0
                    }
                    println(index)
                    alphabetUpper[index].toString()
                }else{
                    i.toString()
                }
            }
            alphabetLower.size - 1 -> {
                index = 0
                alphabetLower[index].toString()
            }
            else -> {
                index += 1
                alphabetLower[index].toString()
            }
        }
        encryptedText += newText
    }
    println(message)
    println(encryptedText)
    return encryptedText
}

fun decryptText(encryptedText: String) : String?{
    return null
}

fun foo() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // local return to the caller of the lambda - the forEach loop
        print(it)
    }
    print(" done with implicit label")
}

data class Train(val trainNumber: Int, val time: String, val endStation: String)

/*
* 5. Train route
    Create a function that lists the stations on a train route based on an input of stations.
*   For example, an input of (“NY Penn”) should output “Train is stopping at NY Penn.”
*   For an input of (“NY Penn,” “Woodside,” “Forest Hills”), the output should be
*    “Train is stopping at NY Penn, Woodside, and Forest Hills.”

    If you want to challenge yourself a bit more, add a second input that includes train departure time, train number,
    and destination station. So, with the inputs (234, “10:00”, “Montauk”) and (“NY Penn,” “Babylon,” “Sayville”),
    the output should be “10:00 train number 234 to Montauk is stopping at NY Penn, Babylon and Sayville.”

    Remember that the train number should be input as an integer but output as part of a string.
* */

fun trainRoute(train: Train, routes: List<String>) : String{

    val size = routes.size
    var output = "${train.time} train number ${train.trainNumber} to ${train.endStation} is stopping at "

    for ((index, route) in routes.withIndex()){
        output += if (routes.size == 1){
            route
        } else if (index == size - 1){
            "and $route"
        }else if(index == size - 2){
            "$route "
        }else{
            "$route, "
        }
    }
    return output
}

/*
* 6. Permutation palindrome
A palindrome is a word or phrase that could be spelled the same forward and backward.
* Examples of palindromes include the words “level” and “racecar” as well as the phrase “taco cat.”

Create a function that returns TRUE if an input string is a permutation of a
* palindrome — that is, if the string could somehow be rearranged to make a palindrome.
* For example, the strings “racecar,” “carrace,” and “gghhk” should return TRUE, while words such as “tammy” and “code”
* should return FALSE.

For an additional challenge, allow your input to include phrase strings. You’ll need to find a way to remove all spaces in the input string before running your function.

* */

fun isPalindrome(phrase: String): Boolean{

    val newPhrase = phrase.replace(" ", "")
    var reversedString = ""

    for(char in newPhrase){
        reversedString = char + reversedString
    }
    return reversedString == newPhrase
}
fun isPalindrome2(phrase: String) : Boolean{
    val phrase2 = phrase.replace(" ", "")
    val reversed = phrase2.reversed()
    return reversed == phrase2
}

/*
* 7. FizzBuzz
The FizzBuzz challenge is a popular problem in technical interviews. For a given maximum input value n,
 create a function that outputs integers from 1 to n.

But, if an integer is divisible by three, then the number should be replaced with the word “Fizz.”
Numbers divisible by five should say “Buzz” instead. And numbers divisible by both three and five should say “FizzBuzz.”

For example, with an input of 17, the output should be:

[1, 2 , ”Fizz”, 4, “Buzz”, “Fizz”, 7, 8, “Fizz“, “Buzz“, 11, “Fizz”, 13, 14, “FizzBuzz”, 16, 17]

*
* */

fun fizzBuzz(max: Int): Array<Any>{

    val output = Array<Any>(max){}

    for ((index, num)  in (1..max).withIndex()){

        output[index] = if (num.mod(3) == 0){
                        "Fizz"
                    }else if (num.mod(5) == 0){
                        "Buzz"
                    }else{
                        num
                    }

        if (num.mod(3) == 0 && num.mod(5) == 0){
            output[index] = "FizzBuzz"
        }

    }
    return output
}

/*
* 8. Steps
For a given integer input n, create a function that returns a string output of generated steps
* using the # character. For example, for an input of 3, the output should look like:
‘# ‘
‘##’
‘###’
If you’d like to “step up” this challenge, add a string input that allows the function to generate steps for any given single character.
* */
fun steps(steps: Int, stepChar: String = "#"){

    var output = ""
    for (i in 1 .. steps){
        for (num in 1..i){
            output += stepChar
        }
        println(output)
        output = ""
    }
}

/*
* 9. Triangles, etc.
Come up with a function that creates a triangle based on an integer input to
* specify the number of rows and a string input to determine the “building block” of
* the triangle. If you want to challenge yourself more, add a third input that allows someone to
* specify different shapes such as a circle, square, or trapezoid.
*
* */
fun createTriangle(rows: Int, block: String = "#"){
    var triangleOutput = ""
    for (row in 1..rows){
        for (num in 1..row){
            triangleOutput += block
        }
        println(triangleOutput)
        triangleOutput=""
    }
}

fun main(){
    //println("Results: ${sequence()}")
    //println("Fibonacci sequence: ${fibonacciGenerator()}")

    //println(formatString("lower"))

    //println("Longest word: ${getLongestWord()}")

    //encryptCaesar(3, "Note how every letter in the encrypted")

    //foo()

    //println(trainRoute(Train(234, "10.00 am", endStation = "Montauk"), listOf("NY Penn", "Woodside", "Forest Hills", "Hilton")))

    //println("Phrase is a Palindrome: ${isPalindrome("taco cat")}")

    //println("Phrase is a Palindrome: ${isPalindrome2("level")}")

    //println(fizzBuzz(20).asList())
    //steps(7)
    createTriangle(10)
}



