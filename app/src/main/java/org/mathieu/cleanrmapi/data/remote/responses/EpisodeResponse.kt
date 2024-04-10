package org.mathieu.cleanrmapi.data.remote.responses

import kotlinx.serialization.Serializable


/**
 * `EpisodeResponse` is a data class that represents an episode response from a data source.
 * It's annotated with `@Serializable`, which means it can be serialized into a format that can be stored.
 *
 * @property id Unique identifier of the episode.
 * @property name Name of the episode.
 * @property air_date Air date of the episode.
 * @property episode Episode number.
 * @property characters List of characters in the episode.
 * @property url URL pointing to the episode's page.
 * @property created Timestamp indicating when the episode entity was created in the database.
 */
@Serializable
data class EpisodeResponse(
    val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,
    val characters: List<String>,
    val url: String,
    val created: String
)