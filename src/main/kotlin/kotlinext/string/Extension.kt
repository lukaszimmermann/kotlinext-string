package kotlinext.string

import java.text.CharacterIterator
import java.text.StringCharacterIterator

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

/**
 * Returns the suffix of the trimmed version of this [String] that represent a valid JSON object.
 * If none such suffix exists in the [String], return garbage.
 *
 * The behavior of this function depends on whether one suffix of the [String] is a valid JSON object. If so,
 * this suffix is unambiguous and returned from this function. If not, the function will return an arbitrary [String],
 * which would need to be checked separately whether it is actually JSON. This function does not know this.
 *
 */
fun String.maybeTrailingJson(): String = buildString {
    val characterIterator = StringCharacterIterator(this@maybeTrailingJson)
    var c = characterIterator.last()
    var braceCount = 0
    var inString = false
    var start = true

    // Read String either as long as we have not fully parsed the JSON or we read the beginning of the String
    while ((braceCount > 0 || start) && c != CharacterIterator.DONE) {
        // We do not collect whitespace
        if (! c.isWhitespace()) {
            // Unescaped Double Quote changes the inString status
            if (c == DOUBLE_QUOTE) {
                if (characterIterator.previous() != BACKSLASH) {
                    inString = !inString
                }
                characterIterator.next()
            } else if (!inString && c == RIGHT_BRACE) {
                start = false
                braceCount++
            } else if (!inString && c == LEFT_BRACE) {
                braceCount--
            }
            if (!start) {
                append(c)
            }
        }
        c = characterIterator.previous()
    }
}.reversed()

// Character Tokens that we care about
private const val DOUBLE_QUOTE = '"'
private const val SINGLE_QUOTE = '\''
private const val RIGHT_BRACE = '}'
private const val LEFT_BRACE = '{'
private const val BACKSLASH = '\\'
