val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
val newSolarSystem = arrayOf("Mercury", "Venus", "Earth", "Mars","Jupiter", "Saturn", "Uranus", "Neptune")
fun main() {
    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystem.size)
    println(solarSystem[2])
    println(solarSystem.indexOf("Pluto"))
    solarSystem.add("Pluto")
    solarSystem.add(3,"Thea")
    solarSystem[3]="Future Moon"
    solarSystem.removeAt(9)
    println("Future Moon" in solarSystem)


}