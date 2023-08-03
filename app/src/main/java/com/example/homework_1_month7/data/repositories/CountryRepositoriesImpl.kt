package com.example.homework_1_month7.data.repositories

import com.example.homework_1_month7.data.database.dao.Country
import com.example.homework_1_month7.data.database.dao.CountryDao
import com.example.homework_1_month7.domain.CountryRepository
import com.example.homework_1_month7.data.mappers.mapToContactEntity
import com.example.homework_1_month7.domain.models.CountryEntity
import com.example.homework_1_month7.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CountryRepositoriesImpl @Inject constructor(
    private val countryDao: CountryDao
) : CountryRepository {

    private lateinit var country: Country

    override fun getCountry(): Flow<Resource<List<CountryEntity>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = countryDao.getCountry()
                emit(Resource.Success(data.mapToContactEntity()))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage))
            }
        }
    }

    override fun createCountry(countryEntity: CountryEntity): Flow<Resource<CountryEntity>> {
        return flow {
            emit(Resource.Loading())
            try {
                Resource.Success(countryDao.createCountry(country))
            } catch (e: Exception) {
                e.localizedMessage?.let { Resource.Error(it) }
            }
        }
    }

    override fun updateCountry(countryEntity: CountryEntity): Flow<Resource<CountryEntity>> {
        return flow {
            emit(Resource.Loading())
            try {
                Resource.Success(countryDao.updateCountry(country))
            } catch (e: Exception) {
                e.localizedMessage?.let { Resource.Error(it) }
            }
        }
    }

    override fun deleteCountry(countryEntity: CountryEntity): Flow<Resource<CountryEntity>> {
        return flow {
            emit(Resource.Loading())
            try {
                Resource.Success(countryDao.deleteCountry(country))
            } catch (e: Exception) {
                e.localizedMessage?.let { Resource.Error(it) }
            }
        }
    }
}