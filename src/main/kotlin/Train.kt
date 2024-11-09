class Train () {

    private val towns : MutableSet<String> = mutableSetOf("Saratov", "Saransk", "Saxalin", "Samara", "Sizzran", "Sesstroreck",
        "Sortavala", "Moskva", "Anapa", "Orlov", "Germania", "Sestrobrack", "Ittaly", "Sovkov", "ALTAY")

    private fun createRout(): MutableSet<String> {
        var a = true
        val startTown = towns.random()
        var endTown = ""
        while (a) {
            endTown = towns.random()
            a = startTown == endTown
        }
        return mutableSetOf(startTown, endTown)
    }

    private fun sellTickets(): Int {
        return (5..251).random()
    }

    private fun createTrain(passengers: Int) {
        val carriages: MutableMap<Int, Int> = mutableMapOf()
        var currentCarriages = 1
        var currentPassengers = passengers
        while (currentPassengers >= 0) {
            val carriageCapacity = (5..25).random()
            carriages[currentCarriages] = carriageCapacity
            println("$currentCarriages Вагон -> $carriageCapacity пассажиров")
            currentPassengers -= carriageCapacity
            currentCarriages++
        }
    }

    fun sendTrain() {
        val rout = this.createRout()
        val passengers = this.sellTickets()
        println("Составил маршрут: ${rout.elementAt(0)} -> ${rout.elementAt(1)}")
        println("Пассажиры, купившие билет: $passengers")
        println("Составляю вагоны:")
        this.createTrain(passengers)
        println("Отправляю поезд!")
    }
}