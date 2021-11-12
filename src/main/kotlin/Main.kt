import kotlin.random.Random

fun getComputerChoice(pcChoice: Array<String>): String {
    val randomIndex = Random.nextInt(pcChoice.size)
    return pcChoice[randomIndex]
}

fun getPlayerChoice (playerChoices: Array<String>): String {
    var loop = false
    var playerChoice = ""

    while (!loop) {
        println("Izaberi: ")
        for (item in playerChoices) println(item)

        val playerInput = readLine()
        if (playerInput != null && playerInput in playerChoices) {
            loop = true
            playerChoice = playerInput
        }
        if(!loop) {println("Krivi unos!!")}
    }
    return playerChoice
}

fun getResult (playerChoice: String, computerChoice: String): String {
    var result =""
    result = if ((playerChoice == "skare" && computerChoice == "papir") ||
        (playerChoice == "kamen" && computerChoice == "skare") ||
        (playerChoice == "papir" && computerChoice == "kamen")) {
        "Pobjedio je igrac."
    }
    else if ((computerChoice == "skare" && playerChoice == "papir") ||
        (computerChoice == "kamen" && playerChoice == "skare") ||
        (computerChoice == "papir" && playerChoice == "kamen")) {
        "Pobijedilo je racunalo."
    }
    else {
        "Nerijeseno. "
    }
    return result
}




fun main () {
    val choices = arrayOf("skare", "kamen","papir")
    val choicesForAgain = arrayOf("da", "ne")
    var loop = false

    var playerScore = 0
    var computerScore = 0
    while(!loop) {
        val computer = getComputerChoice(choices)
        val player = getPlayerChoice(choices)
        val result = getResult(playerChoice = player, computerChoice = computer)

        println("Racunalo je izabrao $computer, a ti $player. $result")
        if (result == "Pobijedilo je racunalo.") {
            computerScore += 1
            println("Ukupni rezutat je racunalo: $computerScore, igrac: $playerScore ")
        } else if (result == "Pobjedio je igrac.") {
            playerScore += 1
            println("Ukupni rezutat je racunalo: $computerScore, igrac: $playerScore ")
        }
        else {
            println("Rezultat ostaje isti racunalo: $computerScore, a igrac: $playerScore")
        }

        println("Zelis li igrati ponovo?")
        when(getPlayerChoice(choicesForAgain)){
            "da" -> loop = false
            "ne" -> loop = true
        }
    }

}