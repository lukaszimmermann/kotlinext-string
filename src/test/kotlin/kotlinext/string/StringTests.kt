package kotlinext.string

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

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
