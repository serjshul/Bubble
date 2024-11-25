package com.serjshul.bubble.data.model.subcollections

data class Type (
    val id: String? = null,

    var value: String? = null
    // TODO: val counter: Int? = null,
) {
    @Override
    override fun toString(): String {
        return this.value.toString()
    }
}