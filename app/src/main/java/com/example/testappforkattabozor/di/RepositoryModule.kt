package com.example.testappforkattabozor.di

import com.example.testappforkattabozor.data.api.ProductApi
import com.example.testappforkattabozor.data.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieDataSource(productApi: ProductApi): ProductRepository {
        return ProductRepository(productApi)
    }
}