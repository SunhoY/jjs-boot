package com.jjs.present.dto;

import com.jjs.present.type.PosteriorType;

public class PosteriorForm {
    private int population;
    private float reliability;
    private float confidenceLevel;
    private int defectiveItem;
    private int hyperParameterA;
    private int hyperParameterB;
    private int maximumDefectItem;

    public PosteriorType getPosteriorType() {
        return posteriorType;
    }

    public void setPosteriorType(PosteriorType posteriorType) {
        this.posteriorType = posteriorType;
    }

    private PosteriorType posteriorType;

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public float getReliability() {
        return reliability;
    }

    public void setReliability(float reliability) {
        this.reliability = reliability;
    }

    public float getConfidenceLevel() {
        return confidenceLevel;
    }

    public void setConfidenceLevel(float confidenceLevel) {
        this.confidenceLevel = confidenceLevel;
    }

    public int getDefectiveItem() {
        return defectiveItem;
    }

    public void setDefectiveItem(int defectiveItem) {
        this.defectiveItem = defectiveItem;
    }

    public int getHyperParameterA() {
        return hyperParameterA;
    }

    public void setHyperParameterA(int hyperParameterA) {
        this.hyperParameterA = hyperParameterA;
    }

    public int getHyperParameterB() {
        return hyperParameterB;
    }

    public void setHyperParameterB(int hyperParameterB) {
        this.hyperParameterB = hyperParameterB;
    }

    public int getMaximumDefectItem() {
        return maximumDefectItem;
    }

    public void setMaximumDefectItem(int maximumDefectItem) {
        this.maximumDefectItem = maximumDefectItem;
    }
}
