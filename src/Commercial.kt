/**
 * Class Commercial
 * @author Brian B
 * date: 3/7/20
 * @param
 * propertyName is the name of the property
 * multiProperty is if the customer has multiple properties
 * commercialRate is the rate they are being charged based on the square footage of the property
 * weeklyRate is the calculated weekly rate they are charged
 * currency will format the weekly charges to money
 *
 * mod
 *BCB 3/7/20 added comment blocks
 *
 */
import java.text.DecimalFormat

class Commercial constructor(
    customerName: String,
    customerPhone: String,
    customerAddress: String,
    squareFootage: Double,
    propertyName: String,
    multiProperty: Boolean
) : Customer(customerName, customerPhone, customerAddress, squareFootage) {
    //Declare and initialize variables specific to a commercial customer
    private var propertyName: String = ""
    private var multiProperty = false
    private var commercialRate: Double = 0.0
    private var weeklyRate = ""
    private val currency = DecimalFormat("\$###,###,###,###.00")

    init {
        println("Creating a new Commercial Customer..........DONE")
        this.propertyName = propertyName
        this.multiProperty = multiProperty
    }

    //Calculate weekly charges based on variables and parameters and print all by calling the customer class printAll()
    //and then adding commercial specific information
    fun weeklyCharges() {

        commercialRate = (squareFootage / 1000) * 5
        weeklyRate = currency.format(commercialRate)

        if (multiProperty) {
            commercialRate -= (commercialRate * .10)
            weeklyRate = currency.format(commercialRate)
        }
        super.printAll()
        println("Property Name: $propertyName \nMulti-Property: $multiProperty \nWeekly Charges: $weeklyRate")
    }

}