package com.soulsensei.app.data.model

data class ApiResponse(
    val data: Data
)

data class Data(
    val rail: Rail,
    val railPageFaqs: List<RailPageFaq>
)

data class Rail(
    val name: String,
    val items: List<RailItem>,
    val bgImage: String
)

data class RailItem(
    val id: String,
    val name: String,
    val shortDescription: String,
    val image: String,
    val slug: String,
    val about: String
)

data class RailPageFaq(
    val question: String,
    val answer: String
)
