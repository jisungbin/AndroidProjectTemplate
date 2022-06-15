package team.applemango.runnerbe.shared.domain.unit

@JvmInline
value class Em(val value: Float) {
    // The adding of 0.5 is used to round UP to the nearest integer value.
    fun toInt() = (value + 0.5f).toInt()
}
