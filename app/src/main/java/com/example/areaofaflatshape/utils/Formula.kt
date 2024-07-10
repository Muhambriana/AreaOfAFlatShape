package com.example.areaofaflatshape.utils

object Formula {
    fun getAreaOfCircle(radius: Double?): Double {
        // If radius equals null, than return 0.0
        if (radius == null) return 0.0
        // If radius isn't null. Than calculate with formula
        return 3.14 * (radius * radius)
    }

    fun getAreaOfRectangle(width: Double?, length: Double?): Double {
        // If width equals null, than return 0.0
        if (width == null) return 0.0
        if (length == null) return 0.0

        return width * length
    }

    fun getAreaOfSquare(side: Double?): Double {
        if (side == null) return 0.0
        return side * side
    }

    fun getAreaOfTriangle(base: Double?, height: Double?): Double {
        if (base == null) return 0.0
        if (height == null) return 0.0

        return (base * height) / 2
    }
}