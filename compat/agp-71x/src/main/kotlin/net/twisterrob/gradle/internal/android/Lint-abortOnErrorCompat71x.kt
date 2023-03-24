package net.twisterrob.gradle.internal.android

import com.android.build.api.dsl.Lint
import org.gradle.api.Incubating

@get:Incubating
@set:Incubating
@Suppress("BooleanPropertyNaming") // Following AGP's naming.
var Lint.abortOnErrorCompat71x: Boolean by Lint::abortOnError
