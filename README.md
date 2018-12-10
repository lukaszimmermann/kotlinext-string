[![Build Status](https://travis-ci.org/lukaszimmermann/kotlinext-string.svg?branch=master)](https://travis-ci.org/lukaszimmermann/kotlinext-string)
[![codecov](https://codecov.io/gh/lukaszimmermann/kotlinext-string/branch/develop/graph/badge.svg)](https://codecov.io/gh/lukaszimmermann/kotlinext-string)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/d764b4806c7e494e84db0eac1e7cc477)](https://www.codacy.com/app/lukaszimmermann/kotlinext-string?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=lukaszimmermann/kotlinext-string&amp;utm_campaign=Badge_Grade)
[![Download](https://api.bintray.com/packages/lukaszimmermann/lukaszimmermann/kotlinext-string/images/download.svg) ](https://bintray.com/lukaszimmermann/lukaszimmermann/kotlinext-string/_latestVersion)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)



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

## Install

### Gradle
Add the following lines to your `build.gradle`

```
repositories {
    maven {
        url "https://dl.bintray.com/lukaszimmermann/lukaszimmermann"
    }
}

dependencies {
    implementation group: 'kotlinext', name: 'string', version: '3.0'
}
```

This will add the required Bintray repository and the dependency
on this artifact.

