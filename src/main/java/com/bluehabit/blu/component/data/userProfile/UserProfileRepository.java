/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.blu.component.data.userProfile;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserProfileRepository extends PagingAndSortingRepository<UserProfile, String>, CrudRepository<UserProfile, String> {

}
