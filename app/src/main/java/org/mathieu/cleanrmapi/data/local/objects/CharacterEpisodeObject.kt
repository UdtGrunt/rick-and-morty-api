package org.mathieu.cleanrmapi.data.local.objects

import androidx.room.Entity
import androidx.room.ForeignKey
import org.mathieu.cleanrmapi.data.local.RMDatabase

/**
 * Represents a many-to-many relationship between CharacterObject and EpisodeObject.
 * Each instance of this class represents an association of a character with an episode.
 * This class is used with Room Persistence Library to define a table in the SQLite database.
 *
 * @property characterId Unique identifier of the character.
 * @property episodeId Unique identifier of the episode.
 */
@Entity(
    tableName = RMDatabase.CHARACTER_EPISODE_TABLE,
    primaryKeys = ["characterId", "episodeId"],
    foreignKeys = [
        ForeignKey(
            entity = CharacterObject::class,
            parentColumns = ["id"],
            childColumns = ["characterId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = EpisodeObject::class,
            parentColumns = ["id"],
            childColumns = ["episodeId"],
            onDelete = ForeignKey.CASCADE
        )

    ])
class CharacterEpisodeObject(
    val characterId: Int,
    val episodeId: Int,
)