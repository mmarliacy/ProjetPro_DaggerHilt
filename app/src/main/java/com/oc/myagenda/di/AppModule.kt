package com.oc.myagenda.di

import android.app.Application
import androidx.room.Room
import com.oc.myagenda.database.room.AgendaDatabase
import com.oc.myagenda.database.room.repository.AppointmentRepoImpl
import com.oc.myagenda.database.room.repository.CustomerRepoImpl
import com.oc.myagenda.database.room.repository.SectionRepoImpl
import com.oc.myagenda.database.room.repository.ServiceRepoImpl
import com.oc.myagenda.database.room.repository.requests.AppointmentRepository
import com.oc.myagenda.database.room.repository.requests.CustomerRepository
import com.oc.myagenda.database.room.repository.requests.SectionRepository
import com.oc.myagenda.database.room.repository.requests.ServiceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(context : Application) : AgendaDatabase {
        return Room.databaseBuilder(context, AgendaDatabase::class.java, "database").build()
    }

    @Provides
    @Singleton
    fun provideAppointmentRepo(db : AgendaDatabase) : AppointmentRepository {
        return AppointmentRepoImpl(db.appointmentDao)
    }

    @Provides
    @Singleton
    fun provideCustomerRepo(db : AgendaDatabase) : CustomerRepository {
        return CustomerRepoImpl(db.customerDao)
    }

    @Provides
    @Singleton
    fun provideSectionRepo(db : AgendaDatabase) : SectionRepository {
        return SectionRepoImpl(db.sectionDao)
    }

    @Provides
    @Singleton
    fun provideServiceRepo(db : AgendaDatabase) : ServiceRepository {
        return ServiceRepoImpl(db.serviceDao)
    }


}