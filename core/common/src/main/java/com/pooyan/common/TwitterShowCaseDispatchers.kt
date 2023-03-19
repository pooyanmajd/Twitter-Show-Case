package com.pooyan.common

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val twitterShowCaseDispatchers: TwitterShowCaseDispatchers)

enum class TwitterShowCaseDispatchers {
    IO
}
