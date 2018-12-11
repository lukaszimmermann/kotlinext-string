package kotlinext.string

/**
 * Ensures that this [String] ends with the provided [Char].
 *
 * If this [String] already ends with the provided [Char], then the [String] is returned unaltered.
 * Otherwise, the [Char] is appended and the resulting [String] is returned.
 *
 * @param char The [Char] which should occur at the end of this [String].
 * @return The input [String] which is guaranteed to end with the provided [Char].
 *
 */
fun String.ensureTrailing(char: Char): String = if (endsWith(char)) this else "$this$char"

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
fun String.containsWhitespace(): Boolean = this.any { it.isWhitespace() ; }

/**
 * Determines whether the [String] starts and endswith with the specified [Char]
 *
 * @param char The [Char] to check
 * @return Whether the [String] starts and ends withs the specified character
 */
fun String.startsAndEndsWith(char: Char): Boolean = startsWith(char) && endsWith(char)

/**
 * Ensures that the [String] is double-quoted. Returns the [String] unaltered if it is already quoted
 *
 * @return The [String] double-quoted
 */
fun String.ensureDoubleQuoted(): String =
        if (startsAndEndsWith(DOUBLE_QUOTE) && length > 1) this else "$DOUBLE_QUOTE$this$DOUBLE_QUOTE"

/**
 * Ensures that the [String] is single-quoted. Returns the [String] unaltered if it is already quoted
 *
 * @return The [String] single-quoted
 */
fun String.ensureSingleQuoted(): String =
        if (startsAndEndsWith(SINGLE_QUOTE) && length > 1) this else "$SINGLE_QUOTE$this$SINGLE_QUOTE"

private const val DOUBLE_QUOTE = '"'
private const val SINGLE_QUOTE = '\''
