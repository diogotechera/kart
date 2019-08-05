package reader.kart.builder

import reader.kart.domain.FileLine
import reader.kart.exception.InvalidLineException
import java.text.NumberFormat
import java.text.ParseException
import java.time.DateTimeException
import java.time.LocalTime
import java.util.Locale

object LineBuilder {

    fun build(line: String): FileLine {

        val lineValues = splitLineValues(line)

        val racerInformation = extractRacerInformation(lineValues)
        val racerCode = racerInformation[0]
        val racerNumber = racerInformation[1]

        return FileLine(extractTime(lineValues),
                racerCode, racerNumber,
                extractLapNumber(lineValues),
                extractLapTime(lineValues),
                extractAverageSpeed(lineValues))

    }

    private fun splitLineValues(line: String): List<String> {
        val lineValues = line.split(Regex("[ \\t]{2,}"))
        if (lineValues.size != 5)
            throw InvalidLineException("Invalid line values: ${lineValues.size}")
        return lineValues
    }

    private fun extractLapNumber(lineValues: List<String>): Int {
        try {
            return lineValues[2].toInt()
        }catch(e : NumberFormatException){
            throw InvalidLineException("Invalid lap number: ${lineValues[2]}")
        }
    }

    private fun extractAverageSpeed(lineValues: List<String>): Double {
        try {
            return NumberFormat.getInstance(Locale("pt", "BR"))
                    .parse(lineValues[4]).toDouble()
        } catch(e: ParseException){
            throw InvalidLineException("Invalid average speed: ${lineValues[4]}")
        }
    }

    private fun extractRacerInformation(lineValues: List<String>): List<String> {
        val racerInformation = lineValues[1].split(" – ")
        if (racerInformation.size != 2)
            throw InvalidLineException("Invalid racer information values: ${lineValues[1]}")
        return racerInformation
    }

    private fun extractLapTime(lineValues: List<String>): LocalTime {
        val lapTimeLine = lineValues[3].split(":")
        if (lapTimeLine.size != 2)
            throw InvalidLineException("Invalid lap time format: ${lineValues[3]}")

        val seconds = lapTimeLine[1].split(".")
        if (seconds.size != 2)
            throw InvalidLineException("Invalid lap time format: ${lineValues[3]}")

        try{
            return LocalTime.now().withHour(0)
                    .withMinute(lapTimeLine[0].toInt())
                    .withSecond(seconds[0].toInt())
                    .withNano(seconds[1].padEnd(9, '0').toInt())

        }catch (e : DateTimeException){
            throw InvalidLineException("Invalid lap time value: ${lineValues[3]}")
        }
    }

    private fun extractTime(lineValues: List<String>): LocalTime {
        try{
            return LocalTime.parse(lineValues[0])
        }catch (e : DateTimeException){
            throw InvalidLineException("Invalid time: ${lineValues[0]}")
        }
    }

}
