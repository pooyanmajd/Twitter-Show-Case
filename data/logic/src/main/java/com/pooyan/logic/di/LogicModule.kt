package com.pooyan.logic.di

import com.pooyan.domain.network.NetworkMonitor
import com.pooyan.domain.user.UserDataRepository
import com.pooyan.logic.network.ConnectivityManagerNetworkMonitor
import com.pooyan.logic.repository.UserDataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface LogicModule {
    @Binds
    fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor,
    ): NetworkMonitor

    @Binds
    fun bindsUserDataRepository(
        userDataRepository: UserDataRepositoryImpl,
    ): UserDataRepository
}