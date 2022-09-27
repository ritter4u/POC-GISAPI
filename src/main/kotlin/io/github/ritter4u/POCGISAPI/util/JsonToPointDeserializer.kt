package io.github.ritter4u.POCGISAPI.util

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.GeometryFactory
import org.locationtech.jts.geom.Point
import org.locationtech.jts.geom.PrecisionModel
import java.io.IOException

class JsonToPointDeserializer : JsonDeserializer<Point?>() {
    @Throws(IOException::class, JsonProcessingException::class)
    override fun deserialize(jp: JsonParser, ctxt: DeserializationContext): Point? {
        return try {
            val text = jp.text
            if (text == null || text.length <= 0) return null
            val coordinates =
                text.replaceFirst("POINT ?\\(".toRegex(), "").replaceFirst("\\)".toRegex(), "").split(" ".toRegex())
                    .dropLastWhile { it.isEmpty() }.toTypedArray()
            val lat = coordinates[0].toDouble()
            val lon = coordinates[1].toDouble()
            geometryFactory.createPoint(Coordinate(lat, lon))
        } catch (e: Exception) {
            null
        }
    }

    companion object {
        private val geometryFactory = GeometryFactory(PrecisionModel(), 26910)
    }
}