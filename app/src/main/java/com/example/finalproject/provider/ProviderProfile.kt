package com.example.finalproject.provider

import com.example.finalproject.model.Animal

class ProviderProfile {
    companion object {
        val listProfile: MutableList<Animal> = mutableListOf(
            Animal(
                "Firulais",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a ty",
                17,
                "Pitbul"
            ),
            Animal(
                "Balto",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a ty",
                13,
                "Golden"
            ),
            Animal(
                "Chester",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a ty",
                17,
                "Pastor Alemán"
            )
        )
    }
}