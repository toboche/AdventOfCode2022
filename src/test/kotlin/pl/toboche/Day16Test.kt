package pl.toboche

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

internal class Day16Test {
    @Test
    internal fun task1Example1() {
        val input = "D2FE28"

        Assertions.assertThat(Day16().fullyParse(input))
            .isEqualTo(Packet(6, 4, 2021, null, 21))

        Assertions.assertThat(Day16().task1(input))
            .isEqualTo(6)
    }

    @Test
    internal fun task1Example2() {
        val input = "38006F45291200"

        Assertions.assertThat(Day16().fullyParse(input))
            .isEqualTo(Packet(1, 6, null, listOf(
                Packet(6, 4, 10, null, 33),
                Packet(2, 4, 20, null, 49),
            ), 49))
        Assertions.assertThat(Day16().task1(input))
            .isEqualTo(9)
    }

    @Test
    internal fun task1Example3() {
        val input = "EE00D40C823060"

        Assertions.assertThat(Day16().fullyParse(input))
            .isEqualTo(Packet(7, 3, null, listOf(
                Packet(2, 4, 1, null, 29),
                Packet(4, 4, 2, null, 40),
                Packet(1, 4, 3, null, 51),
            ), 51))
        Assertions.assertThat(Day16().task1(input))
            .isEqualTo(14)
    }

    @Test
    internal fun task1Example4() {
        val input = "8A004A801A8002F478"

        Assertions.assertThat(
            Day16().task1(input)).isEqualTo(16)
    }

    @Test
    internal fun task1Example5() {
        val input = "620080001611562C8802118E34"

        Assertions.assertThat(
            Day16().task1(input)).isEqualTo(12)
    }

    @Test
    internal fun task1Example6() {
        val input = "C0015000016115A2E0802F182340"

        Assertions.assertThat(
            Day16().task1(input)).isEqualTo(23)
    }

    @Test
    internal fun task1Example7() {
        val input = "A0016C880162017C3686B18A3D4780"

        Assertions.assertThat(
            Day16().task1(input)).isEqualTo(31)
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day16.txt").readLines().first()

        Assertions.assertThat(
            Day16().task1(input)).isEqualTo(953)
    }

    @Test
    internal fun task2Sum() {
        val input = "C200B40A82"

        Assertions.assertThat(
            Day16().task2(input)).isEqualTo(3)
    }

    @Test
    internal fun task2Product() {
        val input = "04005AC33890"

        Assertions.assertThat(
            Day16().task2(input)).isEqualTo(54)
    }

    @Test
    internal fun task2Min() {
        val input = "880086C3E88112"

        Assertions.assertThat(
            Day16().task2(input)).isEqualTo(7)
    }

    @Test
    internal fun task2Max() {
        val input = "CE00C43D881120"

        Assertions.assertThat(
            Day16().task2(input)).isEqualTo(9)
    }
}