val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
val newSolarSystem = arrayOf("Mercury", "Venus", "Earth", "Mars","Jupiter", "Saturn", "Uranus", "Neptune")
fun main() {
    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    solarSystem.add("Pluto")
    solarSystem.add(3,"Theia")
    for (planet in solarSystem){
        println(planet)
    }
    solarSystem[3] = "Future Moon"
    println(solarSystem[3])
    println(solarSystem[9])
    solarSystem.removeAt(9)
    println(solarSystem.contains("Pluto"))
    println("Future Moon" in solarSystem)

}