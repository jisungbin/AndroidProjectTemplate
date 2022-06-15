package team.applemango.runnerbe.shared.domain.extension

fun String.convertNullableString() = if (this == "null") null else this
