package com.djvmil.entretienmentor.core.data.source.database

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.djvmil.entretienmentor.EMDatabaseSource

object FakeDatabaseModule {

    fun provideInMemoryDatabaseInstance(): EMDatabaseSource {
        // Some tests may fail complaining that sqlite-jdbc jar isn't on the classpath whilst it is already on the classpath.
        // so, this line fixes it until we find a better solution or better understand the root cause exactly.
        Class.forName("org.sqlite.JDBC")

        val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        EMDatabaseSource.Schema.create(driver)

        return EMDatabaseSource(
            driver,
            /*currentlyPlayingEntityAdapter = CurrentlyPlayingEntity.Adapter(EnumColumnAdapter(), FloatColumnAdapter),
            downloadableEpisodeEntityAdapter = DownloadableEpisodeEntity.Adapter(EnumColumnAdapter(), FloatColumnAdapter),
            episodeEntityAdapter = EpisodeEntity.Adapter(
                durationInSecAdapter = IntColumnAdapter,
                episodeNumAdapter = IntColumnAdapter,
                progressInSecAdapter = IntColumnAdapter,
            ),
            podcastEntityAdapter = PodcastEntity.Adapter(
                episodeCountAdapter = IntColumnAdapter,
                genresAdapter = GenresColumnAdapter,
            ),*/
        )
    }
}
