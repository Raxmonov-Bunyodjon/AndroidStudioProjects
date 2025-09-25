package com.example.studenthub.domain.usecase


import com.example.studenthub.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow


/** UseCase for retrieving currently logged-in user.
 *
 * @param repo UserRepository instance
 */
class GetCurrentUserUseCase(
    private val repo: UserRepository
){
    /**
     * Returns Flow<String?> of currently signed-in username.
     * */

    operator fun invoke(): Flow<String?> {
        return repo.userUsernameFlow
    }
}
