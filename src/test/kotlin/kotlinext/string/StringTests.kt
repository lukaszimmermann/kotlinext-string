package kotlinext.string

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class StringTests {

    @Test
    fun ensureTrailing() {
        assertEquals("foo$", "foo$".ensureTrailing('$'))
        assertEquals("foo$", "foo".ensureTrailing('$'))
        assertEquals("#", "#".ensureTrailing('#'))
        assertEquals("#", "".ensureTrailing('#'))
    }

    @Test
    fun ensureTrailingSlash() {
        assertEquals("foo/", "foo/".ensureTrailingSlash())
        assertEquals("foo/", "foo".ensureTrailingSlash())
        assertEquals("/", "/".ensureTrailingSlash())
        assertEquals("/", "".ensureTrailingSlash())
    }

    @Test
    fun containsWhitespace() {
        assertTrue(" ".containsWhitespace())
        assertTrue(" aldjakfhi".containsWhitespace())
        assertTrue("aldj akfhi".containsWhitespace())
        assertTrue("aldjakfhi\t".containsWhitespace())
        assertFalse("".containsWhitespace())
        assertFalse("foo".containsWhitespace())
    }
}
