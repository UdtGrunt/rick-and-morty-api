package org.mathieu.cleanrmapi.domain.models.episode

/**
 * `Episode` is a data class that represents an episode in a series.
 * Each property in the class represents a different attribute of an episode.
 *
 * @property id Unique identifier of the episode.
 * @property name Name of the episode.
 * @property airDate Air date of the episode.
 * @property episode Episode number.
 * @property url URL pointing to the episode's page.
 */
data class Episode(
    val id: Int,
    val name: String,
    val airDate: String,
    val episode: String,
    val url: String,
)