package io.github.ritter4u.POCGISAPI.util

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.core.JsonGenerationException
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import org.locationtech.jts.geom.*
import java.io.IOException

//package com.bedatadriven.geojson;

class GeometrySerializer : JsonSerializer<Geometry>() {
    @Throws(IOException::class, JsonProcessingException::class)
    override fun serialize(
        value: Geometry, jgen: JsonGenerator,
        provider: SerializerProvider
    ) {
        writeGeometry(jgen, value)
    }

    @Throws(JsonGenerationException::class, IOException::class)
    fun writeGeometry(jgen: JsonGenerator, value: Geometry) {
        if (value is Polygon) {
            writePolygon(jgen, value)
        } else if (value is Point) {
            writePoint(jgen, value)
        } else if (value is MultiPoint) {
            writeMultiPoint(jgen, value)
        } else if (value is MultiPolygon) {
            writeMultiPolygon(jgen, value)
        } else if (value is LineString) {
            writeLineString(jgen, value)
        } else if (value is MultiLineString) {
            writeMultiLineString(jgen, value)
        } else if (value is GeometryCollection) {
            writeGeometryCollection(jgen, value)
        } else {
            throw UnsupportedOperationException(
                "not implemented: "
                        + value.javaClass.name
            )
        }
    }

    @Throws(JsonGenerationException::class, IOException::class)
    private fun writeGeometryCollection(
        jgen: JsonGenerator,
        value: GeometryCollection
    ) {
        jgen.writeStartObject()
        jgen.writeStringField("type", "GeometryCollection")
        jgen.writeArrayFieldStart("geometries")
        for (i in 0 until value.numGeometries) {
            writeGeometry(jgen, value.getGeometryN(i))
        }
        jgen.writeEndArray()
        jgen.writeEndObject()
    }

    @Throws(JsonGenerationException::class, IOException::class)
    private fun writeMultiPoint(jgen: JsonGenerator, value: MultiPoint) {
        jgen.writeStartObject()
        jgen.writeStringField("type", "MultiPoint")
        jgen.writeArrayFieldStart("coordinates")
        for (i in 0 until value.numGeometries) {
            writePointCoords(jgen, value.getGeometryN(i) as Point)
        }
        jgen.writeEndArray()
        jgen.writeEndObject()
    }

    @Throws(JsonGenerationException::class, IOException::class)
    private fun writeMultiLineString(jgen: JsonGenerator, value: MultiLineString) {
        jgen.writeStartObject()
        jgen.writeStringField("type", "MultiLineString")
        jgen.writeArrayFieldStart("coordinates")
        for (i in 0 until value.numGeometries) {
            writeLineStringCoords(jgen, value.getGeometryN(i) as LineString)
        }
        jgen.writeEndArray()
        jgen.writeEndObject()
    }

    override fun handledType(): Class<Geometry> {
        return Geometry::class.java
    }

    @Throws(JsonGenerationException::class, IOException::class)
    private fun writeMultiPolygon(jgen: JsonGenerator, value: MultiPolygon) {
        jgen.writeStartObject()
        jgen.writeStringField("type", "MultiPolygon")
        jgen.writeArrayFieldStart("coordinates")
        for (i in 0 until value.numGeometries) {
            writePolygonCoordinates(jgen, value.getGeometryN(i) as Polygon)
        }
        jgen.writeEndArray()
        jgen.writeEndObject()
    }

    @Throws(JsonGenerationException::class, IOException::class)
    private fun writePolygon(jgen: JsonGenerator, value: Polygon) {
        jgen.writeStartObject()
        jgen.writeStringField("type", "Polygon")
        jgen.writeFieldName("coordinates")
        writePolygonCoordinates(jgen, value)
        jgen.writeEndObject()
    }

    @Throws(IOException::class, JsonGenerationException::class)
    private fun writePolygonCoordinates(jgen: JsonGenerator, value: Polygon) {
        jgen.writeStartArray()
        writeLineStringCoords(jgen, value.exteriorRing)
        for (i in 0 until value.numInteriorRing) {
            writeLineStringCoords(jgen, value.getInteriorRingN(i))
        }
        jgen.writeEndArray()
    }

    @Throws(JsonGenerationException::class, IOException::class)
    private fun writeLineStringCoords(jgen: JsonGenerator, ring: LineString) {
        jgen.writeStartArray()
        for (i in 0 until ring.numPoints) {
            val p = ring.getPointN(i)
            writePointCoords(jgen, p)
        }
        jgen.writeEndArray()
    }

    @Throws(JsonGenerationException::class, IOException::class)
    private fun writeLineString(jgen: JsonGenerator, lineString: LineString) {
        jgen.writeStartObject()
        jgen.writeStringField("type", "LineString")
        jgen.writeFieldName("coordinates")
        writeLineStringCoords(jgen, lineString)
        jgen.writeEndObject()
    }

    @Throws(JsonGenerationException::class, IOException::class)
    private fun writePoint(jgen: JsonGenerator, p: Point) {
        jgen.writeStartObject()
        jgen.writeStringField("type", "Point")
        jgen.writeFieldName("coordinates")
        writePointCoords(jgen, p)
        jgen.writeEndObject()
    }

    @Throws(IOException::class, JsonGenerationException::class)
    private fun writePointCoords(jgen: JsonGenerator, p: Point) {
        jgen.writeStartArray()
        jgen.writeNumber(p.x)
        jgen.writeNumber(p.y)
        jgen.writeEndArray()
    }
}