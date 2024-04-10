package org.mathieu.cleanrmapi.data.local.objects

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.mathieu.cleanrmapi.data.local.RMDatabase
import org.mathieu.cleanrmapi.data.remote.responses.EpisodeResponse
import org.mathieu.cleanrmapi.domain.models.episode.Episode

/**
 * Represents an episode entity stored in the SQLite database. This object provides fields
 * necessary to represent all the attributes of an episode from the data source.
 * The object is specifically tailored for SQLite storage using Room Persistence Library.
 *
 * @property id Unique identifier of the episode.
 * @property name Name of the episode.
 * @property airDate Air date of the episode.
 * @property episode Episode number.
 * @property url URL pointing to the episode's page.
 */
@Entity(tableName = RMDatabase.EPISODE_TABLE)
class EpisodeObject(
    @PrimaryKey
    val id: Int,
    val name : String,
    val airDate : String,
    val episode : String,
    val url : String,
)

internal fun EpisodeResponse.toRoomObject() = EpisodeObject(
    id = id,
    name = name,
    airDate = air_date,
    episode = episode,
    url = url
)

internal fun EpisodeObject.toModel() = Episode(
    id = id,
    name = name,
    airDate = airDate,
    episode = episode,
    url = url
)