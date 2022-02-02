import java.io.File
import java.lang.System.out
import kotlin.concurrent.fixedRateTimer

class Contact {
    var name: String? = null
    var last_Name: String? = null
    var mail = ArrayList<String?>()
    var Phone_Number = ArrayList<String?>()

}
var contacts = ArrayList<Contact>()
fun addcontact(){


    var c1 = Contact()
    println("your first name")
    c1.name = readLine()
    println("your last name")
    c1.last_Name = readLine()
    println("your mail")
    c1.mail.add(readLine())
    println("your phone number")
    c1.Phone_Number.add(readLine())

    contacts.add(c1)
}
fun removecontact(){

    for (element in contacts) {
        println(element.name + " " + element.last_Name + " " + element.mail + " " + element.Phone_Number)
    }
    var removeable:Int = readLine()!!.toInt()
    contacts.removeAt(removeable)
}
fun menuopportunity(){
    println("nedan kan du se olika val du kan göra")
    println("1. vill du lägga till en kontakt")
    println("2. vill du ta bort en kontakt")
    println("3. vilka kontakter finns redan")
    println("4. Sortera kontakterna i bokstavsorning med förnamn")
    println("5. Sortera kontakterna i bokstavsordning med efternamn")
    println("6. spara kontakterna permanent")
    println("6. Avsluta rogramet")
}
fun sorting_firstname(){
    val sortedlist = contacts.sortedBy {it.name  }
    for (element in sortedlist) {
        println(element.name + " " + element.last_Name + " " + element.mail + " " + element.Phone_Number)
    }
}
fun sorting_lastname(){
    val sortedlist = contacts.sortedBy {it.last_Name  }
    for (element in sortedlist) {
        println(element.name + " " + element.last_Name + " " + element.mail + " " + element.Phone_Number)
    }
}
fun writeToFile() {
    File("src/main/kotlin/contacts.txt").printWriter().use { out ->
        contacts.forEach {
            out.println("${it.name}, ${it.last_Name}, ${it.mail}, ${it.Phone_Number}")
        }
    }
}
fun main(args: Array<String>) {

    var stayinloop = false

        do {
            menuopportunity()
            var menuchoise = readLine()!!.toInt()
            when (menuchoise) {

                1 -> addcontact()
                2 -> removecontact()
                3 -> {
                    for (element in contacts) {
                        println(element.name + " " + element.last_Name + " " + element.mail + " " + element.Phone_Number)
                    }
                }
                4 -> sorting_firstname()
                5 -> sorting_lastname()
                6 -> writeToFile()
                7 -> stayinloop = true
                else -> {
                    stayinloop = false//println("är du sne? det nummret finns inte!")
                }
            }
        }
        while (stayinloop == false)
            println("rogramet avslutas")



    for (element in contacts) {
        println(element.name + " " + element.last_Name + " " + element.mail + " " + element.Phone_Number )
    }
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

