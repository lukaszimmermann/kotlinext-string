# kotlin-extension-string
This repository simply provides an artifact with additional String extension
functions for the Kotlin String class.

## Extension Functions

Currently, this artifact provides the following extension functions on
the String class:

Function                | Description
------------------------|-------------------------------------------------------------------------------------
`ensureTrailing(Char)`  | Ensures that the String ends with the specified Char, which is appended if necessary
`ensureTrailingSlash()` | Ensures that the String ends with the '/' Char, which is appended if necessary.
`containsWhitespace()`  | Determines whether the String contains at least one whitespace Char using Unicode standard.
