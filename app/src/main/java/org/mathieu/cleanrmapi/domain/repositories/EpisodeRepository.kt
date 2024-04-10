package org.mathieu.cleanrmapi.domain.repositories

import org.mathieu.cleanrmapi.domain.models.episode.Episode

interface EpisodeRepository {

    /**
     * `getEpisodes` is a suspend function that fetches all episodes for a given character.
     *
     * @property characterId Unique identifier of the character.
     * @return List of `Episode` objects corresponding to the character.
     */
    suspend fun getEpisodes(characterId : Int): List<Episode>
}