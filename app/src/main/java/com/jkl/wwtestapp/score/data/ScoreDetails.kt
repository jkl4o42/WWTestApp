package com.jkl.wwtestapp.score.data

interface ScoreDetails {

    interface Save {
        fun save(data: Int)
    }

    interface Read {
        fun read(): Int
    }

    interface Mutable : Save, Read

    class Base : Mutable {

        private var value = 0

        override fun save(data: Int) {
            value = data
        }

        override fun read() = value
    }
}