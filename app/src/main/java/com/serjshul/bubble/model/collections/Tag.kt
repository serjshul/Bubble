package com.serjshul.bubble.model.collections

data class Tag (
    val tid: String? = null,

    val type: String? = null,
    val value: String? = null,
) {
    @Override
    override fun toString(): String {
        return this.value.toString()
    }
}