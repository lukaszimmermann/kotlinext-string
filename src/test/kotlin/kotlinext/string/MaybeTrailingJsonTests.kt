package kotlinext.string

import kotlin.test.Test
import kotlin.test.assertEquals

class MaybeTrailingJsonTests {

    /*
     * Test cases of Strings containing JSON values that we want to extract.
     */
    private val testCases = mapOf(
            """{}""" to """{}""",
            """{"foo": 1}""" to """{"foo":1}""",
            """{"foo": true}""" to """{"foo":true}""",
            """{"foo": null}""" to """{"foo":null}""",
            """{"foo":""}""" to """{"foo":""}""",
            """{"foo":"bar"}""" to """{"foo":"bar"}""",
            """{"foo":"b\"ar"}""" to """{"foo":"b\"ar"}""",
            """{"foo":"b{}ar"}""" to """{"foo":"b{}ar"}""",
            """{"foo": [ 1,2,3]}""" to """{"foo":[1,2,3]}""",
            """{"foo":{"bar": ""}}""" to """{"foo":{"bar":""}}""",
            """{"foo":{"bar": "jfsjf{lfskhfkd}"}}""" to """{"foo":{"bar":"jfsjf{lfskhfkd}"}}""",
            """{"foo":{"bar": "jf\"sjf{lfskhfkd}\"ljfsdf"}}""" to """{"foo":{"bar":"jf\"sjf{lfskhfkd}\"ljfsdf"}}"""
            )

    /*
     * Just some random Noise Strings. These are not allowed to contain the '}' character
     */
    private val noiseStrings = listOf(
            "lafkshf",
            "",
            "sfsfsfsf"
    )

    private val noiseWithCriticalChars = listOf(
            "{sfsf}"
    )

    // We append the keys of the test cases to the start noise, since any String is (also valid JSON)
    // is allowed to preceed the JSON that we want to extract
    private val startNoises = noiseStrings + testCases.keys.toList() + noiseWithCriticalChars

    // The end Noise is not allows to contain Critial Characters
    private val endNoises = noiseStrings

    /*
     * maybeTrailingJson 1: Test valid JSON objects
     */
    @Test
    fun `check testCases without noise`() {
        testCases.forEach { (test, expect) ->
            assertEquals(expect, test.maybeTrailingJson())
        }
    }

    @Test
    fun `check test Cases with start noise`() {
        testCases.forEach { (test, expect) ->
            startNoises.forEach { noise ->
                assertEquals(expect, (noise + test).maybeTrailingJson())
            }
        }
    }

    @Test
    fun `check test Cases with end noise`() {
        testCases.forEach { (test, expect) ->
            endNoises.forEach { noise ->
                assertEquals(expect, (test + noise).maybeTrailingJson())
            }
        }
    }

    @Test
    fun `check test Cases with start and end noise`() {
        testCases.forEach { (test, expect) ->
            startNoises.forEach { startNoise ->
                endNoises.forEach { endNoise ->
                    assertEquals(expect, (startNoise + test + endNoise).maybeTrailingJson())
                }
            }
        }
    }

    @Test
    fun `check unclosed braces`() {
        assertEquals("}}}}}}}", "}}}}}}}".maybeTrailingJson())
        assertEquals("{}}}}}}}", "{}}}}}}}".maybeTrailingJson())
        assertEquals("{{}}}}}}}", "{{}}}}}}}".maybeTrailingJson())
        assertEquals("{{{}}}}}}}", "{{{}}}}}}}".maybeTrailingJson())
        assertEquals("{{{{}}}}}}}", "{{{{}}}}}}}".maybeTrailingJson())
        assertEquals("{{{{{}}}}}}}", "{{{{{}}}}}}}".maybeTrailingJson())
        assertEquals("{{{{{{}}}}}}}", "{{{{{{}}}}}}}".maybeTrailingJson())
        assertEquals("{{{{{{{}}}}}}}", "{{{{{{{}}}}}}}".maybeTrailingJson())
    }

    @Test
    fun `check that additional closing braces will be closed`() {
        assertEquals("{}", "{}".maybeTrailingJson())
        assertEquals("{}", "{{}".maybeTrailingJson())
        assertEquals("{}", "{{{}".maybeTrailingJson())
        assertEquals("{}", "{ {{{}".maybeTrailingJson())
    }
}
