package com.viviansanches.serieservice.service;

import com.viviansanches.serieservice.model.Serie;

import java.util.List;

public interface SerieService {
    List<Serie> getSeriesByGenre(String genre);

    List<Serie> getSeries();

    Serie getSerieById(String serieId);

    Serie saveSerie(Serie serie);
}
