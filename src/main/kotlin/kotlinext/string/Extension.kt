package kotlinext.string

/**
 * Ensures that this [String] ends with the provided [Char].
 *
 * If this [String] already ends with the provided [Char], then the [String] is returned unaltered.
 * Otherwise, the [Char] is appended and the resulting [String] is returned.
 *
 * @param symbol The [Char] which should occur at the end of this [String].
 * @return The input [String] which is guaranteed to end with the provided [Char].
 *
 */
fun String.ensureTrailing(symbol: Char): String = if (endsWith(symbol)) this else "$this$symbol"

/**
 * Ensures that this [String] ends with the '/' [Char].
 *
 * If this [String] already ends with '/', then the [String] is returned unaltered.
 * Otherwise, '/' is appended and the resulting [String] is returned.
 *
 * @return The input [String] which is guaranteed to end with '/'.
 *
 */
fun String.ensureTrailingSlash(): String = this.ensureTrailing('/')

/**
 *  Determines whether this [String] contains any whitespace [Char] as defined by the Unicode standard.
 *
 * @return True if this [String] contains at least one whitespace character, false if not.
 */
fun String.containsWhitespace(): Boolean = this.any { it.isWhitespace() }
