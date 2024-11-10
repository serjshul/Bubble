package com.serjshul.bubble.model.subcollections

data class Tag (
    val id: String? = null,

    val typeId: String? = null,
    var value: String? = null,
) {
    @Override
    override fun toString(): String {
        return this.value.toString()
    }
}