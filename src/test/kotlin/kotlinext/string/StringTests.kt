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

    @Test
    fun startsAndEndsWith() {
        assertTrue(".skhf.".startsAndEndsWith('.'))
        assertTrue(".".startsAndEndsWith('.'))
        assertTrue("__".startsAndEndsWith('_'))
        assertTrue(" adaf ".startsAndEndsWith(' '))
        assertFalse("alfhasf".startsAndEndsWith('_'))
        assertFalse(".sfsg".startsAndEndsWith('.'))
        assertFalse("".startsAndEndsWith('g'))
    }

    @Test
    fun ensureDoubleQuoted() {
        assertEquals("\"slkjfsof\"", "slkjfsof".ensureDoubleQuoted())
        assertEquals("\"slkjfsof\"", "\"slkjfsof\"".ensureDoubleQuoted())
        assertEquals("\"\"", "\"\"".ensureDoubleQuoted())
        assertEquals("\"\"", "".ensureDoubleQuoted())
        assertEquals("\"\"\"", "\"".ensureDoubleQuoted())
        assertEquals("\"jhhgjhj\"\"", "jhhgjhj\"".ensureDoubleQuoted())
    }

    @Test
    fun ensureSingleQuoted() {
        assertEquals("'slkjfsof'", "slkjfsof".ensureSingleQuoted())
        assertEquals("'slkjfsof'", "'slkjfsof'".ensureSingleQuoted())
        assertEquals("''", "''".ensureSingleQuoted())
        assertEquals("''", "".ensureSingleQuoted())
        assertEquals("'''", "'".ensureSingleQuoted())
        assertEquals("'jhhgjhj''", "jhhgjhj'".ensureSingleQuoted())
    }
}
