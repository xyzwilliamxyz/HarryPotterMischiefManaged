package org.hogwarts.harrypotter.core

import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.getString

class StringProvider {
    suspend fun resolveString(resource: StringResource, vararg formatArgs: Any): String {
        return getString(resource, *formatArgs)
    }
}
