package com.djvmil.entretienmentor.core.data.source.datastore.model

enum class StepsStarting {
    NONE,
    ON_BOARDING,
    ON_HOME_USER;
    companion object {
        fun default(): StepsStarting {
            return NONE
        }
    }
}

