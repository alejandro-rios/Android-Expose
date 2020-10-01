package com.alejandrorios.expose.utils

import kotlin.coroutines.CoroutineContext

/**
 * @author alejandrorios on 8/15/20
 */
data class CoroutinesContextProvider(
    val mainContext: CoroutineContext,
    val backgroundContext: CoroutineContext
)
