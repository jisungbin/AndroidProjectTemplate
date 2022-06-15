package team.applemango.runnerbe.shared.domain.extension

import team.applemango.runnerbe.shared.domain.util.notAllowedValueMessage

fun Int.toBoolean() = when (this) {
    0 -> false
    1 -> true
    else -> throw IllegalStateException(notAllowedValueMessage(this))
}
