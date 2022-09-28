package io.github.ritter4u.POCGISAPI.util

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import org.locationtech.jts.geom.*
import java.io.IOException

//package com.bedatadriven.geojson;

class GeometryDeserializer : JsonDeserializer<Geometry>() {
    private val gf = GeometryFactory()

    @Throws(IOException::class, JsonProcessingException::class)
    override fun deserialize(jp: JsonParser, ctxt: DeserializationContext): Geometry {
        val oc = jp.codec
        val root = oc.readTree<JsonNode>(jp)
        return parseGeometry(root)
    }

    private fun parseGeometry(root: JsonNode): Geometry {
        val typeName = root["type"].asText()
        return if (typeName == "Point") {
            gf.createPoint(parseCoordinate(root["coordinates"]))
        } else if (typeName == "MultiPoint") {
            gf.createMultiPoint(parseLineString(root["coordinates"]))
        } else if (typeName == "LineString") {
            gf.createLineString(parseLineString(root["coordinates"]))
        } else if (typeName == "MultiLineString") {
            gf.createMultiLineString(parseLineStrings(root["coordinates"]))
        } else if (typeName == "Polygon") {
            val arrayOfRings = root["coordinates"]
            parsePolygonCoordinates(arrayOfRings)
        } else if (typeName == "MultiPolygon") {
            val arrayOfPolygons = root["coordinates"]
            gf.createMultiPolygon(parsePolygons(arrayOfPolygons))
        } else if (typeName == "GeometryCollection") {
            gf.createGeometryCollection(
                parseGeometries(
                    root["geometries"]
                )
            )
        } else {
            throw UnsupportedOperationException()
        }
    }

    private fun parseGeometries(arrayOfGeoms: JsonNode): Array<Geometry?> {
        val items = arrayOfNulls<Geometry>(arrayOfGeoms.size())
        for (i in 0 until arrayOfGeoms.size()) {
            items[i] = parseGeometry(arrayOfGeoms[i])
        }
        return items
    }

    private fun parsePolygonCoordinates(arrayOfRings: JsonNode): Polygon {
        return gf.createPolygon(
            parseExteriorRing(arrayOfRings),
            parseInteriorRings(arrayOfRings)
        )
    }

    private fun parsePolygons(arrayOfPolygons: JsonNode): Array<Polygon?> {
        val polygons = arrayOfNulls<Polygon>(arrayOfPolygons.size())
        for (i in 0 until arrayOfPolygons.size()) {
            polygons[i] = parsePolygonCoordinates(arrayOfPolygons[i])
        }
        return polygons
    }

    private fun parseExteriorRing(arrayOfRings: JsonNode): LinearRing {
        return gf.createLinearRing(parseLineString(arrayOfRings[0]))
    }

    private fun parseInteriorRings(arrayOfRings: JsonNode): Array<LinearRing?> {
        val rings = arrayOfNulls<LinearRing>(arrayOfRings.size() - 1)
        for (i in 1 until arrayOfRings.size()) {
            rings[i - 1] = gf.createLinearRing(parseLineString(arrayOfRings[i]))
        }
        return rings
    }

    private fun parseCoordinate(array: JsonNode): Coordinate {
        return Coordinate(array[0].asDouble(), array[1].asDouble())
    }

    private fun parseLineString(array: JsonNode): Array<Coordinate?> {
        val points = arrayOfNulls<Coordinate>(array.size())
        for (i in 0 until array.size()) {
            points[i] = parseCoordinate(array[i])
        }
        return points
    }

    private fun parseLineStrings(array: JsonNode): Array<LineString?> {
        val strings = arrayOfNulls<LineString>(array.size())
        for (i in 0 until array.size()) {
            strings[i] = gf.createLineString(parseLineString(array[i]))
        }
        return strings
    }
}