package io.github.ritter4u.POCGISAPI.Config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class AppConfig {
    @Bean
    fun ModelMapper() {
        return ModelMapper()
    }
}