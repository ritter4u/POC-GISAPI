package io.github.ritter4u.POCGISAPI.util

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import org.locationtech.jts.geom.Point
import java.io.IOException

class PointToJsonSerializer : JsonSerializer<Point?>() {
    @Throws(IOException::class, JsonProcessingException::class)
    override fun serialize(
        value: Point?, jgen: JsonGenerator,
        provider: SerializerProvider,
    ) {
        var jsonValue = "null"
        try {
            if (value != null) {
                val lat = value.y
                val lon = value.x
                jsonValue = String.format("POINT (%s %s)", lat, lon)
            }
        } catch (e: Exception) {
        }
        jgen.writeString(jsonValue)
    }
}