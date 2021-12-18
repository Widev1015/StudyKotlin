import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.temporal.ChronoUnit

class Gigasecond {
    val date: LocalDateTime

    var longSecond = 1000000000

    constructor(ld: LocalDate){
        date = LocalDateTime.of(ld, LocalTime.MIN).plus(longSecond.toLong(), ChronoUnit.SECONDS)
    }

    constructor(ldt: LocalDateTime){
        date = ldt.plus(longSecond.toLong(), ChronoUnit.SECONDS)
    }
}

