package com.serjshul.bubble.model.collections

data class Tag (
    val id: String? = null,

    val type: String? = null,
    val value: String? = null,
) {
    @Override
    override fun toString(): String {
        return this.value.toString()
    }
}