package com.example.homework_1_month7.data.repositories

import com.example.homework_1_month7.data.database.dao.Country
import com.example.homework_1_month7.data.database.dao.CountryDao
import com.example.homework_1_month7.domain.CountryRepository
import com.example.homework_1_month7.domain.mappers.mapToContactEntity
import com.example.homework_1_month7.domain.models.CountryEntity
import com.example.homework_1_month7.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CountryRepositoriesImpl @Inject constructor(
    private val countryDao: CountryDao
) : CountryRepository {

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

    override fun createCountry(country: Country): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                Resource.Success(countryDao.createCountry(country))
            } catch (e: Exception) {
                Resource.Error(e.localizedMessage)
            }
        }
    }

    override fun updateCountry(country: Country): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                Resource.Success(countryDao.updateCountry(country))
            } catch (e: Exception) {
                Resource.Error(e.localizedMessage)
            }
        }
    }

    override fun deleteCountry(country: Country): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                Resource.Success(countryDao.deleteCountry(country))
            }catch (e: Exception) {
                Resource.Error(e.localizedMessage)
            }
        }
    }
}