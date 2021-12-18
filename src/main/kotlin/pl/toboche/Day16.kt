package pl.toboche

class Day16 {
    val hexMappings = mapOf(
        '0' to "0000",
        '1' to "0001",
        '2' to "0010",
        '3' to "0011",
        '4' to "0100",
        '5' to "0101",
        '6' to "0110",
        '7' to "0111",
        '8' to "1000",
        '9' to "1001",
        'A' to "1010",
        'B' to "1011",
        'C' to "1100",
        'D' to "1101",
        'E' to "1110",
        'F' to "1111",
    )

    private var bits = ""

    fun task1(input: String): Int {
        bits = input.map { hexMappings[it]!! }.joinToString("")
        val root = parseSinglePacket(0)
        return sumRec(root)
    }

    fun task2(input: String): Long {
        bits = input.map { hexMappings[it]!! }.joinToString("")
        val root = parseSinglePacket(0)
        return execute(root)
    }

    private fun execute(packet: Packet): Long {
        return when (packet.type) {
            4 -> packet.value!!
            0 -> packet.packets!!.sumOf { execute(it) }
            1 -> packet.packets!!.fold(1) { acc, packet -> acc * execute(packet) }
            2 -> packet.packets!!.minOf { execute(it) }
            3 -> packet.packets!!.maxOf { execute(it) }
            5 -> if (execute(packet.packets!![0]) > execute(packet.packets[1])) 1 else 0
            6 -> if (execute(packet.packets!![0]) < execute(packet.packets[1])) 1 else 0
            7 -> if (execute(packet.packets!![0]) == execute(packet.packets[1])) 1 else 0
            else -> throw Exception()
        }
    }

    private fun sumRec(root: Packet): Int {
        return root.version + ((root.packets?.map { sumRec(it) })?.sum()
            ?: 0)
    }

    fun fullyParse(input: String): Packet {
        bits = input.map { hexMappings[it]!! }.joinToString("")
        return parseSinglePacket(0)
    }

    data class BasicInfo(
        val version: Int,
        val type: Int,
        val packetContentStatIndex: Int,
        val mode: Char,
    ) {
        companion object {
            fun parse(
                bits: String,
                packetStart: Int,
            ): BasicInfo {
                val version = bits.substring(packetStart, packetStart + 3).toInt(2)
                val type = bits.subSequence(packetStart + 3, packetStart + 6).toString().toInt(2)
                val packetContentStartIndex = packetStart + 6
                val mode = bits[packetStart + 6]
                return BasicInfo(
                    version,
                    type,
                    packetContentStartIndex,
                    mode
                )
            }
        }
    }

    private fun parseSinglePacket(packetStart: Int): Packet {
        val (
            version,
            type,
            packetContentStartIndex,
            mode,
        ) =
            BasicInfo.parse(
                bits,
                packetStart
            )
        return if (type == 4) {
            parseValue(packetContentStartIndex, version, type)
        } else if (mode == '0') {
            val totalLengthOfBitsInSubpackets =
                bits.subSequence(packetContentStartIndex + 1, packetContentStartIndex + 16).toString().toInt(2)
            val subpackets: List<Packet> = parseSupacketsByLegthOfBits(packetContentStartIndex + 16,
                totalLengthOfBitsInSubpackets)
            Packet(version, type, null, subpackets, subpackets.last().endIndex)
        } else if (mode == '1') {
            val numberOfSubpackets =
                bits.subSequence(packetContentStartIndex + 1, packetContentStartIndex + 12).toString().toInt(2)
            val subpackets: List<Packet> = parseSupacketsByCount(numberOfSubpackets, packetContentStartIndex + 12)
            Packet(version, type, null, subpackets, subpackets.last().endIndex)
        } else {
            throw Exception()
        }
    }

    private fun parseSupacketsByCount(
        numberOfSubpackets: Int,
        packetContentStartIndex: Int,
    ): List<Packet> {
        val packets = mutableListOf<Packet>()
        repeat(numberOfSubpackets) {
            val previousEndIndex = packets.lastOrNull()?.endIndex ?: packetContentStartIndex
            packets.add(parseSinglePacket(previousEndIndex))
        }
        return packets
    }

    private fun parseSupacketsByLegthOfBits(
        packetContentStartIndex: Int,
        totalLengthOfBitsInSubpackets: Int,
    ): List<Packet> {
        var totalIndices = 0
        val packets = mutableListOf<Packet>()
        while ((packets.lastOrNull()?.endIndex ?: 0) != totalLengthOfBitsInSubpackets + packetContentStartIndex) {
            packets.add(parseSinglePacket(packets.lastOrNull()?.endIndex ?: packetContentStartIndex))
            totalIndices += packets.last().endIndex - packetContentStartIndex
        }
        return packets
    }

    private fun parseValue(
        packetContentStartIndex: Int,
        version: Int,
        type: Int,
    ): Packet {
        val packetContent = bits.drop(packetContentStartIndex)
        val windowedValue = packetContent.windowed(5, 5)
        val lastByteIndex = windowedValue.indexOfFirst { it[0] == '0' }
        val value = windowedValue.take(lastByteIndex + 1).joinToString("") { it.drop(1) }
            .toLong(2)
        val endIndex = packetContentStartIndex + (lastByteIndex + 1) * 5
        return Packet(
            version,
            type,
            value,
            null,
            endIndex
        )
    }

}

data class Packet(
    val version: Int,
    val type: Int,
    val value: Long?,
    val packets: List<Packet>?,
    val endIndex: Int,
)

