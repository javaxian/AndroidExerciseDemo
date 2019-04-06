package com.javaxian.applications.buildingservicesapp.data.repository.mapper

import java.util.AbstractList
import java.util.ArrayList

abstract class Mapper<T1, T2> {

    abstract fun map(value: T1): T2

    abstract fun reverseMap(value: T2): T1

    fun map(values: AbstractList<T1>?): ArrayList<T2> {
        val returnValues = ArrayList<T2>()
        if (values == null)
            return returnValues

        for (value in values)
            returnValues.add(map(value))

        return returnValues
    }

    fun reverseMap(values: ArrayList<T2>?): AbstractList<T1> {
        val returnValues = ArrayList<T1>()
        if (values == null)
            return returnValues

        for (value in values)
            returnValues.add(reverseMap(value))

        return returnValues
    }
}