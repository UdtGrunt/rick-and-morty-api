package org.mathieu.cleanrmapi.data.repositories

import org.mathieu.cleanrmapi.data.local.EpisodeDAO
import org.mathieu.cleanrmapi.data.local.objects.CharacterEpisodeObject
import org.mathieu.cleanrmapi.data.local.objects.toModel
import org.mathieu.cleanrmapi.data.local.objects.toRoomObject
import org.mathieu.cleanrmapi.data.remote.CharacterApi
import org.mathieu.cleanrmapi.data.remote.EpisodeAPI
import org.mathieu.cleanrmapi.domain.models.episode.Episode
import org.mathieu.cleanrmapi.domain.repositories.EpisodeRepository

class EpisodeRepositoryImpl(
    private val episodeApi: EpisodeAPI,
    private val episodeLocal : EpisodeDAO,
    private val characterApi: CharacterApi
) : EpisodeRepository {
    /**
     * `getEpisodes` is a suspend function that fetches all episodes for a given character.
     * It first checks the local database for the episodes. If not found, it fetches the data from the API,
     * stores it in the local database, and then returns the episodes.
     *
     * @property characterId Unique identifier of the character.
     * @return List of `Episode` objects corresponding to the character.
     * @throws Exception if the character is not found.
     */
    override suspend fun getEpisodes(characterId: Int): List<Episode> {
        // Get all episodes for the character
        val episodesLocal = episodeLocal.getEpisodesForCharacter(characterId)
        if (episodesLocal.isNotEmpty()) {
            return episodesLocal.map { it.toModel() }
        }

        val episodesToLoad = characterApi.getCharacter(characterId)?.episode?.mapNotNull {
            it.substringAfterLast("/").toIntOrNull()
        } ?: throw Exception("Character not found.")
        val episodes = episodeApi.getEpisodes(episodesToLoad)
            .map { it.toRoomObject() }

        episodeLocal.insert(episodes)

        val episodesLinks = episodes.map {
            CharacterEpisodeObject(
                characterId = characterId,
                episodeId = it.id
            )
        }
        episodeLocal.createLink(episodesLinks)


        return episodes.map { it.toModel() }
    }
}