package com.example.myapplication.ui.util

import arrow.core.memoize
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.disk.DiskCache
import coil3.disk.directory
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import kotlinx.coroutines.Dispatchers

val imageLoader: (PlatformContext) -> ImageLoader = ::provideImageLoader.memoize()

private fun provideImageLoader(context: PlatformContext): ImageLoader =
    ImageLoader(context = context).newBuilder()
        .coroutineContext(Dispatchers.IO)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .memoryCache {
            MemoryCache.Builder()
                .maxSizePercent(context, 0.02)
                .build()
        }
        .diskCachePolicy(CachePolicy.ENABLED)
        .diskCache {
            DiskCache.Builder()
                .maxSizePercent(0.02)
                .directory(context.cacheDir)
                .build()
        }
//        .logger(DebugLogger())
        .build()
        .also { println("Image loader created") }