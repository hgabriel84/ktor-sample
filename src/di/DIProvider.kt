package com.example.di

import com.example.services.BookService
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

fun DI.MainBuilder.bindServies() {
    bind<BookService>() with singleton { BookService() }
}