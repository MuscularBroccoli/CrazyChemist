package com.ngdroidapp.FirebaseConnection;

public class Element {
    private String name;
    private String symbol;
    private String classification;
    private String classificationType;
    private int id;
    private int proton;
    private int neutron;
    private int electron;
    private float atomicWeight;
    private boolean visibility;

    public Element() {

    }

    public Element(String name, String symbol, String classification, String classificationType, int id, int proton, int neutron, int electron, float atomicWeight, boolean visibility) {
        this.name = name;
        this.symbol = symbol;
        this.classification = classification;
        this.classificationType = classificationType;
        this.id = id;
        this.proton = proton;
        this.neutron = neutron;
        this.electron = electron;
        this.atomicWeight = atomicWeight;
        this.visibility = visibility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getClassificationType() {
        return classificationType;
    }

    public void setClassificationType(String classificationType) {
        this.classificationType = classificationType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProton() {
        return proton;
    }

    public void setProton(int proton) {
        this.proton = proton;
    }

    public int getNeutron() {
        return neutron;
    }

    public void setNeutron(int neutron) {
        this.neutron = neutron;
    }

    public int getElectron() {
        return electron;
    }

    public void setElectron(int electron) {
        this.electron = electron;
    }

    public float getAtomicWeight() {
        return atomicWeight;
    }

    public void setAtomicWeight(float atomicWeight) {
        this.atomicWeight = atomicWeight;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }
}
