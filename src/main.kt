//Declare global variables that can be used in multiple functions
var name: String = ""
var phone: String = ""
var address: String = ""
var squareFeet: Double = 0.0
var seniorDiscount: Boolean = false
var multipleProperties: Boolean = false
var propertyName: String = ""
var choice = 0

//Main function of the program that will print a menu to build customer objects
fun main() {
//Ask user which type of customer they are
    println("Are you a residential of business customer? \n 1 -> Residential \n 2 -> Business")
    print("Choice: ")
    //Validate that the user is entering in an int and not a string or double
    try {
        choice = readLine()!!.toInt()
    } catch (error: NumberFormatException) {
        println("Error: ${error.message} and not an Integer")
    }

    //Validate and run specific functions that apply to each type of customer
    when (choice) {
        1 -> {
            basicInfo()
            residentInfo()
            val resident = Residential(name, phone, address, squareFeet, seniorDiscount)
            resident.weeklyCharges()
        }
        2 -> {
            basicInfo()
            commercialInfo()
            val commercial = Commercial(name, phone, address, squareFeet, propertyName, multipleProperties)
            commercial.weeklyCharges()
        }
        !in 1..2 -> println("INVALID CHOICE")
        else -> println("INVALID CHOICE")
    }
}

//Basic info in put function that all customers will have
fun basicInfo() {

    print("Please enter your name : ")
    name = readLine()!!.toString()
    print("Please enter your address: ")
    address = readLine()!!.toString()
    print("Please enter your phone number: ")
    phone = readLine()!!.toString()
    //Validate the the user is entering a double and not a string
    try {
        print("Please enter your square footage : ")
        squareFeet = readLine()!!.toDouble()
    } catch (error: java.lang.NumberFormatException) {
        println("Error: ${error.message} and not a number")
    }
}

//Input function that is specific to residential customers
fun residentInfo() {
    seniorDiscount = false
    print("Are you a senior citizen? yes or no: ")
    var senior = readLine()!!.toString()
    while (!((senior.equals("yes", ignoreCase = true)) || senior.equals("no", ignoreCase = true))) {
        print("Are you a senior citizen? yes or no: ")
        senior = readLine()!!.toString()
    }
    if (senior.equals("yes", ignoreCase = true))
        seniorDiscount = true
}

//Input function that is specific to commercial customers
fun commercialInfo() {
    multipleProperties = false
    print("What is the name of your property: ")
    propertyName = readLine()!!.toString()
    print("Do you have multiple properties? yes or no: ")
    var multiResult = readLine()!!.toString()
    while (!((multiResult.equals("yes", ignoreCase = true)) || multiResult.equals("no", ignoreCase = true))) {
        print("Do you have multiple properties? yes or no: ")
        multiResult = readLine()!!.toString()
    }
    if (multiResult.equals("yes", ignoreCase = true))
        multipleProperties = true
}